package com.orastays.newsletterserver.dao;

import org.springframework.stereotype.Repository;

import com.orastays.newsletterserver.entity.SubscriberEntity;

@Repository
public class SubscriberDao extends GenericDAO<SubscriberEntity, Long> {

	private static final long serialVersionUID = -3567509936577845111L;

	public SubscriberDao() {
		super(SubscriberEntity.class);

	}
}
