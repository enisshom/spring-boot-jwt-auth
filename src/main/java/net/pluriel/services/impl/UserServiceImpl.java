package net.pluriel.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.pluriel.authRequests.ChangePasswordRequest;
import net.pluriel.dto.mapper.UserMapper;
import net.pluriel.dto.requests.UserRequestDto;
import net.pluriel.dto.responses.UserResponseDto;
import net.pluriel.entities.Role;
import net.pluriel.entities.User;
import net.pluriel.exceptions.NotFound;
import net.pluriel.exceptions.RestException;
import net.pluriel.repositories.TokenRepository;
import net.pluriel.repositories.UserRepository;
import net.pluriel.security.jwt.JwtService;
import net.pluriel.services.UserService;
@Service @Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper UserMapper;
	
	@Autowired
	private UserRepository UserRepository;

	@Override
	public UserResponseDto create(UserRequestDto UserRequestDto) {
		User UserRequest = UserMapper.convertRequestToEntity(UserRequestDto);
		//en peut utiliser PasswordEncoder aussi
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		
        UserRequest.setLastname(UserRequest.getLastname().toUpperCase());
        UserRequest.setRole(Role.User);
        UserRequest.setPassword(encoder.encode(UserRequest.getPassword()));
		UserRepository.save(UserRequest);
		return UserMapper.convertEntityToResponse(UserRequest);
	}

	@SneakyThrows
	@Override
	public UserResponseDto getOne(Integer id){
		User User = UserRepository.findById(id).orElseThrow(() -> new NotFound("Not Found"));
//		Optional<User> UserOpt = UserRepository.findById(id);
//		User User = null;
//		if(UserOpt.isPresent()) {
//			User = UserOpt.get();
//		}else {
//			throw new Exception("Not Found");
//		}
		return UserMapper.convertEntityToResponse(User);
	}

	@SneakyThrows
	@Override
	public UserResponseDto update(UserRequestDto UserRequestDto, Integer id) {
		User User = UserRepository.findById(id).orElseThrow(() -> new NotFound("Not Found"));
		User UserRequest = UserMapper.convertRequestToEntity(UserRequestDto);
		
		
		
		User.setLastname(UserRequest.getLastname().toUpperCase());
		User.setEmail(UserRequest.getEmail());
		User.setFirstname(UserRequest.getFirstname().toLowerCase());
		
		UserRepository.save(User);
		
		return UserMapper.convertEntityToResponse(User);
	}

	@Override
	public List<UserResponseDto> getAll() {
		List<User> all = UserRepository.findAll();
		List<UserResponseDto> result = all.stream().map(UserMapper::convertEntityToResponse).collect(Collectors.toList());
		return result;
	}

	@Override
	public Page<UserResponseDto> getAllInPage(int page, int size) {
		return UserRepository.findAll(PageRequest.of(page, size)).map(UserMapper::convertEntityToResponse);
	}
	@SneakyThrows
	@Override
	public void delete(Integer UserId) {
		// TODO Auto-generated method stub
		User User = UserRepository.findById(UserId).orElseThrow(() -> new Exception("Not Found"));
		UserRepository.delete(User);
		
	}
	
	@SneakyThrows
	@Override
	public String changePassword(ChangePasswordRequest changePasswordRequest, Integer id) {
		// TODO Auto-generated method stub
		User user = UserRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		
		if(encoder.matches(changePasswordRequest.getOldPassword(), user.getPassword())) {
			if(!(changePasswordRequest.getNewPassword().equals(changePasswordRequest.getOldPassword()))) {
			if(changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmPassword())) {
				user.setPassword(encoder.encode(changePasswordRequest.getNewPassword()));
				UserRepository.save(user);
				return "you have changed your password successfully  ";
			}
			return " your new password does not match the confirm password ";
			}
			return " your new password  is the same as your old password ";
		}
		return "the old password is not correct" ;
	}
	
}
