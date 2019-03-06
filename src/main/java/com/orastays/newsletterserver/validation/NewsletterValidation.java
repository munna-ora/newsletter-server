package com.orastays.newsletterserver.validation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.newsletterserver.exceptions.FormExceptions;
import com.orastays.newsletterserver.helper.Util;
import com.orastays.newsletterserver.model.SubscriberModel;

@Component
@Transactional
public class NewsletterValidation extends AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(NewsletterValidation.class);

	//Validation while adding review
	public void validateAddSubscriber(SubscriberModel subscriberModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("validateAddSubscriber -- Start");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		
		if(Objects.nonNull(subscriberModel)) {
			
			// Validate Name of the user
			if(StringUtils.isBlank(subscriberModel.getName())) {
				exceptions.put(messageUtil.getBundle("user.name.null.code"), new Exception(messageUtil.getBundle("user.name.null.message")));
			} else {
				if(!Util.checkAlphabet(subscriberModel.getName())) {
					exceptions.put(messageUtil.getBundle("user.name.invalid.code"), new Exception(messageUtil.getBundle("user.name.invalid.message")));
				}
			}
			
			// Validate Email ID of the User
			if(StringUtils.isBlank(subscriberModel.getEmailId())) {
				exceptions.put(messageUtil.getBundle("user.email.null.code"), new Exception(messageUtil.getBundle("user.email.null.message")));
			} else {
				if(!Util.emailValidator(subscriberModel.getEmailId())) {
					exceptions.put(messageUtil.getBundle("user.email.invalid.code"), new Exception(messageUtil.getBundle("user.email.invalid.message")));
				} else {
					if(checkSubscriber(subscriberModel.getEmailId())) {
						exceptions.put(messageUtil.getBundle("user.email.present.code"), new Exception(messageUtil.getBundle("user.email.present.message")));
					}
				}
			}
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("validateAddSubscriber -- End");
		}	
	}
	
	private boolean checkSubscriber(String emailId) {
		
		if (logger.isInfoEnabled()) {
			logger.info("checkSubscriber -- START");
		}
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			//innerMap1.put("status", String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put("emailId", emailId);
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".SubscriberEntity", outerMap1);
	
			if(Objects.isNull(subscriberDao.fetchObjectBySubCiteria(alliasMap))) {
				return false;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in checkSubscriber -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("checkSubscriber -- END");
		}
		
		return true;
	}
}