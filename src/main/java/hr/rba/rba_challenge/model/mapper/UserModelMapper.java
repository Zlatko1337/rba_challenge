package hr.rba.rba_challenge.model.mapper;

import hr.rba.rba_challenge.dto.UserModelDTO;
import hr.rba.rba_challenge.model.UserModel;

public class UserModelMapper {

    public UserModel mapToModel(UserModelDTO dto) {    	
    	UserModel userModel = new UserModel();
    	userModel.setName(dto.getName());
    	userModel.setSurname(dto.getSurname());
    	userModel.setOib(dto.getOib());
    	userModel.setStatus(dto.getStatus());
    	
        return userModel;
    }
}
