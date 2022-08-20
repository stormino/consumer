package io.thinkin.exercise.consumer.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

public class KafkaTopicConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    String bootstrapServers;

    @Value("${sender.topic.name}")
    String topicName;

    @Value("${sender.topic.partitions}")
    Integer topicPartitions;

    @Bean
    public KafkaAdmin adminClient() {

        Map<String, Object> properties = new HashMap<>();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(properties);
    }

    @Bean
    public NewTopic topicIngestion() {
        return TopicBuilder.name(topicName)
                .partitions(topicPartitions)
                .compact()
                .build();
    }
}
