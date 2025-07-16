package com.other.prepRapid;

import java.util.*;

public class SolutionTwo {
    public static void main(String[] args) {
//        System.out.println("Hello!");
//        Set<String> commonLocations = getCommonLocationsDaily(LOGINS);
//        System.out.println(commonLocations);
        Set<String> commonLocations = getCommonLocations(LOGINS);
        System.out.println(commonLocations);
    }

     record Record (
         String location,
         String day
     ){};

    public static Set<String> getCommonLocations(List<LoginEventTwo> events) {
        Set<String> commonLocations = new HashSet<>();
        Map<Record, Integer> locationsMap = new HashMap<>();
        for (LoginEventTwo event : events) {
            Record key = new Record(event.getLocation(), event.getDay());
            if (!locationsMap.containsKey(key)) {
                locationsMap.put(key, 1);
                continue;
            }

            locationsMap.put(key, locationsMap.get(key) + 1);
        }

        for (Map.Entry<Record, Integer> record : locationsMap.entrySet()) {
            if (record.getValue() >= 3) {
                commonLocations.add(record.getKey().location);
            }
        }

        return commonLocations;
    }

    /**
     * Return a set of common locations. A location is defined as common
     * if there are at least 2 logins from that location in
     * a 2 hour window (7200 seconds).
     */
    private static Set<String> getCommonLocationsSlidingWindow(List<LoginEventTwo> logins) {
        Set<String> commonLocations = new HashSet<String>();
        HashMap<String, Integer> matches = new HashMap<>();
        for (LoginEventTwo loginEventTwo : logins) {
            if (commonLocations.contains(loginEventTwo.getLocation()))
                continue;

            if (!matches.containsKey(loginEventTwo.getLocation())) {
                matches.put(loginEventTwo.getLocation(), loginEventTwo.getEpochSeconds());
                continue;
            }

            if (loginEventTwo.getEpochSeconds() - matches.get(loginEventTwo.getLocation()) > 7200) {
                matches.put(loginEventTwo.getLocation(), loginEventTwo.getEpochSeconds());
                continue;
            }

            commonLocations.add(loginEventTwo.getLocation());
        }
        return commonLocations;
    }

    // A list of login events for a user.
    private static final List<LoginEventTwo> LOGINS = List.of(
            // Logins for Jan. 15
            new LoginEventTwo("Dublin", "20220115", 1642242000), // 10:20am
            new LoginEventTwo("Boston", "20220115", 1642242600), // 10:30am
            new LoginEventTwo("Dublin", "20220115", 1642245600), // 11:20am
            new LoginEventTwo("Boston", "20220115", 1642253400), // 01:30pm
            new LoginEventTwo("Boston", "20220115", 1642262400), // 04:00pm

            // Logins for Jan. 16
            new LoginEventTwo("Dublin", "20220116", 1642328400), // 10:20am
            new LoginEventTwo("Belfast", "20220116", 1642328400), // 10:20am

            // Logins for Jan. 17
            new LoginEventTwo("Dublin", "20220117", 1642328400), // 10:20am
            new LoginEventTwo("Belfast", "20220117", 1642328400), // 10:20am

            // Logins for Jan. 18
            new LoginEventTwo("Boston", "20220118", 1642328400), // 10:20am
            new LoginEventTwo("Boston", "20220118", 1642328400), // 10:20am
            new LoginEventTwo("Boston", "20220118", 1642328400), // 10:20am
            new LoginEventTwo("Boston", "20220118", 1642328400), // 10:20am

            // Logins for Jan. 19
            new LoginEventTwo("Dublin", "20220119", 1642328400), // 10:20am
            new LoginEventTwo("Dublin", "20220119", 1642328400), // 10:20am
            new LoginEventTwo("Dublin", "20220119", 1642328400), // 10:20am
            new LoginEventTwo("Dublin", "20220119", 1642328400)  // 10:20am
    );
}

class LoginEventTwo {
    private final String location;
    private final String day;
    private final int epochSeconds;

    public LoginEventTwo(String location, String day, int epochSeconds) {
        // Assume all fields are provided
        this.location = location;
        this.day = day;
        this.epochSeconds = epochSeconds;
    }

    public String getLocation() {
        return this.location;
    }

    public String getDay() {
        return this.day;
    }

    public int getEpochSeconds() {
        return this.epochSeconds;
    }
}
