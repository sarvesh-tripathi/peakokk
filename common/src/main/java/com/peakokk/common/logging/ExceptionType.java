package com.peakokk.common.logging;

public enum ExceptionType
{
    NO_REGISTRATION("No Registration Found."), 
    RETRIEVE_USER_FAILED("Retrieve user failed"), 
    ADD_USER_FAILED("Add user failed"), 
    ADD_EMAIL_USER_FAILED("Add email user failed"), 
    EMAIL_GROUP_DOES_NOT_EXIST("No group exist with this name"), 
    GET_FRIEND_LIST_FAILED("Get Friend List Failed"),
    GET_FACEBOOK_CONTACTS_FAILED("Get Facebook Contacts Failed"),
    GET_GMAIL_CONTACTS_FAILED("Get GMAIL Contacts Failed"),
    AUTHENTICATION_FAILED("Authentication Failed"),
    CHANGE_PASSWORD_FAILED("Change Password Failed"), 
    CHANGE_STATUS_FAILED("Change Status Failed"), 
    RESET_PASSWORD_FAILED("Reset Password Failed"), 
    FACEBOOK_TOKEN_EXPIRED("Facebook token has been expired"),
    //INVALID_INVITATION_LINK("Invalid Invitation Link")
    ;

    private String message;

    private ExceptionType(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
