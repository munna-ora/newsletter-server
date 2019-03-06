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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subscriber_vs_newsletter_log")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SubscriberVsNewsletterLogEntity extends CommonEntity {

	private static final long serialVersionUID = 7068897245187113755L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "snl_id")
	private Long snlId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "newsletter_id", nullable = false)
	private NewsletterEntity newsletterEntity;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "sub_id", nullable = false)
	private SubscriberEntity subscriberEntity;

	@Override
	public String toString() {
		return Long.toString(snlId);

	}
}
