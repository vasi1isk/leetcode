package com.other.prepRapid;/* Click `Run` to execute the snippet below! */

import java.io.*;
import java.util.*;
import com.google.common.collect.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Set<String> commonLocations = getCommonLocationsDaily(LOGINS);
        System.out.println(commonLocations);
        // commonLocations = getCommonLocationsSlidingWindow(LOGINS);
        // System.out.println(commonLocations);
    }

    /**
     * Return a set of common locations.
     * A location is defined as common
     * if there are at least 3 logins from that location in a single
     * calendar day.
     * <p>
     * You can ignore the epochSeconds field in the test data for this exercise.
     */
    private static Set<String> getCommonLocationsDaily(List<LoginEvent> logins) {
        Set<String> commonLocations = new HashSet<String>();
        HashMap<String, ArrayList<String>> daysMap = new HashMap<String, ArrayList<String>>();

        // fill in daysMap with days and the locations from which logins occurred
        for (LoginEvent event : logins) {
            String day = event.getDay();
            if (!daysMap.containsKey(day)) {
                daysMap.put(day, new ArrayList<String>());
                daysMap.get(day).add(event.getLocation());
            } else {
                daysMap.get(day).add(event.getLocation());
            }
        }

        // counts the number of times an event occurred from a location on each day
        for (String day : daysMap.keySet()) {
            HashMap<String, Integer> locationCounter = new HashMap<String, Integer>();
            for (String location : daysMap.get(day)) {
                if (!locationCounter.containsKey(location)) {
                    locationCounter.put(location, 1);
                } else {
                    locationCounter.put(location, locationCounter.get(location) + 1);
                }
            }

            // fills up commonlocation with locations that were counted 3 or more times
            for (String location : locationCounter.keySet()) {
                if (locationCounter.get(location) >= 3) {
                    commonLocations.add(location);
                }
            }
        }

        // print the contents of daysMap
        // for(String day: daysMap.keySet()){
        //     System.out.println("-------------------------");
        //     System.out.println(day);
        //     for(String location: daysMap.get(day)){
        //         System.out.println(location);
        //     }
        // }

        return commonLocations;
    }

    /**
     * Return a set of common locations. A location is defined as common
     * if there are at least 2 logins from that location in
     * a 2 hour window (7200 seconds).
     */
    private static Set<String> getCommonLocationsSlidingWindow(List<LoginEvent> logins) {
        // TODO
        return null;
    }

    // A list of login events for a user.
    private static final List<LoginEvent> LOGINS = List.of(
            // Logins for Jan. 15
            new LoginEvent("Dublin", "20220115", 1642242000), // 10:20am
            new LoginEvent("Boston", "20220115", 1642242600), // 10:30am
            new LoginEvent("Dublin", "20220115", 1642245600), // 11:20am
            new LoginEvent("Boston", "20220115", 1642253400), // 01:30pm
            new LoginEvent("Boston", "20220115", 1642262400), // 04:00pm

            // Logins for Jan. 16
            new LoginEvent("Dublin", "20220116", 1642328400), // 10:20am
            new LoginEvent("Belfast", "20220116", 1642328400), // 10:20am

            // Logins for Jan. 17
            new LoginEvent("Dublin", "20220117", 1642328400), // 10:20am
            new LoginEvent("Belfast", "20220117", 1642328400), // 10:20am

            // Logins for Jan. 18
            new LoginEvent("Boston", "20220118", 1642328400), // 10:20am
            new LoginEvent("Boston", "20220118", 1642328400), // 10:20am
            new LoginEvent("Boston", "20220118", 1642328400), // 10:20am
            new LoginEvent("Boston", "20220118", 1642328400), // 10:20am

            // Logins for Jan. 19
            new LoginEvent("Dublin", "20220119", 1642328400), // 10:20am
            new LoginEvent("Dublin", "20220119", 1642328400), // 10:20am
            new LoginEvent("Dublin", "20220119", 1642328400), // 10:20am
            new LoginEvent("Dublin", "20220119", 1642328400) // 10:20am
    );


    static class LoginEvent {
        private final String location;
        private final String day;
        private final int epochSeconds;

        public LoginEvent(String location, String day, int epochSeconds) {
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

}