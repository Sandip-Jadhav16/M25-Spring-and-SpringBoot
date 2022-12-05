package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {


	@Autowired
    private UserService service;
	
	//creation
	@PostMapping("/User")
	public void add(@RequestBody User u)
	{
		service.create(u);
	}
	
	//deletion
	@DeleteMapping("/User/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	
	//Retrieve all records
	@GetMapping("/User")
	public List<User> List()
	{
		return service.ListAll();
	}
	
	//retrieve with specific id
	@GetMapping("/User/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id)
	{
		try {
		User u=service.retrieve(id);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	       }
		catch(NoSuchElementException e)
		{
		 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
        }
	
	//updation
	@PutMapping("/User/{id}")
	public ResponseEntity<User> update(@RequestBody User u,@PathVariable Integer id)
	{
		try {
		User u1=service.retrieve(id);
		service.create(u);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	       }
		catch(NoSuchElementException e)
		{
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
         }
	}
	

}
