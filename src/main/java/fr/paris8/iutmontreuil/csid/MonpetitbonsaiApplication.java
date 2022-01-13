package fr.paris8.iutmontreuil.csid;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(scanBasePackages={"fr.paris8.iutmontreuil.csid", "fr.paris8.iutmontreuil.csid.domain", "fr.paris8.iutmontreuil.csid.exposition", "fr.paris8.iutmontreuil.csid.infrastructure"})
public class MonpetitbonsaiApplication {


    public static void main(String[] args)
    {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(MonpetitbonsaiApplication.class, args);

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}