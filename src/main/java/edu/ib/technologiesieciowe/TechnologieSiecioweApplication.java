package edu.ib.technologiesieciowe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class TechnologieSiecioweApplication {

    @Bean
    public org.modelmapper.ModelMapper modelMapper() {
        return new org.modelmapper.ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(TechnologieSiecioweApplication.class, args);
    }

}
