package com.employee.empController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.LoginRequestDto;
import com.employee.dto.LoginResponseDto;
import com.employee.dto.SignupResponseDto;
import com.employee.security.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
		
		return new ResponseEntity<LoginResponseDto>(authService.login(loginRequestDto),HttpStatus.OK);
		
	}
	
	@PostMapping("/signup")
	public ResponseEntity<SignupResponseDto> signup(@RequestBody LoginRequestDto signupRequestDto){
		
		return new ResponseEntity<SignupResponseDto>(authService.signup(signupRequestDto),HttpStatus.OK);
		
	}
	
	

}
