package com.ivanplyaskin.cruder.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.ivanplyaskin.cruder")
@Import({WebConfiguration.class, HibernateConfiguration.class})
public class RootConfiguration {

}
