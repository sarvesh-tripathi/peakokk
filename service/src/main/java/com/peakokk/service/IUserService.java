package com.peakokk.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.peakokk.DTO.UserDTO;
import com.peakokk.domain.User;
import com.peakokk.domain.Usertype;

public interface IUserService extends IBaseService {
	
	/*
	** PUBLIC VARIBLES
	*/
	public static final String SERVICE_NAME=IUserService.class.getSimpleName();
	
	/**
	 *** Methods
	 */
	
	
	
	public String insert(UserDTO pUser) throws  DataAccessException;
	
	
	public User authentification(UserDTO pUser) throws DataAccessException;
	

	public boolean isEmailExist(String emailId) ;
	
	public User getUserDetails(int userId) throws DataAccessException;
	
	
	public User getUserDetails(String emailId) throws DataAccessException;
	
	public String updateUser(User user) throws DataAccessException;
	
	public String saveUser(User user) throws DataAccessException;

	
	public String deleteUser(UserDTO user) throws DataAccessException, Exception;
	

	public Usertype getUserType(String type) throws  DataAccessException;
	


    /*public UserDTO loadUserByUsername(String userName) throws DataAccessException, SQLException;*/
   
    }

//}
