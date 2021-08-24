package com.acabra.clr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class ClrApplication {

    private static final Logger logger = LoggerFactory.getLogger(ClrApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ClrApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            logger.info("Starting CLI ...");
            fizzBuzz();
            //rooms(restTemplate);
            logger.info("Finishing CLI ...");
        };
    }

    private void fizzBuzz() {
        IntStream.range(1, 100)
                .forEach(i -> {
                    boolean div3 = i % 3 == 0;
                    boolean div5 = i % 5 == 0;
                    if(div3 && div5) {
                        logger.info("for {} print {}", i, "FizzBuzz");
                    } else if(div3) {
                        logger.info("for {} print {}", i, "Fizz");
                    } else if(div5) {
                        logger.info("for {} print {}", i, "Buzz");
                    } else {
                        logger.info("for {} print {}", i, i);

                    }
                });
    }

    private void rooms(RestTemplate restTemplate) {
        final HttpHeaders headers =  new HttpHeaders(){{
            setAccept(List.of(MediaType.APPLICATION_JSON));
        }};
        ResponseEntity<List<HotelRoom>> rooms = restTemplate.exchange("http://localhost:9000/api/rooms",
                HttpMethod.GET, new HttpEntity<>("body", headers), new ParameterizedTypeReference<List<HotelRoom>>() {
                });
        rooms.getBody().forEach(room -> logger.info("room: {}", room.toString()));
    }

}
