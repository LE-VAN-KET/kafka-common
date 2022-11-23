package com.dut.team92.kafka.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrganizationResponseModel implements BaseModel{
    private UUID id;
    private UUID sagaId;
    private String name;
    private UUID organizationId;
    private String description;
    private Boolean isDelete;
    private String logo;
    private UUID userId;
    private Timestamp createAt;
    private Timestamp updateAt;
    private List<String> failureMessages;
}
