package com.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entitie.TypeDepense;
import com.auth.entitie.User;
import com.auth.entitie.UserResponse;
import com.auth.repository.UserRepository;
import com.auth.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRep ;

	@PostMapping("/signin")
	@ApiOperation(value = "${UserController.signin}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 422, message = "Invalid username/password supplied") })
	public UserResponse login(//
			@ApiParam("username")@RequestBody User user) {
		
		return userService.signin(user);
	}

//	  @PostMapping("/signup")
//	  @ApiOperation(value = "${UserController.signup}")
//	  @ApiResponses(value = {//
//	      @ApiResponse(code = 400, message = "Something went wrong"), //
//	      @ApiResponse(code = 403, message = "Access denied"), //
//	      @ApiResponse(code = 422, message = "Username is already in use"), //
//	      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//	  public String signup(@ApiParam("Signup User") @RequestBody UserDataDTO user) {
//	    return userService.signup(modelMapper.map(user, User.class));
//	  }

	@DeleteMapping(value = "/{username}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "${UserController.delete}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 404, message = "The user doesn't exist"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public String delete(@ApiParam("Username") @PathVariable String username) {
		userService.delete(username);
		return username;
	}

//	  @GetMapping(value = "/{username}")
//	  @PreAuthorize("hasRole('ROLE_ADMIN')")
//	  @ApiOperation(value = "${UserController.search}", response = UserResponseDTO.class)
//	  @ApiResponses(value = {//
//	      @ApiResponse(code = 400, message = "Something went wrong"), //
//	      @ApiResponse(code = 403, message = "Access denied"), //
//	      @ApiResponse(code = 404, message = "The user doesn't exist"), //
//	      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//	  public UserResponseDTO search(@ApiParam("Username") @PathVariable String username) {
//	    return modelMapper.map(userService.search(username), UserResponseDTO.class);
//	  }

//	  @GetMapping(value = "/me")
//	  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
//	  @ApiOperation(value = "${UserController.me}", response = UserResponseDTO.class)
//	  @ApiResponses(value = {//
//	      @ApiResponse(code = 400, message = "Something went wrong"), //
//	      @ApiResponse(code = 403, message = "Access denied"), //
//	      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//	  public UserResponseDTO whoami(HttpServletRequest req) {
//	    return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
//	  }

	@GetMapping("/refresh")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
	public String refresh(HttpServletRequest req) {
		return userService.refresh(req.getRemoteUser());
	}
	
	@RequestMapping(value="/userss",method=RequestMethod.GET)
	public List<User> getAllUser(){
		return userRep.findAll();
	}

}
