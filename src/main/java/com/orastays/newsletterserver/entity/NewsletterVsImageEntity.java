package com.orastays.newsletterserver.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "newsletter_vs_image")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class NewsletterVsImageEntity extends CommonEntity {

	private static final long serialVersionUID = -8026000346030541256L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nli_id")
	@JsonProperty("nliId")
	private Long nliId;

	@Column(name = "image_url")
	@JsonProperty("imageUrl")
	private String imageUrl;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "newsletter_id", nullable = false)
	@JsonProperty("newsletter")
	private NewsletterEntity newsletterEntity;

	@Override
	public String toString() {
		return Long.toString(nliId);

	}
}
