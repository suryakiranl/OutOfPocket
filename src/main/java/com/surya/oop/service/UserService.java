package com.surya.oop.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.surya.oop.dto.User;

@Path("/users")
public class UserService {
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@XmlElementWrapper(name = "users")
	public List<User> fetchAll() {
		User u = new User();
		u.setId(1);
		u.setFirstName("Surya");
		u.setEmail("suryakiranl@gmail.com");
		u.setPassword("MAJKSHDKJASHDA");
		u.setAccountType(User.AccountType.NATIVE);
		
		User u2 = new User();
		u2.setId(2);
		u2.setFirstName("Swarna");
		u2.setEmail("sgowri@gmail.com");
		u2.setPassword("asdasdasdasd");
		u2.setAccountType(User.AccountType.THIRD_PARTY);
		
		ArrayList<User> list = new ArrayList<User>();
		list.add(u);
		list.add(u2);
		
		return list;
	}
	
	@GET
	@Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	@Path("/{id}")
	public User findUser(@PathParam("id") Long id) {
		User u = new User();
		u.setId(id);
		u.setFirstName("Surya");
		u.setEmail("suryakiranl@gmail.com");
		u.setPassword("MAJKSHDKJASHDA");
		u.setAccountType(User.AccountType.NATIVE);
		
		return u;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public User createUser(User user) {
		System.out.println("Inside POST method of User :" + user);
		
		return user;
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public User updateUser(User user) {
		System.out.println("Inside POST method of User :" + user);
		
		return user;
	}
	
	@DELETE
	@Path("/delete/{id}")
	public void deleteUser(@PathParam("id") Long id) {
		System.out.println("User requested for deletion: " + id);
	}
	
}
