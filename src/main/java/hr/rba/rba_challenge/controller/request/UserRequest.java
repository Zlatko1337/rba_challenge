package hr.rba.rba_challenge.controller.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class UserRequest {
    
	@NotEmpty(message = "Name is mandatory") 
	private String name;
	
	@NotEmpty(message = "Surname is mandatory") 
	private String surname;
	
	@NotEmpty(message = "OIB is mandatory") 
	@Size(min = 11, max = 11, message = "OIB needs to be 11 digits long")
	@Pattern(regexp = "^\\d+$", message = "OIB is numeric only")
	private String oib;
	
	@NotNull(message = "Status is mandatory") 
	private Integer status;
  
}
