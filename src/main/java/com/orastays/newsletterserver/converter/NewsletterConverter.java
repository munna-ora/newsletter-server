package com.orastays.newsletterserver.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.newsletterserver.entity.NewsletterEntity;
import com.orastays.newsletterserver.helper.Util;
import com.orastays.newsletterserver.model.NewsletterModel;

@Component
public class NewsletterConverter extends CommonConverter implements BaseConverter<NewsletterEntity, NewsletterModel> {

	private static final long serialVersionUID = -6881255187207068411L;
	private static final Logger logger = LogManager.getLogger(NewsletterConverter.class);

	@Override
	public NewsletterEntity modelToEntity(NewsletterModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewsletterModel entityToModel(NewsletterEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		NewsletterModel newsletterModel = new NewsletterModel();
		newsletterModel = (NewsletterModel) Util.transform(modelMapper, e, newsletterModel);

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return newsletterModel;
	}

	@Override
	public List<NewsletterModel> entityListToModelList(List<NewsletterEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<NewsletterModel> newsletterModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			newsletterModels = new ArrayList<>();
			for (NewsletterEntity newsletterEntity : es) {
				newsletterModels.add(entityToModel(newsletterEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return newsletterModels;
	}

}
