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

class Test {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Set<String> commonLocations = getSuspiciousLocations(LOGINS);
        System.out.println(commonLocations);
        commonLocations = getCommonLocationsSlidingWindow2(LOGINS);
        System.out.println(commonLocations);
    }

    /**
     * Return a set of common locations. A location is defined as common
     * if there are at least 2 logins from that location in
     * a 2 hour window (7200 seconds).
     */
    private static Set<String> getCommonLocationsSlidingWindow2(List<LoginEvent> logins) {
        Set<String> commonLocations = new HashSet<String>();
        HashMap<String, List<Integer>> locationLogins = new HashMap<>();
        
    }

        /**
     * Find locations with suspicious activity:
     * - More than 5 logins from a single location within 30 minutes (1800 seconds)
     */
    private static Set<String> getSuspiciousLocations(List<LoginEvent> logins) {
        // TODO: implement
        return new HashSet<>();
    }

    /**
     * Find peak hour locations:
     * - At least 10 logins from a location within any 4 hour window (14400 seconds)
     */
    private static Set<String> getPeakHourLocations(List<LoginEvent> logins) {
        // TODO: implement
        return new HashSet<>();
    }

    /**
     * Find locations with consistent usage:
     * - Logins from location across at least 3 different days
     */
    private static Set<String> getConsistentLocations(List<LoginEvent> logins) {
        // TODO: implement
        return new HashSet<>();
    }

    /**
     * Find locations with burst activity:
     * - 3+ logins within 15 minutes (900 seconds), then a pause of at least 2 hours
     */
    private static Set<String> getBurstActivityLocations(List<LoginEvent> logins) {
        // TODO: implement
        return new HashSet<>();
    }

    /**
     * Find locations active across consecutive days:
     * - Logins from location in the last hour of one day (23:00-24:00)
     * - And in the first hour of the next day (00:00-01:00)
     */
    private static Set<String> getCrossDayLocations(List<LoginEvent> logins) {
        // TODO: implement
        return new HashSet<>();
    }

    /**
     * Find most popular locations by day of week:
     * - Return Map<DayOfWeek, String> - most popular location for each day
     */
    private static Map<String, String> getMostPopularByDayOfWeek(List<LoginEvent> logins) {
        // TODO: implement (will need epochSeconds to day of week conversion)
        return new HashMap<>();
    }

    /**
     * Find locations with long gaps:
     * - More than 6 hours between two logins from the same location
     */
    private static Set<String> getLocationWithLongGaps(List<LoginEvent> logins) {
        // TODO: implement
        return new HashSet<>();
    }

    /**
     * Find concurrent location pairs:
     * - Logins from different locations within 5 minutes (300 seconds)
     * - Return location pairs Set<String> where String = "Location1,Location2"
     */
    private static Set<String> getConcurrentLocationPairs(List<LoginEvent> logins) {
        // TODO: implement
        return new HashSet<>();
    }

    /**
     * Find locations with progressive activity:
     * - Each subsequent day has more logins from location than the previous day
     * - At least 3 consecutive days
     */
    private static Set<String> getProgressiveActivityLocations(List<LoginEvent> logins) {
        // TODO: implement
        return new HashSet<>();
    }

    /**
     * Find weekday-only locations:
     * - Logins only on weekdays (Monday-Friday)
     * - At least 2 logins on weekdays, 0 logins on weekends
     */
    private static Set<String> getWorkdayOnlyLocations(List<LoginEvent> logins) {
        // TODO: implement
        return new HashSet<>();
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
}

class LoginEvent {
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