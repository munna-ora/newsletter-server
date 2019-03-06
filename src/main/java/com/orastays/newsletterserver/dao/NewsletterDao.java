package com.orastays.newsletterserver.dao;

import org.springframework.stereotype.Repository;

import com.orastays.newsletterserver.entity.NewsletterEntity;

@Repository
public class NewsletterDao extends GenericDAO<NewsletterEntity, Long> {

	private static final long serialVersionUID = 5713037546127404770L;

	public NewsletterDao() {
		super(NewsletterEntity.class);

	}
}
