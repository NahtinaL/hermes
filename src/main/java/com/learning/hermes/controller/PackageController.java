package com.learning.hermes.controller;

import com.learning.hermes.model.request.PackageDetailRequest;
import com.learning.hermes.model.response.PackageDetailsResponce;
import com.learning.hermes.persistance.entities.PackageEntity;
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
    public ResponseEntity<PackageDto> createPackage(@Valid @RequestBody PackageDto packageDetails) {
        PackageDto packageDetailsResponce = packageService.createPackage(packageDetails);
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
