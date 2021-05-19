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

import static com.learning.hermes.services.specifications.PackageSpecs.getPackageByTtn;

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

    public List <PackageEntity> packageFiltering(String ttn) {

       List<PackageEntity> packages = packageRepository.findAll(getPackageByTtn(ttn));
        System.out.println("");
       return packages;
    }
}
