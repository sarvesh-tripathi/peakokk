package com.peakokk.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.peakokk.domain.User;
import com.peakokk.domain.Usertype;

public interface IUserDAO extends IBaseDAO
{

    public static String DAO_NAME = IUserDAO.class.getName();

    public User authentification(String username, String password)
            throws  DataAccessException;

    public String insert(User users) throws
            DataAccessException;

    public List<User> selectAll() throws DataAccessException;

    public User getUser(int userId) throws DataAccessException;

    public User getUser(String emailId) throws DataAccessException;

    public Usertype getUserByUserType(String type) throws DataAccessException;

    public String save(User users) throws DataAccessException;

    public String update(User users) throws DataAccessException;

    public boolean isEmailIdExist(String emailId);
    
    public String deleteUser(User user) throws DataAccessException;
}
