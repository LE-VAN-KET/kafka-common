package com.dut.team92.kafka.saga;

public interface SagaStep<T> {
    void process(T data);
    void rollback(T data);
}
