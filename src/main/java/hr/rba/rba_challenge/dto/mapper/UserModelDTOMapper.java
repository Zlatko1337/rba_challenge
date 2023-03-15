package hr.rba.rba_challenge.dto.mapper;

import hr.rba.rba_challenge.controller.request.UserRequest;
import hr.rba.rba_challenge.dto.UserModelDTO;


public class UserModelDTOMapper {

    public UserModelDTO mapToDTO(UserRequest request) {
        return new UserModelDTO(request.getName(),
        						request.getSurname(),
        						request.getOib(),
        						request.getStatus()); 
    }

}
