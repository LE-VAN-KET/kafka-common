package com.dut.team92.kafka.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberRequestModel implements BaseModel{
    private UUID id;
    private UUID sagaId;
    private UUID userId;
    private String mailNotification;
    private UUID organizationId;
}
