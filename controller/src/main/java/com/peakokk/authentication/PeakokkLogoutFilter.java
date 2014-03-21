package com.peakokk.authentication;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.peakokk.common.logging.Loggable;

@Loggable
public class PeakokkLogoutFilter extends LogoutFilter
{
    private Logger logger = LoggerFactory.getLogger(PeakokkLogoutFilter.class);

    protected String cookieName;

    public PeakokkLogoutFilter(String logoutSuccessUrl, LogoutHandler... handlers)
    {
        super(logoutSuccessUrl, handlers);
    }

    public String getCookieName()
    {
        return cookieName;
    }

    public void setCookieName(String cookieName)
    {
        this.cookieName = cookieName;
    }

    @Override
    protected boolean requiresLogout(HttpServletRequest request, HttpServletResponse response)
    {
        //logger.debug("StoristicLogoutFilter.requiresLogout");
        // Normal logout processing (i.e. detect logout URL)
        if (super.requiresLogout(request, response))
        {
            return true;
        }
        return false;
        
    }

    protected String getCookieValue(HttpServletRequest request, String cookieName)
    {
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
