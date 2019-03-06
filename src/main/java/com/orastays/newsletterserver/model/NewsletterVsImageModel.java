package com.orastays.newsletterserver.model;

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
public class NewsletterVsImageModel extends CommonModel {

	@JsonProperty("nliId")
	private String nliId;
	
	@JsonProperty("imageUrl")
	private String imageUrl;
	
	@JsonProperty("newsletter")
	private NewsletterModel newsletterModel;

}
