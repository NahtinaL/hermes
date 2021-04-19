package com.learning.hermes.utils;


import com.learning.hermes.model.PackageStatuses;


public class PackageStatusManager {

    public static PackageStatuses assignCreatedStatus() {
        return PackageStatuses.CREATED;
    }

    public static PackageStatuses assignOnWayStatus() {
        return PackageStatuses.ON_WAY;
    }

    public static PackageStatuses assignDeliveredStatus() {
        return PackageStatuses.DELIVERED;
    }

    public static PackageStatuses assignReceivedStatus() {
        return PackageStatuses.RECEIVED;
    }

    public static PackageStatuses assignAbandonedStatus() {
        return PackageStatuses.ABANDONED;
    }

}
