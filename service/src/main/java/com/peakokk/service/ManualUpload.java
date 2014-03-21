package com.peakokk.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.services.identitymanagement.model.User;
import com.peakokk.dao.IChefProfileDAO;

@Service("manualUpload")
public class ManualUpload implements IManualUpload {
	static final Logger logger = LoggerFactory.getLogger("debugLogger");
	
	@Autowired
	IChefProfileDAO chefProfileDAO;

    @Override
    @Transactional
    public String saveImgUrl(String profileImgUrl)
    {
        return chefProfileDAO.saveImgUrl(profileImgUrl);
    }
}
