package com.adilmx.spring_web_service_app.conf;

import com.adilmx.spring_web_service_app.ws.AccountgSoapEndpoint;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SpringWebServiceConfig {
    //generate and deploy a new instance for the servlet MessageDispatcherServlet to be able to receive and send ws request/responses
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        //context of spring application
        servlet.setApplicationContext(applicationContext);
        //to generate wsdl to client
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
    //a bean to be able to get th schema of our application
    @Bean
    public XsdSchema xsdSchemaDescription() {
        SimpleXsdSchema simpleXsdSchema = new SimpleXsdSchema();
        simpleXsdSchema.setXsd(new ClassPathResource("contract.xsd"));
        return simpleXsdSchema;
    }

    //a bean that will generate the WSDL with http://localhost:8080/ws/bank.wsdl
    @Bean(name = "bank")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchemaDescription) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        //any name for this port type name
        wsdl11Definition.setPortTypeName("AccountService");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setSchema(xsdSchemaDescription);
        wsdl11Definition.setTargetNamespace(AccountgSoapEndpoint.NAME_SPACE);
        return wsdl11Definition;
    }


}
