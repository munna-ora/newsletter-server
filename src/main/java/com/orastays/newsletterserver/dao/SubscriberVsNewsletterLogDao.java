package com.orastays.newsletterserver.dao;

import org.springframework.stereotype.Repository;

import com.orastays.newsletterserver.entity.SubscriberVsNewsletterLogEntity;

@Repository
public class SubscriberVsNewsletterLogDao extends GenericDAO<SubscriberVsNewsletterLogEntity, Long> {

	private static final long serialVersionUID = -7071541209301903707L;

	public SubscriberVsNewsletterLogDao() {
		super(SubscriberVsNewsletterLogEntity.class);

	}
}
