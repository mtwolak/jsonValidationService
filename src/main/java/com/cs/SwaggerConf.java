package com.cs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConf {

	@Bean
	Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(ValidationApplication.class.getPackage().getName()))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("Validation REST API")
				.description("Validation service for trades")
				.version("1.0")
				.license("The GNU General Public License v3.0")
				.licenseUrl("https://www.gnu.org/licenses/gpl-3.0.html")
				.contact(new Contact("Marcin Wolak", "https://github.com/mtwolak", "mtwolak@gmail.com"))
				.build();
	}


}
