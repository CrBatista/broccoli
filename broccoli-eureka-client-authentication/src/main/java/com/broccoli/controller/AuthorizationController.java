package com.broccoli.controller;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.broccoli.dto.UserDataDTO;
import com.broccoli.dto.UserResponseDTO;
import com.broccoli.model.User;
import com.broccoli.service.UserService;

@RestController
public class AuthorizationController {

	  @Autowired
	  private UserService userService;

	  @Autowired
	  private ModelMapper modelMapper;

	  @PostMapping("/signin")
	  public String login(@RequestParam String username, @RequestParam String password) {
	    return userService.signin(username, password);
	  }

	  @PostMapping("/signup")
	  public String signup(@RequestBody UserDataDTO user) {
	    return userService.signup(modelMapper.map(user, User.class));
	  }

	  @DeleteMapping(value = "/{username}")
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  public String delete(@PathVariable String username) {
	    userService.delete(username);
	    return username;
	  }

	  @GetMapping(value = "/{username}")
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  public UserResponseDTO search(@PathVariable String username) {
	    return modelMapper.map(userService.search(username), UserResponseDTO.class);
	  }

	  @GetMapping(value = "/me")
	  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
	  public UserResponseDTO whoami(HttpServletRequest req) {
	    return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
	  }

	}
