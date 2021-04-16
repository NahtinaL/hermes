package com.learning.hermes.model;

public enum PackageStatuses {

    CREATED("created"),
    ON_WAY("on way"),
    DELIVERED("delivered"),
    RECEIVED("received"),
    ABANDONED("abandoned");

    private String status;

    private PackageStatuses(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
