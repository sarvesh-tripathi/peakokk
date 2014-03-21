/**
 * 
 */
package com.peakokk.service.notification.service;

import com.peakokk.notification.PeakokkMessage;
import com.peakokk.notification.PeakokkMessageType;

/**
 * @author Sarvesh
 *
 */
public interface IPeakokkMessageSubscriber
{
    /**
     * Derived implementations must return the message types they are interested
     * in.
     * 
     * @return
     */
	PeakokkMessageType[] getRegisteredMessageTypes();
    
    /**
     * Called by messaging framework when an interesting message is published by
     * someone
     *  
     * @param message
     */
    void onPeakokkMessage(PeakokkMessage message);

}
