package com.adilmx.spring_web_service_app.mapper;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adilmx.spring_web_service_app.entity.Account;
import com.adilmx.spring_web_service_app.utils.DateUtils;

@Component
public class AccountMapperSoap {

	@Autowired
	private DateUtils dateUtils ;


	public com.adilmx.soap.Account accountEntityToAccountSoap(Account account) throws DatatypeConfigurationException{
		com.adilmx.soap.Account accountGenerated = new com.adilmx.soap.Account();
		accountGenerated.setId(account.getId()); 
		accountGenerated.setSold(account.getSold());
		accountGenerated.setActivated(account.isActivated());
		accountGenerated.setDateCreation(dateUtils.dateToxmlGregorianCalendar(account.getDateCreation()));
		return accountGenerated;
	}
}
