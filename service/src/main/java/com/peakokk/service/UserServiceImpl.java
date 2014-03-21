package com.peakokk.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peakokk.DTO.UserDTO;
import com.peakokk.common.logging.Loggable;
import com.peakokk.dao.IUserDAO;
import com.peakokk.domain.User;
import com.peakokk.domain.Usertype;

@Service("userService")
@Loggable
public class UserServiceImpl implements IUserService
{

    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
    
    /**
     * Empty constructor
     */
    /*
     * public UserServiceImpl() {
     * }
     */

    @Autowired
    IUserDAO userDAO;

    @Override
    public String insert(UserDTO pUser) throws DataAccessException
    {
        return null;
    }

    @Override
    @Transactional
    public User authentification(UserDTO pUser) throws DataAccessException
    {
       
         /*ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
         passwordEncoder.setEncodeHashAsBase64(true);
         pUser.setPassword(passwordEncoder.encodePassword(pUser.getPassword(), null));
        */
         logger.debug("authentification : user email : "+pUser.getEmailId() + "  User Password  : "+ pUser.getPassword()) ;
         User usr= userDAO.authentification(pUser.getEmailId(), pUser.getPassword());
         return usr;
         
     }   

    @Override
    public User getUserDetails(int userId) throws DataAccessException
    {

        return userDAO.getUser(userId);
    }
    
    
   /* @Override
    public BaseResponse emailNotRegistered(String email)
    {
        return restTemplate.getForObject(emailNotRegisteredUrl, BaseResponse.class, email);
    }*/

    @Override
    public User getUserDetails(String emailId) throws DataAccessException
    {
        return userDAO.getUser(emailId);
    }

    @Override
    public Usertype getUserType(String type) throws
            DataAccessException
    {

        return userDAO.getUserByUserType(type);
    }

    @Override
    public String updateUser(User users) throws DataAccessException
    {

        return userDAO.update(users);

    }

    @Override
    @Transactional
    public String saveUser(User user) throws DataAccessException
    {
        ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
        passwordEncoder.setEncodeHashAsBase64(true);
        user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
        user.setConfirmPassword(passwordEncoder.encodePassword(user.getConfirmPassword(), null));
       return userDAO.save(user);
    }

    @Override
    public String deleteUser(UserDTO user) throws DataAccessException,
             Exception
    {
        return null;
    }

    @Override
    @Transactional
    public boolean isEmailExist(String emailId) 
    {
        
        System.out.println("=================> Service 1");
     return  userDAO.isEmailIdExist(emailId);
        
        
        
    }

}
