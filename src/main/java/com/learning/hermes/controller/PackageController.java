package com.learning.hermes.controller;

import com.learning.hermes.model.request.PackageDetailRequest;
import com.learning.hermes.model.response.PackageDetailsResponce;
import com.learning.hermes.services.PackageService;
import com.learning.hermes.shared.PackageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    PackageService packageService;

    @GetMapping
    public String getPackage() {
        return "";
    }

    @PostMapping
    public ResponseEntity<PackageDetailsResponce> createPackage(@Valid @RequestBody PackageDetailRequest requestBody) {
        PackageDto packageDto = PackageDto.builder()
                .name(requestBody.getName())
                .weight(requestBody.getWeight())
                .fragility(requestBody.getFragility())
                .departmentTo(requestBody.getDepartmentTo())
                .senderPhone(requestBody.getSenderPhone())
                .receiverPhone(requestBody.getReceiverPhone()).build();

        packageService.createPackage(packageDto);
        PackageDetailsResponce packageDetailsResponce = PackageDetailsResponce.builder().build();
        return new ResponseEntity<>(packageDetailsResponce, new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @PutMapping
    public String updatePackage() {
        return "";
    }

    @DeleteMapping
    public String deletePackage() {
        return "";
    }
}
