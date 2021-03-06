package com.orastays.newsletterserver.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class SubscriberModel extends CommonModel {

	@JsonProperty("subId")
	private String subId;
	
	@JsonProperty("emailId")
	private String emailId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("subscriberVsNewsletterLogs")
	private List<SubscriberVsNewsletterLogModel> subscriberVsNewsletterLogModels;

}
