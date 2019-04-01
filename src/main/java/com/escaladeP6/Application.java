package com.escaladeP6;



import com.escaladeP6.storage.StorageProperties;
import com.escaladeP6.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

private static final Logger logger = LoggerFactory.getLogger((Application.class));

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("L'application Spring Boot Escalade P6 démarre...");


    }


    //vidange du dossier de stockage des fichiers téléchargés
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

}