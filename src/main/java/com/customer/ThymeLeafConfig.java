package com.customer;

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
public class ThymeLeafConfig {
@Bean
public SpringTemplateEngine springTeremplateEngine() {
	SpringTemplateEngine templateEngine=new SpringTemplateEngine();
	templateEngine.addTemplateResolver(htmlTemplateResolver());
	return templateEngine;
}

@Bean
public SpringResourceTemplateResolver htmlTemplateResolver() {
	SpringResourceTemplateResolver emailResolver=new SpringResourceTemplateResolver();
	emailResolver.setPrefix("classpath:/emailTemplates/");
	emailResolver.setSuffix(".html");
	emailResolver.setTemplateMode(TemplateMode.HTML);
	emailResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
	return emailResolver;
}
}
