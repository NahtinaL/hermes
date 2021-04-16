package com.learning.hermes.repository;

import com.learning.hermes.persistance.entities.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PachageRepository extends JpaRepository<PackageEntity, Integer> {

}
