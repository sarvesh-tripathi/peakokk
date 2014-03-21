package com.peakokk.controller;

import org.springframework.ui.ModelMap;

public abstract class BaseController
{

    /**
     * Final Variables
     */

    public static final String ATTR_USER_DETAILS = "userDetails";
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String EMPTY_STRING = "";
    public static final String ERROR_MESSAGE = "Data can't be saved";
    public static final String UPDATE_MESSAGE = "Data is updated successfully";
    public static final String SAVE_MESSAGE = "Data is saved successfully";
    public static final String DELETE_MESSAGE = "Data is deleted successfully";
    public static final String DUPLICATE_MESSAGE = "Data is duplicated";
    public static final String DUPLICATE_RECORD = "Duplicate";
    public static final String MESSAGE = "message";
    public static final String TYPE = "type";
    public static final String ERROR = "error";

    public void addActionError(ModelMap model, String messageKey, String messageValue)
    {
        model.addAttribute(messageKey, messageValue);
        model.addAttribute(TYPE, ERROR);
    }

    public String sendMessage(ModelMap model, String result, String message)
    {

        if (!result.equalsIgnoreCase(SUCCESS))
        {

            if (result.equals(DUPLICATE_RECORD))
            {

                addActionError(model, MESSAGE, DUPLICATE_MESSAGE);
                message = DUPLICATE_MESSAGE;

            }
            else if (result.equals(FAIL))
            {
                addActionError(model, MESSAGE, ERROR_MESSAGE);
                message = ERROR_MESSAGE;
            }
        }
        return message;
    }

}
