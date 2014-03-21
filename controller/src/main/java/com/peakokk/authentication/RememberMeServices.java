package com.peakokk.authentication;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;

import com.peakokk.common.logging.Loggable;

@Loggable
public class RememberMeServices extends AbstractRememberMeServices
{
    private Logger logger = LoggerFactory.getLogger(RememberMeServices.class);

    @Override
    protected void onLoginSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected UserDetails processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request, HttpServletResponse response)
            throws RememberMeAuthenticationException, UsernameNotFoundException
    {
        logger.debug("RememberMeServices.processAutoLoginCookie");
        AuthenticationService userDetailsService = (AuthenticationService) getUserDetailsService();
        UserDetails user = null;
        String cookieValue = getCookieValue(request, getCookieName());
        if (cookieValue != null)
            user = userDetailsService.loadUserByCookie(cookieValue);
        if (user != null)
        {
            request.getSession().setAttribute(getCookieName(), cookieValue);
            request.getSession().setAttribute("user", userDetailsService.getCurrentUser());
            return user;
        }
        else
            throw new UsernameNotFoundException("Couldn't load user details via cookie: " + getCookieName());
    }
    
    /**
     * On logout, clear the single sign-on cookie (always attached to "/").
     */
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    {
        logger.debug("RememberMeServices.logout");
        String cookieName = getCookieName();
        String sessionSso = (String) request.getSession().getAttribute(cookieName);
        if (sessionSso != null)
        {
            AuthenticationService userDetailsService = (AuthenticationService) getUserDetailsService();
            userDetailsService.removeSSOSession(sessionSso);
        }
    }

    protected String getCookieValue(HttpServletRequest request, String cookieName)
    {
        logger.debug("RememberMeServices.getCookieValue - cookieName: " + cookieName);
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals(cookieName))
                {
                    cookieValue = cookie.getValue();
                    break;
                }
        return cookieValue;
    }

}
