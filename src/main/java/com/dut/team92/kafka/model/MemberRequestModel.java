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
    private String username;
    private String mailNotification;
    private UUID organizationId;
    private Boolean isOrganizerAdmin = false;
    private Boolean isSystemAdmin = false;
    private Boolean isDelete = false;
    private String status;
    private String firstName;
    private String lastName;
    private String displayName;
}
