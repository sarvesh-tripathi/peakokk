package com.peakokk.authentication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.peakokk.DTO.UserDTO;
import com.peakokk.authorization.Role;
import com.peakokk.service.IUserService;

public class AuthenticationService implements UserDetailsService
{

    private Logger logger = LoggerFactory
            .getLogger(AuthenticationService.class);

    private ThreadLocal<User> currentUser = new ThreadLocal<User>();
    private ThreadLocal<String> currentPassword = new ThreadLocal<String>();
    private String dbSessionId;
    private String userName;
    private String userId;
    private String userEmail;
    private boolean sessionExist;
    private String userTypeId;

    private Map<String, String> usersToCookies = new HashMap<String, String>();
    private Map<String, String> cookiesToUsers = new HashMap<String, String>();
    private Map<String, Date> sessionValidity = new HashMap<String, Date>();

    @Autowired
    IUserService userService;
    
    public String createSSOSession(String username)
    {
        logger.debug("Creating SSO session for " + username);
        String newCookieValue = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + username;
        String oldCookie = usersToCookies.get(username);
        removeSSOSession(oldCookie);
        cookiesToUsers.put(newCookieValue, username);
        Date now = new Date();
        Date sessionValidityTime = new Date(now.getTime() + 30 * 1000);
        sessionValidity.put(newCookieValue, sessionValidityTime);
        return newCookieValue;
    }

    public void removeSSOSession(String cookie)
    {
        if (cookie != null)
        {
            logger.debug("Removing SSO session: " + cookie);
            String username = cookiesToUsers.get(cookie);
            if (username != null)
            {
                usersToCookies.remove(username);
            }
            cookiesToUsers.remove(cookie);
            sessionValidity.remove(cookie);
        }
    }

    public UserDetails loadUserByCookie(String cookie)
            throws UsernameNotFoundException, DataAccessException
    {
        logger.debug("Loading user by cookie: " + cookie);
        Date sessionValidUntil = sessionValidity.get(cookie);
        Date now = new Date();
        logger.debug("Session valid until: " + sessionValidUntil + " now: "
                + now);
        if (sessionValidUntil == null || now.after(sessionValidUntil))
        {
            logger.debug("Session no longer valid.");
            cookie = null;
        }
        return loadUserByUsername(cookiesToUsers.get(cookie));
    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException, DataAccessException
    {
        logger.debug("Loading user by name: " + userName);
        User user;
      
           UserDTO userDto = new UserDTO();
           userDto.setEmailId(userName); 
           userDto.setPassword(getPassword());
           com.peakokk.domain.User oauthUser = userService.authentification(userDto);
          Vector<GrantedAuthority> userAuthorities = new   Vector<GrantedAuthority>(); 
          userAuthorities.add(new GrantedAuthorityImpl(Role.USER_ROLE.roleName()));
          userAuthorities.add(new GrantedAuthorityImpl(Role.ADMIN_ROLE.name()));
          if (oauthUser != null ) 
          {
              user = new User(userName, getPassword(), true, true, true, true,userAuthorities); currentUser.set(user);
              setSessionExist(true);
              setUserId(String.valueOf(oauthUser.getUserId()));
              setUserName(oauthUser.getFirstName());
              setUserEmail(oauthUser.getEmailId());
              setUserTypeId(String.valueOf((oauthUser.getUserTypeId())));
              logger.debug("AuthenticationService  oAuth User  Email : "+ oauthUser.getEmailId());
          
          return user;
          }
         
        throw new UsernameNotFoundException("Username " + userName
                + " not found!");
    }

    public User getCurrentUser()
    {
        return currentUser.get();
    }

    public void setCurrentUser(User user)
    {
        currentUser.set(user);
    }

    public String getPassword()
    {
        return currentPassword.get();
    }

    public void setPassword(String password)
    {
        currentPassword.set(password);
    }

    public String getDbSessionId()
    {
        return dbSessionId;
    }

    public void setDbSessionId(String dbSessionId)
    {
        this.dbSessionId = dbSessionId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    public boolean isSessionExist()
    {
        return sessionExist;
    }

    public void setSessionExist(boolean sessionExist)
    {
        this.sessionExist = sessionExist;
    }

    public String getUserTypeId()
    {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId)
    {
        this.userTypeId = userTypeId;
    }

}
