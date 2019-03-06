package com.orastays.newsletterserver.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.newsletterserver.entity.SubscriberVsNewsletterLogEntity;
import com.orastays.newsletterserver.helper.Util;
import com.orastays.newsletterserver.model.SubscriberVsNewsletterLogModel;

@Component
public class SubscriberVsNewsletterLogConverter extends CommonConverter
		implements BaseConverter<SubscriberVsNewsletterLogEntity, SubscriberVsNewsletterLogModel> {

	private static final long serialVersionUID = -6396168730302145245L;
	private static final Logger logger = LogManager.getLogger(SubscriberVsNewsletterLogConverter.class);

	@Override
	public SubscriberVsNewsletterLogEntity modelToEntity(SubscriberVsNewsletterLogModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubscriberVsNewsletterLogModel entityToModel(SubscriberVsNewsletterLogEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		SubscriberVsNewsletterLogModel subscriberVsNewsletterLogModel = new SubscriberVsNewsletterLogModel();
		subscriberVsNewsletterLogModel = (SubscriberVsNewsletterLogModel) Util.transform(modelMapper, e,
				subscriberVsNewsletterLogModel);

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return subscriberVsNewsletterLogModel;
	}

	@Override
	public List<SubscriberVsNewsletterLogModel> entityListToModelList(List<SubscriberVsNewsletterLogEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<SubscriberVsNewsletterLogModel> subscriberVsNewsletterLogModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			subscriberVsNewsletterLogModels = new ArrayList<>();
			for (SubscriberVsNewsletterLogEntity subscriberVsNewsletterLogEntity : es) {
				subscriberVsNewsletterLogModels.add(entityToModel(subscriberVsNewsletterLogEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return subscriberVsNewsletterLogModels;
	}

}
