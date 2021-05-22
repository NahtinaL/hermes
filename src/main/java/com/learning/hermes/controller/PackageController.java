package com.learning.hermes.controller;

import com.learning.hermes.services.PackageService;
import com.learning.hermes.shared.PackageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {

    @Autowired
    PackageService packageService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PackageDto> getPackage(@RequestBody String ttn, String senderPhone, String receiverPhone, String status, String createdDate) {
       List <PackageDto> response = packageService.findPackages(null, "1233223", null, null, null);
       return response;
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
