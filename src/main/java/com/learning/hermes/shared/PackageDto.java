package com.learning.hermes.shared;

import com.learning.hermes.persistance.entities.Department;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder

public class PackageDto implements Serializable {

    private static final long serialVersionUID = 9L;
    private Integer id;
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
