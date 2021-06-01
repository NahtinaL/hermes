package com.learning.hermes.services;

import com.learning.hermes.persistance.entities.PackageEntity;
import com.learning.hermes.repository.DepartmentRepository;
import com.learning.hermes.repository.PackageRepository;
import com.learning.hermes.shared.PackageDto;
import com.learning.hermes.utils.PackageStatusManager;
import com.learning.hermes.utils.TtnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.learning.hermes.services.specifications.PackageSpecs.packageFilteringByUser;


@Service
public class PackageService {

    @Autowired
    PackageRepository packageRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public PackageDto createPackage(PackageDto packageDto) {
        PackageEntity packageEntity;
        packageEntity = PackageEntity.builder()
                .ttn(TtnGenerator.generate())
                .name(packageDto.getName())
//                Create cost calculation
                .cost(1)
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

    public List<PackageDto> findPackages (String ttn, String senderPhone, String receiverPhone, String status, String createdDate) {
        List<PackageEntity> filteredPackages = packageRepository.findAll(packageFilteringByUser(senderPhone, receiverPhone, status));
        List<PackageDto> packageDtoList = filteredPackages.stream().map(p -> {PackageDto packageDto = PackageDto.builder()
                .ttn(p.getTtn())
                .name(p.getName())
                .cost(p.getCost())
                .weight(p.getWeight())
                .fragility(p.getFragility())
                .fee(p.getFee())
                .status(p.getStatus().toString())
                .departmentFrom(p.getDepartmentFrom().getDepartmentId())
                .departmentTo(p.getDepartmentTo().getDepartmentId())
                .senderPhone(p.getSenderPhone())
                .receiverPhone(p.getReceiverPhone())
                .createdDate(p.getCreatedDate())
                .deliverDate(p.getDeliverDate())
                .receivedDate(p.getReceivedDate()).build();
                return packageDto;}).collect(Collectors.toList());

        return packageDtoList;
    }

}
