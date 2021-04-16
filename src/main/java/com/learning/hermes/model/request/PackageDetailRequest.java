package com.learning.hermes.model.request;

import com.learning.hermes.persistance.entities.Department;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PackageDetailRequest {

    @NotNull
    private String name;

    @NotNull
    private Integer weight;

    private String fragility;

    @NotNull
    private Department departmentTo;

    @NotNull
    private String senderPhone;

    @NotNull
    private String receiverPhone;

}
