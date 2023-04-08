package net.pluriel.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.pluriel.dto.requests.UserRequestDto;
import net.pluriel.dto.responses.UserResponseDto;
import net.pluriel.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {


	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
	
	User convertRequestToEntity(UserRequestDto UserRequest);
	
	User convertResponseToEntity(UserResponseDto UserResponse);
	
	UserResponseDto convertEntityToResponse(User User);
}
