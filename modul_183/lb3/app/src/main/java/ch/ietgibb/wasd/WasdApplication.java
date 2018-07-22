package ch.ietgibb.wasd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class WasdApplication {

    public static void main(String[] args) {
        SpringApplication.run(WasdApplication.class, args);
    }
}
