package auth.pluriel.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import auth.pluriel.dto.requests.UserRequestDto;
import auth.pluriel.dto.responses.UserResponseDto;
import auth.pluriel.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {


	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
	
	User convertRequestToEntity(UserRequestDto UserRequest);
	
	User convertResponseToEntity(UserResponseDto UserResponse);
	
	UserResponseDto convertEntityToResponse(User User);
}
