package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService 
{
	@Autowired
	private UserRepository repo;
	//Retrieve all data 
	public List<User> ListAll()
	{
		return repo.findAll(); 
	}
	//insert or create data
	public void create(User u)
	{
		  repo.save(u);
	}
	//to retrieve a single record 
	public User retrieve(Integer id)
	{
		return repo.findById(id).get();
			
	}
		
	//to delete  a data 
	public void delete(Integer id)
	{
		repo.deleteById(id);
	}

}
