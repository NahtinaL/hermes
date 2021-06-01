package com.learning.hermes.services.specifications;

import com.learning.hermes.persistance.entities.PackageEntity;
import org.springframework.data.jpa.domain.Specification;

public class PackageSpecs {

    public static Specification<PackageEntity> packageFilteringByUser(String senderPhone, String receiverPhone, String status) {
            Specification<PackageEntity> result = Specification.where(getPackagesBySenderPhone(senderPhone));

            if (!receiverPhone.isBlank()) {
                result = result.and(getPackagesByReceiverPhone(receiverPhone));
            }

            if (!status.isBlank()) {
                result = result.and(getPackagesByStatus(status));
            }

            return result;
    }

    public static Specification<PackageEntity> getPackageByTtn (String ttn) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("ttn"), ttn);
        };
    }

    public static Specification<PackageEntity> getPackagesBySenderPhone (String senderPhone) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("senderPhone"), senderPhone);
        };
    }

    public static Specification<PackageEntity> getPackagesByReceiverPhone (String receiverPhone) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("receiverPhone"), receiverPhone);
        };
    }

    public static Specification<PackageEntity> getPackagesByStatus (String status) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("status"), status);
        };
    }

    public static Specification<PackageEntity> getPackagesByCreatedDate (String createdDate) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("createdDate"), createdDate);
        };
    }

    public static Specification<PackageEntity> getPackagesbyDepartmentFrom (String departmentFrom) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("departmentFrom"), departmentFrom);
        };
    }

    public static Specification<PackageEntity> getPackagesbyDepartmentTo (String departmentTo) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("departmentTo"), departmentTo);
        };
    }
}
