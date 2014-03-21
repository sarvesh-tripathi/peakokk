/**
 * 
 */
package com.peakokk.service.notification.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

import com.peakokk.notification.PeakokkMessage;
import com.peakokk.notification.PeakokkMessageType;

/**
 * @author Sarvesh
 * 
 */
public abstract class PeakokkMessageSubscriber implements ApplicationListener<PeakokkMessage>,
        IPeakokkMessageSubscriber
{
    private boolean all = false;
    private HashMap<PeakokkMessageType, Object> registeredMessageTypesMap = null;

    private Logger logger = LoggerFactory.getLogger(PeakokkMessageSubscriber.class);

    /*
     * (non-Javadoc)
     * 
     * @seecom.storistic.notification.service.IStoristicMessageSubscriber#
     * getRegisteredMessageTypes()
     */
    @Override
    public abstract PeakokkMessageType[] getRegisteredMessageTypes();

    /*
     * (non-Javadoc)
     * 
     * @seecom.storistic.notification.service.IStoristicMessageSubscriber#
     * onStoristicMessage(com.storistic.notification.StoristicMessage)
     */
    @Override
    public abstract void onPeakokkMessage(PeakokkMessage message);

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.context.ApplicationListener#onApplicationEvent(org
     * .springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(PeakokkMessage event)
    {
        logger.debug("StoristicMessageSubscriber ==> onApplicationEvent ==>");
        if (registeredMessageTypesMap == null)
        {
            buildRegisteredMessageMap();
        }

        // call derived sink (subscriber) based on the subscribers
        // registration of interested message types
        if (this.all)
        {
            onPeakokkMessage(event);
        }
        else if (registeredMessageTypesMap.containsKey(event.getMessageType()))
        {
            onPeakokkMessage(event);
        }
    }

    private void buildRegisteredMessageMap()
    {
        registeredMessageTypesMap = new HashMap<PeakokkMessageType, Object>();

        PeakokkMessageType[] types = getRegisteredMessageTypes();
        if (types != null)
        {
            for (PeakokkMessageType type : types)
            {
                if (type == PeakokkMessageType.ALL)
                {
                    this.all = true;
                }
                registeredMessageTypesMap.put(type, null);
            }
        }
    }

}
