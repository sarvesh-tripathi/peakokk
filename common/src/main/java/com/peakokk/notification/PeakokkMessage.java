/**
 * 
 */
package com.peakokk.notification;

import java.util.HashMap;
import java.util.Set;

import org.springframework.context.ApplicationEvent;

//import com.storistic.userservice.pojo.User;

/**
 * 
 *
 */
public class PeakokkMessage extends ApplicationEvent
{
    private static final long serialVersionUID = 8487128002812688230L;

    private PeakokkMessageType messageType;
    private HashMap<String, Object> messageArgumentsMap;
    private Object user;

    private String uniqueMessageInstanceIdentifier;

    public PeakokkMessage(
            Object source,
            Object toUser,
            PeakokkMessageType messageType,
            String uniqueMessageInstanceIdentifier,
            Object... ma)
    {
        super(source);

        this.messageType = messageType;
        this.uniqueMessageInstanceIdentifier = uniqueMessageInstanceIdentifier;

        this.messageArgumentsMap = new HashMap<String, Object>();
        for (int i = 0; i < ma.length; i += 2)
        {
            this.messageArgumentsMap.put((String) ma[i], ma[i + 1]);
        }

        this.user = toUser;
    }

    public PeakokkMessage(
            Object source,
            Object toUser,
            PeakokkMessageType messageType,
            String uniqueMessageInstanceIdentifier,
            HashMap<String, Object> messageArgumentsMap)
    {
        super(source);

        this.messageType = messageType;
        this.uniqueMessageInstanceIdentifier = uniqueMessageInstanceIdentifier;
        this.messageArgumentsMap = messageArgumentsMap;
        this.user = toUser;
    }

    public PeakokkMessageType getMessageType()
    {
        return messageType;
    }

    public Object getMessageArgument(String argName)
    {
        return this.messageArgumentsMap.get(argName);
    }

    public Set<String> getArgumentNames()
    {
        return this.messageArgumentsMap.keySet();
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, Object> cloneMessageArgumentsMap()
    {
        return (HashMap<String, Object>) this.messageArgumentsMap.clone();
    }

    /**
     * @return the user
     */
    public Object getUser()
    {
        return user;
    }

    /**
     * @return the uniqueMessageInstanceIdentifier
     */
    public String getUniqueMessageInstanceIdentifer()
    {
        return uniqueMessageInstanceIdentifier;
    }

}
