package com.dut.team92.kafka.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Slf4j
public class ListMemberRequestModel implements BaseModel, Deserializer {
    private List<MemberRequestModel> memberRequestModels;

    @Override
    public Object deserialize(String s, byte[] bytes) {
        ListMemberRequestModel obj = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            obj = mapper.readValue(bytes, ListMemberRequestModel.class);
        } catch (Exception e) {
            log.error("Deserializer payload error: {}", e.getMessage());
        }
        return obj;
    }
}
