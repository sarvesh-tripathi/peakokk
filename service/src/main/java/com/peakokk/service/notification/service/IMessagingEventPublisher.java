/**
 * 
 */
package com.peakokk.service.notification.service;

import com.peakokk.domain.User;

/**
 * @author Sarvesh
 *
 */
public interface IMessagingEventPublisher
{
	public void sendWelcomeEmail(User user);
	public void sendChangePasswordEmail(User user);
    public void sendResetPasswordEmail(User user);    
    public void sendInvitationEmail(String invitationCode, String emailId, String sharingUserName, String inviteFriendName);
    public void sendConfirmationEmail(User user, String confirmationCode, String entity, String entityId);    
}
