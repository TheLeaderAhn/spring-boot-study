package io.ahnjy.ch5board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ch5boardApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch5boardApplication.class, args);
    }

}
