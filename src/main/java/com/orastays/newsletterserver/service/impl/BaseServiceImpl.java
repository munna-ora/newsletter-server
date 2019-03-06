package com.orastays.newsletterserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.orastays.newsletterserver.converter.SubscriberConverter;
import com.orastays.newsletterserver.dao.SubscriberDao;
import com.orastays.newsletterserver.validation.NewsletterValidation;

public abstract class BaseServiceImpl {

	@Value("${entitymanager.packagesToScan}")
	protected String entitymanagerPackagesToScan;
	
	@Autowired
	protected NewsletterValidation newsletterValidation;
	
	@Autowired
	protected SubscriberDao subscriberDao;
	
	@Autowired
	protected SubscriberConverter subscriberConverter;
}
