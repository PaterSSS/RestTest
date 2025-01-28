package com.restfullAppLesson.restTest.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic restTestTopic() {
        return new NewTopic(
                "course",
                1,
                (short) 1
        );
    }
}
