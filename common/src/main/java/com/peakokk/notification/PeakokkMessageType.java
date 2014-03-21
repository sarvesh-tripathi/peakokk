/**
 * 
 */
package com.peakokk.notification;

/**
 * @author Sarvesh
 *
 */
public enum PeakokkMessageType
{
    ALL("ALL"),
    WELCOME_EMAIL("WELCOME_EMAIL"),
    CHANGE_PASSWORD("CHANGE_PASSWORD"),
    RESET_PASSWORD("RESET_PASSWORD"),
    SHARE_STORYLINE("SHARE_STORYLINE"),
    INVITE_FRIEND("INVITE_FRIEND"),
    REGISTRATION_CONFIRMATION("REGISTRATION_CONFIRMATION"),
    SHARE_MOMENT("SHARE_MOMENT"),
    ADD_CONTRIBUTOR("ADD_CONTRIBUTOR");
    
    private String storisticMessageType;
    
    private PeakokkMessageType(String storisticMessageType)
    {
        this.storisticMessageType = storisticMessageType;
    }

    public String getStoristicMessageType()
    {
        return storisticMessageType;
    }

}
