package hr.rba.rba_challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class UserModelDTO {
	private String name;
	private String surname;
	private String oib;
	private Integer status;
}

