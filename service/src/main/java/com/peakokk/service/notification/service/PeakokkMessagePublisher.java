/**
 * 
 */
package com.peakokk.service.notification.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import com.peakokk.notification.PeakokkMessage;
import com.peakokk.notification.PeakokkMessageType;
import com.peakokk.domain.User;

/**
 * @author Sarvesh
 * 
 */
@Component("peakokkMessagePublisher")
public class PeakokkMessagePublisher implements ApplicationContextAware, IPeakokkMessagePublisher
{

    final static Logger logger = LoggerFactory.getLogger(PeakokkMessagePublisher.class);

    @Autowired
    private ApplicationContext context;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.context.ApplicationContextAware#setApplicationContext
     * (org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.storistic.notification.service.IStoristicMessagePublisher#publish
     * (java.lang.Object, com.storistic.userservice.pojo.User,
     * com.storistic.notification.StoristicMessageType, java.lang.String,
     * java.util.HashMap)
     */
    @Override
    public void publish(Object source, User toUser, PeakokkMessageType messageType,
            String uniqueMessageInstanceIdentifier, HashMap<String, Object> messageArgumentsMap)
    {
        publish(new PeakokkMessage(source, toUser, messageType, uniqueMessageInstanceIdentifier, messageArgumentsMap));

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.storistic.notification.service.IStoristicMessagePublisher#publish
     * (com.storistic.notification.StoristicMessage)
     */
    @Override
    public void publish(PeakokkMessage message)
    {
        logger.debug("StoristicMessagePublisher ==> publish ==>");
        ApplicationEventMulticaster appEvtMulticaster = (ApplicationEventMulticaster) context
                .getBean("applicationEventMulticaster");
        if (appEvtMulticaster != null)
        {
            appEvtMulticaster.multicastEvent(message);
        }
        else
        {
            logger.error("Could not find bean: applicationEventMulticaster in context, cannot send message: "
                    + message.getMessageType().name());
        }

    }

}
