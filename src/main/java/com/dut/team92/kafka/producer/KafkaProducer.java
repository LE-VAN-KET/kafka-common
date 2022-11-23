package com.dut.team92.kafka.producer;

import com.dut.team92.kafka.model.BaseModel;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.io.Serializable;

public interface KafkaProducer<K extends Serializable, V extends BaseModel> {
    void send(String topicName, K key , V message, ListenableFutureCallback<SendResult<K,V>> callback);
}
