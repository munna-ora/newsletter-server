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
public class NewsletterModel extends CommonModel {

	@JsonProperty("newsletterId")
	private String newsletterId;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("languageId")
	private String languageId;
	
	@JsonProperty("parentId")
	private String parentId;
	
	@JsonProperty("newsletterVsImages")
	private List<NewsletterVsImageModel> newsletterVsImageModels;
	
	@JsonProperty("subscriberVsNewsletterLogs")
	private List<SubscriberVsNewsletterLogModel> subscriberVsNewsletterLogModels;
}
