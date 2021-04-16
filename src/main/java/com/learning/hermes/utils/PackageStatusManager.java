package com.learning.hermes.utils;


import com.learning.hermes.model.PackageStatuses;
import com.learning.hermes.shared.PackageDto;

import java.util.Arrays;

public class PackageStatusManager {

    public static String assignStatus() {
        return PackageStatuses.CREATED.getStatus();
    }

    public static String changeStatus(String currentStatus) {
        return null;
    }

}
