package com.learning.hermes.services;

import com.learning.hermes.repository.DepartmentRepository;
import com.learning.hermes.repository.PachageRepository;
import com.learning.hermes.shared.PackageDto;
import com.learning.hermes.utils.PackageStatusManager;
import com.learning.hermes.utils.TtnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    @Autowired
    PachageRepository packageRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public void createPackage(PackageDto packageDto) {

        packageDto.setTtn(TtnGenerator.generate());
        packageDto.setStatus(PackageStatusManager.assignStatus());



    }
}
