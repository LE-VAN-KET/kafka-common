package com.dut.team92.kafka.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class KafkaMessageHelper {
    public <T> ListenableFutureCallback<SendResult<String, T >> getKafkaCallBack(String responseTopicName,
                                                                                 T model, String id,
                                                                                 String requestModelName) {
        return new ListenableFutureCallback<SendResult<String, T>>() {
            @Override
            public void onSuccess(SendResult<String, T> result) {
                RecordMetadata recordMetadata = result.getRecordMetadata();
                log.info("Received successful response from kafka for id : {} Topic : {} Partition : {} , " +
                                "Offset : {} , Timestamp : {}",
                        id,
                        recordMetadata.topic(),
                        recordMetadata.partition(),
                        recordMetadata.offset(),
                        recordMetadata.timestamp());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Error while sending {} with message: {} to topic {}",
                        requestModelName, model.toString(), responseTopicName, ex);
            }
        };
    }
}
