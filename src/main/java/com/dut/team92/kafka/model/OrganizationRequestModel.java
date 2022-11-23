package com.dut.team92.kafka.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrganizationRequestModel implements BaseModel {
    private UUID id;
    private UUID sagaId;
    private String name;
    private String description;
    private Boolean isDelete;
    private String logo;
    private UUID userId;
}
