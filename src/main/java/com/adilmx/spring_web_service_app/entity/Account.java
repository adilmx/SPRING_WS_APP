package com.adilmx.spring_web_service_app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double sold;
	private Date dateCreation;
	private boolean activated;
	
}
