package com.learning.hermes.model.response;

import com.learning.hermes.persistance.entities.Department;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
public class PackageDetailsResponce {

    private String ttn;
    private String name;
    private Integer cost;
    private Integer weight;
    private String fragility;
    private Integer fee;
    private String status;
    private Integer departmentFrom;
    private Integer departmentTo;
    private String senderPhone;
    private String receiverPhone;
    private Date createdDate;
    private String deliverDate;
    private String receivedDate;

}
