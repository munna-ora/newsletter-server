package com.orastays.newsletterserver.controller;

import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orastays.newsletterserver.exceptions.FormExceptions;
import com.orastays.newsletterserver.helper.NewsletterConstant;
import com.orastays.newsletterserver.helper.Util;
import com.orastays.newsletterserver.model.ResponseModel;
import com.orastays.newsletterserver.model.SubscriberModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Api(value = "Subscriber", tags = "Subscriber")
public class NewsletterController extends BaseController {
	
private static final Logger logger = LogManager.getLogger(NewsletterController.class);
	
	@PostMapping(value = "/add-subscriber", produces = "application/json")
	@ApiOperation(value = "Add Subscriber", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 1100, message = "Please Enter Name"),
			@ApiResponse(code = 1101, message = "Invalid Name"),
			@ApiResponse(code = 1102, message = "Please Enter Email ID"),
			@ApiResponse(code = 1103, message = "Invalid Email ID"),
			@ApiResponse(code = 1104, message = "Email ID Already Registered") })
	public ResponseEntity<ResponseModel> addSubscriber(@RequestBody SubscriberModel subscriberModel) {
	
		if (logger.isInfoEnabled()) {
			logger.info("addSubscriber -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(subscriberModel, NewsletterConstant.INCOMING, "Add Subscriber", request);
		try {
			newsletterService.addSubscriber(subscriberModel);
			responseModel.setResponseBody(messageUtil.getBundle("subscriber.add.success"));
			responseModel.setResponseCode(messageUtil.getBundle(NewsletterConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(NewsletterConstant.COMMON_SUCCESS_MESSAGE));
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Add Subscriber -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Add Subscriber -- "+Util.errorToString(e));
			}
			e.printStackTrace();
			responseModel.setResponseCode(messageUtil.getBundle(NewsletterConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(NewsletterConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, NewsletterConstant.OUTGOING, "Add Subscriber", request);

		if (logger.isInfoEnabled()) {
			logger.info("addSubscriber -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(NewsletterConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
}