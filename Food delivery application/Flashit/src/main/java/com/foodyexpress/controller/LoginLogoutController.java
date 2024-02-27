package com.foodyexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodyexpress.exception.LoginException;
import com.foodyexpress.model.LoginDTO;
import com.foodyexpress.service.LoginService;

@RestController
@RequestMapping("/app")
public class LoginLogoutController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/log")
	public ResponseEntity<String> logIn(@RequestBody LoginDTO loginDTO) throws LoginException {
		String result = loginService.loginAccount(loginDTO);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logout(@RequestParam(required = false) String role,
			@RequestParam(required = false) String key) throws LoginException {
		String result = loginService.logoutAccount(role, key);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
