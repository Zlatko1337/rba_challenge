package hr.rba.rba_challenge.controller.api;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hr.rba.rba_challenge.controller.request.FileUserRequest;
import hr.rba.rba_challenge.controller.request.UserRequest;
import hr.rba.rba_challenge.dto.mapper.UserModelDTOMapper;
import hr.rba.rba_challenge.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@RestController @Validated
public class AppController {

    @Autowired
    private UserService userService;
 
    @GetMapping(path = "/users/{oib}", consumes = "application/rba.v1")
	public ResponseEntity<Object> getUserV1(@PathVariable @Size(min=11,max=11,message ="Oib size needs to be 11") String oib) {	
		return new ResponseEntity<>(userService.getUserByOib(oib), HttpStatus.OK);
	}
        
    @PostMapping(path= "/users", consumes = "application/rba.v1+json")
	public ResponseEntity<Object> createUserV1(@Valid @RequestBody UserRequest request) {
    	String oib = userService.create(new UserModelDTOMapper().mapToDTO(request));  	
		return new ResponseEntity<>(oib, HttpStatus.CREATED); 
	}
    
	@DeleteMapping(path = "/users/{oib}", consumes = "application/rba.v1")
	public ResponseEntity<Object> deleteUserV1(@PathVariable String oib) {
		Integer recordsAffected = userService.remove(oib);
		return new ResponseEntity<>(recordsAffected, HttpStatus.OK);
	}
    
	@PostMapping(path= "/users/file", consumes = "application/rba.v1+json")
	public ResponseEntity<Object> createUserFileV1(@RequestBody FileUserRequest fileUserRequest) throws IOException {
    	userService.createUserFile(fileUserRequest.getOib());
		return new ResponseEntity<>("ok", HttpStatus.CREATED);
	}
	

}
