/**
 * youtube: https://www.youtube.com/watch?v=a49JO1WjJSs
 * time stamp: 1:19:21
 */
package com.jah.securedoc.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 */

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt", "updatedAt"}, allowGetters = true)
public abstract class Auditable {
	@Id
	@SequenceGenerator(name="primary_key_seq", sequenceName="primary_key_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="primary_key_seq")
	@Column(name="id", updatable = false)
	private Long id;
	private String referencesId = new AlternativeJdkIdGenerator().generateId().toString(); // generate reference ID
	@NotNull
	private Long createdBy; // who created the doc
	@NotNull
	private Long updatedBy; // updated by who
	@NotNull
	@CreatedDate
	@Column(name="created_at",nullable=false,  updatable = false)
	private LocalDateTime createdAt; // time stamp creation
	@CreatedDate
	@Column(name="updated_at",nullable=false)
	private LocalDateTime updatedAt; // time stamp updated

	
	@PrePersist
	public void beforePersist() {
		
	}
	
	
	
	
	
	
	
	
	
}
