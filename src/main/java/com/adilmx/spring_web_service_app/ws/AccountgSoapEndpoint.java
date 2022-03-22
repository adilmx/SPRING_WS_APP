package com.adilmx.spring_web_service_app.ws;

import com.adilmx.soap.GetAccountRequest;
import com.adilmx.soap.GetAccountResponse;
import com.adilmx.spring_web_service_app.dao.AccountRepo;
import com.adilmx.spring_web_service_app.entity.Account;
import com.adilmx.spring_web_service_app.mapper.AccountMapper;
import com.adilmx.spring_web_service_app.mapper.AccountMapperSoap;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountgSoapEndpoint {
    public static final String NAME_SPACE = "http://www.adilmx.com/soap";
    @Autowired
    private AccountRepo accountRepo;
    
    @Autowired
    private AccountMapperSoap accountMapperSoap ;

    @ResponsePayload //as ResponseBody of spring MVC
    @PayloadRoot(localPart = "GetAccountRequest",namespace = NAME_SPACE)
    public GetAccountResponse getAccount(@RequestPayload GetAccountRequest request) throws DatatypeConfigurationException{
        GetAccountResponse response = new GetAccountResponse();
        Account account = accountRepo.findById(request.getId()).get();
        com.adilmx.soap.Account accountResponse = accountMapperSoap.accountEntityToAccountSoap(account);
        response.setAccount(accountResponse);
        return response;
    }
}
