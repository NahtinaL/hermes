package com.learning.hermes.repository;

import com.learning.hermes.persistance.entities.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer>,
        JpaSpecificationExecutor <PackageEntity>{

}
