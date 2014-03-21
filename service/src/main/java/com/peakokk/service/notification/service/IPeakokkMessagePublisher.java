/**
 * 
 */
package com.peakokk.service.notification.service;

import java.util.HashMap;

import com.peakokk.notification.PeakokkMessage;
import com.peakokk.notification.PeakokkMessageType;
import com.peakokk.domain.User;

/**
 * @author Sarvesh
 *
 */
public interface IPeakokkMessagePublisher
{
    public static final String INSTANCE_DEPRECATED = "DEPRECATED";
    public static final String INSTANCE_SINGLETON = "SINGLETON";
    public static final String INSTANCE_NO_REF = "NO_REF";
    
    void publish(Object source, User toUser, PeakokkMessageType messageType, String uniqueMessageInstanceIdentifier,
            HashMap<String, Object> messageArgumentsMap);
    
    void publish(PeakokkMessage message);

}
