package com.orastays.newsletterserver.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.orastays.newsletterserver.helper.MessageUtil;
import com.orastays.newsletterserver.service.NewsletterService;

public class BaseController {

	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected HttpServletResponse response;
	
	@Autowired
	protected NewsletterService newsletterService;
	
	@Autowired
	protected MessageUtil messageUtil;
}
