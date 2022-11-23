package com.dut.team92.kafka.producer;

import com.dut.team92.kafka.model.BaseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.Objects;

@Component
@Slf4j
public class KafkaProducerImpl<K extends Serializable, V extends BaseModel> implements KafkaProducer<K, V> {
    @Autowired
    private KafkaTemplate<K, V> kafkaTemplate;

    @Override
    public void send(String topicName, K key, V message, ListenableFutureCallback<SendResult<K, V>> callback) {
        log.debug("Sending message to topic: {}, also message {}", topicName, message);
        kafkaTemplate.send(topicName, key, message)
                .addCallback(new ListenableFutureCallback<SendResult<K, V>>() {
                    @Override
                    public void onFailure(Throwable ex) {
                        log.error("Error sending message to topic: {}, also message {}", topicName, message, ex);
                        callback.onFailure(ex);
                    }

                    @Override
                    public void onSuccess(SendResult<K, V> result) {
                        log.debug("Message sent to topic: {}, also message {}", topicName, message);
                        callback.onSuccess(result);
                    }
                });
    }

    @PreDestroy
    public void destroy() {
        log.debug("KafkaProducerImpl is being destroyed");
        if (Objects.nonNull(kafkaTemplate)) {
            kafkaTemplate.destroy();
        }
    }

}
