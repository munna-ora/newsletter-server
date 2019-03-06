package com.orastays.newsletterserver.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_subscriber")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SubscriberEntity extends CommonEntity {

	private static final long serialVersionUID = 114747539166795015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_id")
	@JsonProperty("subId")
	private Long subId;

	@Column(name = "email_id")
	@JsonProperty("emailId")
	private String emailId;

	@Column(name = "name")
	@JsonProperty("name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberEntity", cascade = { CascadeType.ALL })
	@JsonProperty("subscriberVsNewsletterLogs")
	private List<SubscriberVsNewsletterLogEntity> subscriberVsNewsletterLogEntities;

	@Override
	public String toString() {
		return Long.toString(subId);

	}
}
