package com.demo.dataAudit.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.javers.spring.auditable.AuthorProvider;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.proto.demo.controllers")).paths(PathSelectors.any())
				.build().apiInfo(getApiInformation()).useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages());
	}

	private ApiInfo getApiInformation() {
		return new ApiInfo("Demo", "Envers/JaVers created using Spring Boot", "1.0", "API",
				new Contact("vinaya", "", ""), "", "", Collections.emptyList());
	}

	private List<ResponseMessage> getCustomizedResponseMessages() {
		List<ResponseMessage> responseMessages = new ArrayList<>();
		responseMessages.add(new ResponseMessageBuilder().code(500).message("Server has crashed!!")
				.responseModel(new ModelRef("Error")).build());
		responseMessages.add(new ResponseMessageBuilder().code(403).message("You shall not pass!!").build());
		return responseMessages;
	}

	@Bean
	public AuthorProvider provideJaversAuthor() {
		return new SimpleAuthorProvider();
	}

	private static class SimpleAuthorProvider implements AuthorProvider {
		@Override
		public String provide() {
			return "example Author";
		}
	}
}

