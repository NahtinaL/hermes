package com.learning.hermes.services;

import com.learning.hermes.model.PackageStatuses;
import com.learning.hermes.persistance.entities.PackageEntity;
import com.learning.hermes.repository.DepartmentRepository;
import com.learning.hermes.repository.PachageRepository;
import com.learning.hermes.shared.PackageDto;
import com.learning.hermes.utils.PackageStatusManager;
import com.learning.hermes.utils.TtnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class PackageService {

    @Autowired
    PachageRepository packageRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public PackageDto createPackage(PackageDto packageDto) {
        PackageEntity packageEntity;
        packageEntity = PackageEntity.builder()
                .ttn(TtnGenerator.generate())
                .name(packageDto.getName())
//                Create cost calculation
                .cost(100)
                .weight(packageDto.getWeight())
                .fragility(packageDto.getFragility())
                .fee(packageDto.getFee())
                .status(PackageStatusManager.assignCreatedStatus())
                .departmentFrom(departmentRepository.getOne(packageDto.getDepartmentFrom()))
                .departmentTo(departmentRepository.getOne(packageDto.getDepartmentTo()))
                .senderPhone(packageDto.getSenderPhone())
                .receiverPhone(packageDto.getReceiverPhone())
                .createdDate(packageDto.getCreatedDate())
                .build();
        packageRepository.save(packageEntity);

        packageDto.setCost(packageEntity.getCost());
        packageDto.setTtn(packageEntity.getTtn());
        packageDto.setStatus(packageEntity.getStatus().toString());
        return packageDto;
    }
}
