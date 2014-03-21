/**
 * 
 */
package com.peakokk.service.notification.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.peakokk.common.logging.Loggable;
import com.peakokk.notification.PeakokkMessage;
import com.peakokk.notification.PeakokkMessageType;
import com.peakokk.service.notification.service.email.IMessagingService;

/**
 * @author Sarvesh
 * 
 */
@Component("smtpNotifier")
@Loggable
public class SMTPNotifier extends PeakokkMessageSubscriber implements IPeakokkMessageSubscriber
{

    final static Logger logger = LoggerFactory.getLogger(SMTPNotifier.class);

    @Autowired
    MessageClassifierHelper messageClassifierHelper;

    @Autowired
    IMessagingService smtpEmailService;

    @Value("${app.storistic.messages.smtpNotifier}")
    private String smtpNotifier;

    @Value("${mail.sender.email}")
    private String fromEmail;

    @Value("${mail.sender.name}")
    private String fromName;

    /*
     * (non-Javadoc)
     * 
     * @seecom.storistic.notification.service.StoristicMessageSubscriber#
     * getRegisteredMessageTypes()
     */
    @Override
    public PeakokkMessageType[] getRegisteredMessageTypes()
    {
        ArrayList<PeakokkMessageType> peakokkMessageTypeList = messageClassifierHelper.getNotifierMap(smtpNotifier);
        PeakokkMessageType[] peakokkMessageType = peakokkMessageTypeList
                .toArray(new PeakokkMessageType[peakokkMessageTypeList.size()]);
        return peakokkMessageType;
    }

    /**
     * This function will check if the messages is containing all the forced
     * messages or not. If not it will return false.
     * 
     * @param message
     * @return flag(true/false)
     */
    private boolean confirmParamMap(PeakokkMessage message)
    {
        boolean flag = true;
        ArrayList<String> forcedParams = messageClassifierHelper.getParamMap(message.getMessageType());
        for (String key : forcedParams)
        {
            if (!message.getArgumentNames().contains(key))
            {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /*
     * (non-Javadoc)
     * 
     * @seecom.storistic.notification.service.StoristicMessageSubscriber#
     * onStoristicMessage(com.storistic.notification.StoristicMessage)
     */
    @Override
    @Loggable
    public void onPeakokkMessage(PeakokkMessage message)
    {
        logger.debug("SMTPNotifier ==> onStoristicMessage");
        try
        {
            if (confirmParamMap(message))
            {
                HashMap<String, Object> messageArgumentsMap = message.cloneMessageArgumentsMap();
                HashMap<String, String> vmList = messageClassifierHelper.getVmMap(message.getMessageType());
                String velocity = null;
                if (vmList != null)
                {
                    velocity = vmList.get(smtpNotifier);
                }
                String to = (String) messageArgumentsMap.get("to");
                if (to == null || to.isEmpty())
                {
                    logger.error("onStoristicMessage: MESSAGE: from=" + messageArgumentsMap.get(fromEmail)
                            + " Error: No 'to' property specified");
                    return;
                }
                List<String> toEmails = new ArrayList<String>();
                if (to.contains(","))
                {
                    String[] emails = to.split(",");
                    for (String email : emails)
                    {
                        toEmails.add(email);
                    }
                }
                else
                {
                    toEmails.add(to);
                }
                String subject = (String) messageArgumentsMap.get("subject");

                // Checking if messageArgumentsMap the key onBehalfOfEmail to
                // send the on behalf of string with from name
                // Created a new variable fromUserName because fromName is a
                // global
                // variable and persist in whole application and that is why
                // on behalf of getting appended in all emails
                String fromUserName = fromName;
                if (messageArgumentsMap.containsKey("onBehalfOfEmail"))
                {
                    fromUserName = fromUserName.concat(" on behalf of " + messageArgumentsMap.get("onBehalfOfEmail"));
                }

                messageArgumentsMap = messageClassifierHelper.addMessageIDAndVersion(message.getMessageType(),
                        messageArgumentsMap);
                if (smtpEmailService.sendEmail(fromEmail, fromUserName, toEmails, null, null, null, subject, velocity,
                        messageArgumentsMap, null))
                {
                    logger.debug("SMTPNotifier ==> email sent successfully");
                }
            }
            else
            {
                logger.error("onStoristicMessage: Param passed does not contain mandatory parameters");
            }
        }
        catch (Throwable e)
        {
            logger.error("onStoristicMessage: Error handling SMTP message", e);

            // ignore and continue
        }
    }

}
