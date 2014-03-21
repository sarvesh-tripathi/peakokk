/**
 * 
 */
package com.peakokk.service.notification.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.peakokk.common.logging.Loggable;
import com.peakokk.notification.PeakokkMessageType;
import com.peakokk.domain.User;

/**
 * @author Sarvesh
 * 
 */
@Component("eventPublisher")
@Loggable
public class EventPublisher implements IMessagingEventPublisher
{
    final static Logger logger = LoggerFactory.getLogger(EventPublisher.class);

    @Autowired
    IPeakokkMessagePublisher storisticMessagePublisher;

   /* @Value("${mail.sender.email}")
    private String fromEmailId;

    @Value("${app.storistic.server.url}")
    private String serverURL;
    
    @Value("${app.storistic.welcome.subject}")
    private String welcomeEmailSubject;

    @Value("${app.storistic.change.password.subject}")
    private String changePasswordEmailSubject;

    @Value("${app.storistic.reset.password.subject}")
    private String resetPasswordEmailSubject;

    @Value("${app.storistic.share.storyline.subject}")
    private String shareStorylineEmailSubject;
    
    @Value("${app.storistic.share.moment.subject}")
    private String shareMomentEmailSubject;
    
    @Value("${app.storistic.invite.friend.subject}")
    private String inviteFriendEmailSubject;
    
    @Value("${app.storistic.registration.confirmation.subject}")
    private String confirmationSubject;
    
    @Value("${app.storistic.add.contributor.subject}")
    private String contributorAddSubject;*/

    public void sendWelcomeEmail(User user)
    {
        
    }

    public void sendChangePasswordEmail(User user)
    {
        
    }

    public void sendResetPasswordEmail(User user)
    {
    }

    
   
    @Override
    public void sendInvitationEmail(String invitationCode, String emailId, String InvitedUserName, String inviteFriendName)
    {
        
        
    }
    
    public void sendConfirmationEmail(User user, String confirmationCode, String entity, String entityId)
    {        
        
    }

}
