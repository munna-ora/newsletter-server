package com.orastays.newsletterserver.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.newsletterserver.entity.NewsletterVsImageEntity;
import com.orastays.newsletterserver.helper.Util;
import com.orastays.newsletterserver.model.NewsletterVsImageModel;

@Component
public class NewsletterVsImageConverter extends CommonConverter
		implements BaseConverter<NewsletterVsImageEntity, NewsletterVsImageModel> {

	private static final long serialVersionUID = 4721595236426855712L;
	private static final Logger logger = LogManager.getLogger(NewsletterVsImageConverter.class);

	@Override
	public NewsletterVsImageEntity modelToEntity(NewsletterVsImageModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewsletterVsImageModel entityToModel(NewsletterVsImageEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		NewsletterVsImageModel newsletterVsImageModel = new NewsletterVsImageModel();
		newsletterVsImageModel = (NewsletterVsImageModel) Util.transform(modelMapper, e, newsletterVsImageModel);

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return newsletterVsImageModel;
	}

	@Override
	public List<NewsletterVsImageModel> entityListToModelList(List<NewsletterVsImageEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<NewsletterVsImageModel> newsletterVsImageModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			newsletterVsImageModels = new ArrayList<>();
			for (NewsletterVsImageEntity newsletterVsImageEntity : es) {
				newsletterVsImageModels.add(entityToModel(newsletterVsImageEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return newsletterVsImageModels;
	}

}
