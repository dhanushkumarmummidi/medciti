package com.technocrat.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.technocrat.user.Bean.CreateUserBean;
import com.technocrat.user.Bean.DefaultResponse;
import com.technocrat.user.Exceptions.UserNotFoundException;
import com.technocrat.user.model.User;
import com.technocrat.user.service.UserServiceI;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserCrudController {
	
	@Autowired
	private UserServiceI userService;
	
	@RequestMapping(value ="/getUsers",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getUsers(){
		return userService.get();
	}
	@RequestMapping(value ="/getUsersByAccess",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getUsers(@RequestParam(value="userId")int userId){
		return userService.getUsersByAccess(userId);
	}
	@RequestMapping(value ="/searchUsersByAccess",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> searchUsersByAccess(@RequestParam(value="userId")int userId,@RequestParam(value="search")String search){
		return userService.searchUsersByAccess(userId,search);
	}
	@RequestMapping("/getUsersPagination")
	@ResponseBody
	public DefaultResponse<List<User>> getUsers(@RequestParam(value="pageStart")int pageStart,@RequestParam(value="pageEnd")int pageEnd){
		return new DefaultResponse<List<User>>("200", "ok", userService.get(pageStart,pageEnd));
	}
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(@RequestParam(value="id")int userId) {
		return userService.get(userId);
	}
	@RequestMapping(value = "/saveNewUser", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse<String> saveNewUser(@RequestBody CreateUserBean<User> request) {
		DefaultResponse<String> response = new DefaultResponse<String>();
		try {
			userService.saveUser(request.getUser(),request.getRequestUserId());
			response.setStatus("200");
			response.setDescription("User created sucessfuly");
		} catch (Exception e) {
			response.setStatus("400");
			response.setDescription(e.getMessage());
		}
		System.out.println("Added user with response "+response);
		return response;
	}
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse<String> updateUser(@RequestBody CreateUserBean<User> request) {
		DefaultResponse<String> response = new DefaultResponse<String>();
		try {
			userService.updateUser(request.getUser(),request.getRequestUserId());
			response.setStatus("200");
			response.setDescription("User updated sucessfuly");
		} catch (Exception e) {
			response.setStatus("400");
			response.setDescription(e.getMessage());
		}
		return response;
		
	}
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse<String> deleteUser(@RequestBody CreateUserBean<Integer> request) {
		DefaultResponse<String> response = new DefaultResponse<String>();
		try {
			userService.deleteUser(request.getUser(),request.getRequestUserId());
			response.setStatus("200");
			response.setDescription("User deleted sucessfuly");
		} catch (Exception e) {
			response.setStatus("400");
			response.setDescription(e.getMessage());
		}
		return response;
		
	}
	@RequestMapping(value = "/updateUserAccess", method = RequestMethod.POST)
	@ResponseBody
	public void updateUserAccess(@RequestParam(value="id") int id ,@RequestParam(value="access")boolean access ) {
		userService.updateUserAccess(id,access);
	}
	
	@RequestMapping(value="/getStoreUsers")
	@ResponseBody
	public DefaultResponse<List<User>>  getUsersByAccess(@RequestParam(value="id")int userId) {
		DefaultResponse<List<User>> userResponse = new DefaultResponse<List<User>>();
		userResponse.setData(userService.getUsersByAccess(userId));
		userResponse.setStatus("200");
		return userResponse;
	}
	 
	
}
