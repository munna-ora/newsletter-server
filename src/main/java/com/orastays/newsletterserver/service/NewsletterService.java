package com.orastays.newsletterserver.service;

import com.orastays.newsletterserver.exceptions.FormExceptions;
import com.orastays.newsletterserver.model.SubscriberModel;

public interface NewsletterService {
	
	void addSubscriber(SubscriberModel subscriberModel) throws FormExceptions;
}