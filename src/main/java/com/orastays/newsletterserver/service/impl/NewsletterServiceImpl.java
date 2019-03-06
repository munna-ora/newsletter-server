package com.orastays.newsletterserver.service.impl;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.orastays.newsletterserver.entity.SubscriberEntity;
import com.orastays.newsletterserver.exceptions.FormExceptions;
import com.orastays.newsletterserver.model.SubscriberModel;
import com.orastays.newsletterserver.service.NewsletterService;

@Service
@Transactional
public class NewsletterServiceImpl extends BaseServiceImpl implements NewsletterService {
	
	private static final Logger logger = LogManager.getLogger(NewsletterServiceImpl.class);

	@Override
	public void addSubscriber(SubscriberModel subscriberModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("addSubscriber -- START");
		}
		
		newsletterValidation.validateAddSubscriber(subscriberModel);
		SubscriberEntity subscriberEntity = subscriberConverter.modelToEntity(subscriberModel);
		subscriberDao.save(subscriberEntity);
		
		if (logger.isInfoEnabled()) {
			logger.info("addSubscriber -- END");
		}
	}
}