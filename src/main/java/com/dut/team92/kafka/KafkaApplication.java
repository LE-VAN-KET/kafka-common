package com.dut.team92.kafka;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@ComponentScan("com.dut.team92.kafka")
@EnableKafka
public class KafkaApplication {
}
