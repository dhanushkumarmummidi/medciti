package com.loginManagement.loginSecure.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loginManagement.loginSecure.UserManagement.model.User;
import com.loginManagement.loginSecure.filters.JwtRequestFilter;
import com.loginManagement.loginSecure.loginModel.Users;
import com.loginManagement.loginSecure.order.bean.CreateNewUserBean;
import com.loginManagement.loginSecure.services.UserRepository;


@CrossOrigin
@RestController("")
public class UserManagementSystemController
{
	@Autowired
	private JwtRequestFilter jwtfilter;
	@Autowired 
	private RestTemplate restTemplate;
	@Autowired
	private UserRepository repo;
	HttpHeaders headers = new HttpHeaders();
	
	@GetMapping("/api/users/getUsers")
	public List<User> getUsers()
	{
		
		String url = "http://localhost:8081/users/getUsers";
	User[] objects= restTemplate.getForObject(url, User[].class);
		
		return Arrays.asList(objects);  
	}
	
	@GetMapping("/api/users/getUsersByAccess")
	public List<User> getUsersByAccess()
	{
		System.out.println(jwtfilter.getName());
    	Users users= repo.findByUsername(jwtfilter.getName());
    	System.out.println(repo.findByUsername(jwtfilter.getName()));
    	long id=repo.findByUsername(jwtfilter.getName()).getId();
		
		String url = "http://localhost:8081/users/getUsersByAccess?userId="+id;
		User[] objects= restTemplate.getForObject(url, User[].class);
		
		return Arrays.asList(objects);  
	}
	@RequestMapping(value="/api/users/searchUsersByAccess",method = RequestMethod.GET)
	@ResponseBody
	public List<User> searchUsersByAccess(@RequestParam(value="search")String search)
	{
		System.out.println(jwtfilter.getName());
    	Users users= repo.findByUsername(jwtfilter.getName());
    	System.out.println(repo.findByUsername(jwtfilter.getName()));
    	long id=repo.findByUsername(jwtfilter.getName()).getId();
		
		String url = "http://localhost:8081/users/searchUsersByAccess?userId="+id+"&search="+search;
		User[] objects= restTemplate.getForObject(url, User[].class);
		
		return Arrays.asList(objects);  
	}
	
	@RequestMapping(value="/api/users/getUser/{id}",method = RequestMethod.GET)	
	@ResponseBody
	public User getUser(@PathVariable("id") int userId) 
	{
		String url = "http://localhost:8081/users/getUser?userId="+userId;
		User objects =restTemplate.getForObject(url, User.class);
		System.out.println(objects);
		return objects;
	}
	@RequestMapping(value = "api/users/saveNewUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> saveNewUser(@RequestBody User user)
	{
		System.out.println(jwtfilter.getName());
    	Users users= repo.findByUsername(jwtfilter.getName());
    	System.out.println(repo.findByUsername(jwtfilter.getName()));
		String url = "http://localhost:8081/users/saveNewUser";
		System.out.println(user);
		CreateNewUserBean createNewUserBean= new CreateNewUserBean();
		createNewUserBean.setRequestUserId(users.getId());
		createNewUserBean.setUser(user);
		
		 ResponseEntity<String> response =restTemplate.postForEntity(url, createNewUserBean, String.class);
		return response;
	}
	@RequestMapping(value = "api/users/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public void updateUser(@RequestBody User user) 
	{
		String url = "http://localhost:8081/users/updateUser";
		System.out.println(user);
		HttpEntity<User> requestUpdate = new HttpEntity<>(user, headers);
		restTemplate.exchange(url,HttpMethod.POST,requestUpdate,User.class);
	}
	
	@RequestMapping(value = "api/users/deleteUser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		String url = "http://localhost:8081/users/deleteUser";
		String entityUrl = url + "?id=" + id;
		CreateNewUserBean createNewUserBean= new CreateNewUserBean();
		Users use1=repo.findByUsername(jwtfilter.getName());
		Optional<Users>use=repo.findById(id);
		
		createNewUserBean.setRequestUserId(use1.getId());
		User delUser = new User();
		delUser.setAccess(use.get().getAccess());
		delUser.setDesignation(use.get().getDesignation());
		delUser.setEmail(use.get().getEmail());
		delUser.setId(Integer.parseInt(use.get().getId()+""));
		delUser.setLocationId(use.get().getLocationId());
		delUser.setname(use.get().getUsername());
		delUser.setPassword(use.get().getPassword());
		delUser.setQualification(use.get().getQualification());
		createNewUserBean.setUser(delUser);
		return restTemplate.postForEntity(entityUrl,delUser ,String.class);
	}
	@RequestMapping(value="/api/users/getUr/{id}",method = RequestMethod.GET)	
	@ResponseBody
	public String getUer(@PathVariable("id") int userId) 
	{
		String url = "http://localhost:8081/users/getUser?id="+userId;
		String objects =restTemplate.getForObject(url, String.class);
		
		System.out.println(objects);
		return objects;
	}
}
