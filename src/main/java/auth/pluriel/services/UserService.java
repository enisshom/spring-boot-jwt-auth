package auth.pluriel.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import auth.pluriel.authRequests.ChangePasswordRequest;
import auth.pluriel.dto.requests.UserRequestDto;
import auth.pluriel.dto.responses.UserResponseDto;

public interface UserService {
	public UserResponseDto create(UserRequestDto UserRequestDto);
	public UserResponseDto getOne(Integer id);
	public UserResponseDto update(UserRequestDto UserRequestDto, Integer id);
	public String changePassword(ChangePasswordRequest changePasswordRequest, Integer id);
	public List<UserResponseDto> getAll();
	public Page<UserResponseDto> getAllInPage(int page, int size);
	public void delete(Integer UserId);
}
