package hr.rba.rba_challenge.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.rba.rba_challenge.dto.UserModelDTO;
import hr.rba.rba_challenge.exception.ResourceNotFoundException;
import hr.rba.rba_challenge.model.UserModel;
import hr.rba.rba_challenge.model.mapper.UserModelMapper;
import hr.rba.rba_challenge.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public String create(UserModelDTO userModelDTO) {
    	return userRepository.save(new UserModelMapper().mapToModel(userModelDTO)).getOib();
    }

    public Integer remove(String oib){
    	return userRepository.deleteUserByOib(oib, Calendar.getInstance().getTime().toInstant());
    }
    
    public UserModelDTO getUserByOib(String oib) {
    	UserModel userModel = userRepository.findByOib(oib);
    	if(userModel == null)
    		throw new ResourceNotFoundException(String.format("User with OIB %s not found", oib));
    	else
    		return new UserModelDTO(userModel.getName(), userModel.getSurname(), userModel.getOib(), userModel.getStatus());
    }
    
    public void createUserFile(String oib) throws IOException {
    	UserModel userModel = userRepository.findByOib(oib);
		if (userModel == null)
			throw new ResourceNotFoundException(String.format("User with OIB %s not found", oib));
		else
			
			try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get(oib+Calendar.getInstance().getTimeInMillis())))) {
				writer.printf("%s;%s;%s;%d", userModel.getName(), userModel.getSurname(), userModel.getOib(), userModel.getStatus());
				writer.println();
			}
		
			//TODO save file path and some other file releated data to database 
			//TODO make file creation and saving to the database as one transaction (see TransactionSynchronizationManager)
    }
    
}
