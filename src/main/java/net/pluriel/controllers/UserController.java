package net.pluriel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.pluriel.authRequests.ChangePasswordRequest;
import net.pluriel.dto.requests.UserRequestDto;
import net.pluriel.dto.responses.UserResponseDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
	@GetMapping
	  public ResponseEntity<String> sayHello() {
	    return ResponseEntity.ok("Hello there !!!!!!!!!!!!!!!!!!!!");
	  }
	

	@Autowired
	private net.pluriel.services.UserService UserService;
	
	@PostMapping
	public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto UserRequestDto){
		return new ResponseEntity<UserResponseDto>(UserService.create(UserRequestDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDto> getOne(@PathVariable(name = "id") Integer UserId){
		return new ResponseEntity<UserResponseDto>(UserService.getOne(UserId), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDto> update(@PathVariable(name = "id") Integer UserId, @RequestBody UserRequestDto UserRequestDto){
		return new ResponseEntity<UserResponseDto>(UserService.update(UserRequestDto, UserId), HttpStatus.OK);
	}
	
	@PutMapping("/changePassword/{id}")
	public ResponseEntity<String> changePassword(@PathVariable(name = "id") Integer UserId, @RequestBody ChangePasswordRequest changePasswordRequest){
		return new ResponseEntity<String>(UserService.changePassword(changePasswordRequest,UserId), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserResponseDto>> getAll(){
		return new ResponseEntity<List<UserResponseDto>>(UserService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/all_paginate")
	public ResponseEntity<Page<UserResponseDto>> getAllPaginate(
			@RequestParam(name = "page") int page,
			@RequestParam(name = "size") int size
		){
		return new ResponseEntity<Page<UserResponseDto>>(UserService.getAllInPage(page, size), HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam(name = "id") Integer UserId){
	 UserService.delete(UserId);
	 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	
}
