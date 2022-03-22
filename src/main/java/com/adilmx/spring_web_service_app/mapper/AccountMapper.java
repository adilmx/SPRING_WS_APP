package com.adilmx.spring_web_service_app.mapper;

import com.adilmx.spring_web_service_app.entity.Account;

/*import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")*/
public interface AccountMapper {
    //AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountSoapToAccountEntity(com.adilmx.soap.Account account);
    com.adilmx.soap.Account accountEntityToAccountSoap(Account account);
}
