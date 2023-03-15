package hr.rba.rba_challenge.controller.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class FileUserRequest {
    
	@NotEmpty(message = "OIB is mandatory") 
	@Size(min = 11, max = 11, message = "OIB needs to be 11 digits long")
	@Pattern(regexp = "^\\d+$", message = "OIB is numeric only")
	private String oib;
  
}
