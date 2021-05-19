package com.learning.hermes.services.specifications;

import com.learning.hermes.persistance.entities.PackageEntity;
import org.springframework.data.jpa.domain.Specification;

public class PackageSpecs {

    public static Specification<PackageEntity> getPackageByTtn (String ttn) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("ttn"), ttn);
        };
    }

    public static Specification<PackageEntity> getPackagesByUser (String senderPhone) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("senderPhone"), senderPhone);
        };
    }
}
