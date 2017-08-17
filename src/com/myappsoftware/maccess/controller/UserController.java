package com.myappsoftware.maccess.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.myappsoftware.maccess.dao.UserDAO;
import com.myappsoftware.maccess.model.User;
import com.myappsoftware.maccess.util.Util;
import org.springframework.http.MediaType;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	private UserDAO userDAO;
	
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String index() {
		List<User> list = userDAO.list();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String get(HttpServletRequest request, @PathVariable("id") String id) {
		int iID = Integer.parseInt(id);
		Gson gson =  new Gson();
		User user = userDAO.get(iID);
		return gson.toJson(user,User.class);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String add(HttpServletRequest request) {
		Util util = new Util();
		Gson gson = new Gson();
		String response = "{'estado':0}";
		int result = 0;
		User user = gson.fromJson(util.getJSON(request), User.class);
		System.out.println(user.toString());
		result = userDAO.insert(user);
		if(result == 1){
            response = "{'estado':"+String.valueOf(result)+"}";
        }
        return gson.toJson(response);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String edit(HttpServletRequest request) {
		Util util = new Util();
		Gson gson = new Gson();
		String response = "{'estado':0}";
		int result = 0;
		User user = gson.fromJson(util.getJSON(request), User.class);
		System.out.println(user.toString());
		result = userDAO.update(user);
		if(result == 1){
            response = "{'estado':"+String.valueOf(result)+"}";
        }
        return gson.toJson(response);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String  delete(HttpServletRequest request, @PathVariable("id") String id) {
		Gson gson = new Gson();
        int iId = Integer.parseInt(id);
        String response = "{'estado':0}";
        int result = 0;
        result = userDAO.delete(iId);
        if(result == 1){
            response = "{'estado':"+String.valueOf(result)+"}";
        }
        return gson.toJson(response);
	}
}
