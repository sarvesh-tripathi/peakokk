/**
 * 
 */
package com.peakokk.service.notification.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.peakokk.notification.MessageClassifier;
import com.peakokk.notification.PeakokkMessageType;

/**
 * @author Sarvesh
 * 
 */
@Component("messageClassifierHelper")
public class MessageClassifierHelper implements ApplicationContextAware
{
    private ApplicationContext context;
    private String fileName;
    private String smtpNotifier;
    private String priority;
    private String messageGroup;
    private String messageID;
    private String messageVersion;
    private static Logger logger = LoggerFactory.getLogger(MessageClassifierHelper.class);

    HashMap<String, ArrayList<PeakokkMessageType>> notifierMap;

    HashMap<String, MessageClassifier> messageClassifierMap;

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
        this.context = applicationContext;
        try
        {
            logger.debug("setApplicationContext: in application.");
            parseXML();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * This constructor is used to populate the vmMap and paramMap HashMap
     * 
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws URISyntaxException
     */

    public MessageClassifierHelper(String filename, String smtpNotifier, String priority, String messageGroup,
            String messageID, String messageVersion)
    {
        logger.debug("MessageClassifierHelper: ctor");
        this.fileName = filename;
        this.smtpNotifier = smtpNotifier;
        this.priority = priority;
        this.messageGroup = messageGroup;
        this.messageID = messageID;
        this.messageVersion = messageVersion;
    }

    public void parseXML() throws ParserConfigurationException, SAXException, IOException, URISyntaxException
    {
        logger.debug("parseXML: File: " + fileName);

        messageClassifierMap = new HashMap<String, MessageClassifier>();
        notifierMap = new HashMap<String, ArrayList<PeakokkMessageType>>();

        ArrayList<PeakokkMessageType> peakokkSMTPMessageTypes = new ArrayList<PeakokkMessageType>();

        Resource res = context.getResource(fileName);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(res.getInputStream());
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("message");

        if (nList != null && nList.getLength() > 0)
        {
            for (int i = 0; i < nList.getLength(); i++)
            {
                MessageClassifier messageClassifier = new MessageClassifier();
                HashMap<String, String> vmValueMap = new HashMap<String, String>();

                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;
                vmValueMap.put(smtpNotifier, eElement.getAttribute(smtpNotifier));

                ArrayList<String> optionalParamList = new ArrayList<String>();
                ArrayList<String> forcedParamList = new ArrayList<String>();
                NodeList nlList = eElement.getElementsByTagName("param");
                if (nList != null)
                {
                    for (int j = 0; j < nlList.getLength(); j++)
                    {
                        Node nValue = nlList.item(j);
                        Node nlListChild = nValue.getChildNodes().item(0);
                        Element eElementChild = (Element) nValue;
                        if (nlListChild.getNodeValue().equalsIgnoreCase("optional"))
                        {
                            optionalParamList.add(eElementChild.getAttribute("name"));
                        }
                        else if (nlListChild.getNodeValue().equalsIgnoreCase("forced"))
                        {
                            forcedParamList.add(eElementChild.getAttribute("name"));
                        }
                    }
                }

                if (!eElement.getAttribute(smtpNotifier).isEmpty())
                {
                    peakokkSMTPMessageTypes.add(getPeakokkMessageType(eElement.getAttribute("id")));
                }
                messageClassifier.setVmMap(vmValueMap);
                messageClassifier.setForcedParamMap(forcedParamList);
                messageClassifier.setOptionalParamMap(optionalParamList);

                String str = eElement.getAttribute(priority);
                if (str != null && !str.isEmpty())
                    messageClassifier.setPriority(Integer.parseInt(str));
                str = eElement.getAttribute(messageGroup);
                if (str != null && !str.isEmpty())
                    messageClassifier.setMessageGroup(Integer.parseInt(str));
                str = eElement.getAttribute(messageID);
                if (str != null && !str.isEmpty())
                    messageClassifier.setMessageId(Integer.parseInt(str));
                str = eElement.getAttribute(messageVersion);
                if (str != null && !str.isEmpty())
                    messageClassifier.setMessageVersion(Integer.parseInt(str));
                messageClassifierMap.put(eElement.getAttribute("id"), messageClassifier);

            }
        }
        notifierMap.put(smtpNotifier, peakokkSMTPMessageTypes);

        logger.debug("parseXML: notifierMap.size: " + notifierMap.size());
    }

    /**
     * This function will check if a perticular PeakokkMessageType message
     * exists or not and return the Peakokk message type
     * 
     * @param message
     * @return
     */
    public PeakokkMessageType getPeakokkMessageType(String message)
    {
        for (PeakokkMessageType peakokkMessageType : PeakokkMessageType.values())
        {
            if (peakokkMessageType.name().equalsIgnoreCase(message))
            {
                return peakokkMessageType;
            }
        }
        return null;
    }

    /**
     * This function will take the emailNotifier as a parameter and will return
     * the corresponding array list of PeakokkMessageType
     * 
     * @param subscriberName
     * @return ArrayList of PeakokkMessageType
     */
    public ArrayList<PeakokkMessageType> getNotifierMap(String subscriberName)
    {
        ArrayList<PeakokkMessageType> peakokkMessageTypeList = new ArrayList<PeakokkMessageType>();
        if (notifierMap != null)
        {
        	peakokkMessageTypeList = notifierMap.get(subscriberName);
            logger.info("getNotifierMap: SubscriberName: " + subscriberName + ", storisticMessageTypeList.Size: "
                    + ((peakokkMessageTypeList != null) ? peakokkMessageTypeList.size() : 0));
        }
        return peakokkMessageTypeList;
    }

    /**
     * This function will take the StoristicMessageType as a parameter and will
     * return the corresponding Hash map of velocity.
     * 
     * @param storisticMessageType
     * @return HashMap of vmList
     */
    public HashMap<String, String> getVmMap(PeakokkMessageType peakokkMessageType)
    {
        MessageClassifier messageClassifier = messageClassifierMap.get(peakokkMessageType.name());
        return messageClassifier.getVmMap();
    }

    /**
     * This function will take the storisticMessageType as a parameter and will
     * return the corresponding Hash map of forcedParamMap.
     * 
     * @param storisticMessageType
     * @return ArrayList of forcedParamMap
     */
    public ArrayList<String> getParamMap(PeakokkMessageType peakokkMessageType)
    {
        MessageClassifier messageClassifier = messageClassifierMap.get(peakokkMessageType.name());
        return messageClassifier.getForcedParamMap();

    }

    /**
     * This function will take the storisticMessageType as a parameter and will
     * return the corresponding Hash map of priority.
     * 
     * @param storisticMessageType
     * @return HashMap of vmList
     */
    public int getMessagePriority(PeakokkMessageType peakokkMessageType)
    {
        MessageClassifier messageClassifier = messageClassifierMap.get(peakokkMessageType.name());
        return messageClassifier.getPriority();
    }

    /**
     * This function will take the storisticMessageType as a parameter and will
     * return the corresponding Hash map of priority.
     * 
     * @param storisticMessageType
     * @return HashMap of vmList
     */
    public int getMessageGroup(PeakokkMessageType peakokkMessageType)
    {
        MessageClassifier messageClassifier = messageClassifierMap.get(peakokkMessageType.name());
        return messageClassifier.getMessageGroup();
    }

    /**
     * This function will take the storisticMessageType as a parameter and will
     * return the corresponding Hash map of priority.
     * 
     * @param storisticMessageType
     * @return HashMap of vmList
     */
    public HashMap<String, Object> addMessageIDAndVersion(PeakokkMessageType peakokkMessageType,
            HashMap<String, Object> messageArgumentsMap)
    {
        MessageClassifier messageClassifier = messageClassifierMap.get(peakokkMessageType.name());
        int messageId = messageClassifier.getMessageId();
        int messageVersion = messageClassifier.getMessageVersion();
        messageArgumentsMap.put("messageID", messageId);
        messageArgumentsMap.put("messageVersion", messageVersion);
        return messageArgumentsMap;
    }

}
