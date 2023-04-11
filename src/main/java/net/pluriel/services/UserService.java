package net.pluriel.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import net.pluriel.authRequests.ChangePasswordRequest;
import net.pluriel.dto.requests.UserRequestDto;
import net.pluriel.dto.responses.UserResponseDto;

public interface UserService {
	public UserResponseDto create(UserRequestDto UserRequestDto);
	public UserResponseDto getOne(Integer id);
	public UserResponseDto update(UserRequestDto UserRequestDto, Integer id);
	public String changePassword(ChangePasswordRequest changePasswordRequest, Integer id);
	public List<UserResponseDto> getAll();
	public Page<UserResponseDto> getAllInPage(int page, int size);
	public void delete(Integer UserId);
}
