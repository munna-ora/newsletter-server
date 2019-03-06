package com.orastays.newsletterserver.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.newsletterserver.entity.SubscriberEntity;
import com.orastays.newsletterserver.helper.Status;
import com.orastays.newsletterserver.helper.Util;
import com.orastays.newsletterserver.model.SubscriberModel;

@Component
public class SubscriberConverter extends CommonConverter implements BaseConverter<SubscriberEntity, SubscriberModel> {

	private static final long serialVersionUID = -2206676303803593134L;
	private static final Logger logger = LogManager.getLogger(SubscriberConverter.class);

	@Override
	public SubscriberEntity modelToEntity(SubscriberModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}
		
		SubscriberEntity subscriberEntity = new SubscriberEntity();
		subscriberEntity = (SubscriberEntity) Util.transform(modelMapper, m, subscriberEntity);
		subscriberEntity.setStatus(Status.ACTIVE.ordinal());
		subscriberEntity.setCreatedBy(Long.valueOf(Status.ZERO.ordinal()));
		subscriberEntity.setCreatedDate(Util.getCurrentDateTime());
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}
		
		return subscriberEntity;
	}

	@Override
	public SubscriberModel entityToModel(SubscriberEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		SubscriberModel subscriberModel = new SubscriberModel();
		subscriberModel = (SubscriberModel) Util.transform(modelMapper, e, subscriberModel);

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return subscriberModel;
	}

	@Override
	public List<SubscriberModel> entityListToModelList(List<SubscriberEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<SubscriberModel> subscriberModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			subscriberModels = new ArrayList<>();
			for (SubscriberEntity subscriberEntity : es) {
				subscriberModels.add(entityToModel(subscriberEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return subscriberModels;
	}

}
