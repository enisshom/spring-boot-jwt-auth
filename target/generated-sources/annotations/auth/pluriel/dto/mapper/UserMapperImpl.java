package auth.pluriel.dto.mapper;

import auth.pluriel.dto.requests.UserRequestDto;
import auth.pluriel.dto.responses.UserResponseDto;
import auth.pluriel.dto.responses.UserResponseDto.UserResponseDtoBuilder;
import auth.pluriel.entities.User;
import auth.pluriel.entities.User.UserBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-10T12:34:42+0000",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertRequestToEntity(UserRequestDto UserRequest) {
        if ( UserRequest == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.email( UserRequest.getEmail() );
        user.firstname( UserRequest.getFirstname() );
        user.lastname( UserRequest.getLastname() );
        user.password( UserRequest.getPassword() );

        return user.build();
    }

    @Override
    public User convertResponseToEntity(UserResponseDto UserResponse) {
        if ( UserResponse == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.email( UserResponse.getEmail() );
        user.firstname( UserResponse.getFirstname() );
        user.id( UserResponse.getId() );
        user.lastname( UserResponse.getLastname() );

        return user.build();
    }

    @Override
    public UserResponseDto convertEntityToResponse(User User) {
        if ( User == null ) {
            return null;
        }

        UserResponseDtoBuilder userResponseDto = UserResponseDto.builder();

        userResponseDto.email( User.getEmail() );
        userResponseDto.firstname( User.getFirstname() );
        userResponseDto.id( User.getId() );
        userResponseDto.lastname( User.getLastname() );

        return userResponseDto.build();
    }
}
