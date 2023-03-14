package com.LiftOff.Job_Organizer.models;

import java.util.ArrayList;

public class JobData {

    public static ArrayList<Job> findByColumnAndValue(String column, String value, Iterable<Job> allJobs) {

        ArrayList<Job> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Job>) allJobs;
        }

        if (column.equals("all")){
            results = findByValue(value, allJobs);
            return results;
        }
        for (Job job : allJobs) {

            String aValue = getFieldValue(job, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(job);
            }
        }

        return results;
    }

    public static String getFieldValue(Job job, String fieldName){
        String theValue;
        if (fieldName.equals("title")){
            theValue = job.getTitle();
        } else if (fieldName.equals("location")){
            theValue = job.getLocation().toString();
        } else {
            theValue = job.getDescription().toString();
        }

        return theValue;
    }

    public static ArrayList<Job> findByValue(String value, Iterable<Job> allJobs) {
        String lower_val = value.toLowerCase();

        ArrayList<Job> results = new ArrayList<>();

        for (Job job : allJobs) {

            if (job.getTitle().toLowerCase().contains(lower_val)) {
                results.add(job);
            } else if (job.getLocation().toLowerCase().contains(lower_val)) {
                results.add(job);
            } else if (job.getDescription().toLowerCase().contains(lower_val)) {
                results.add(job);
            } else if (job.toString().toLowerCase().contains(lower_val)) {
                results.add(job);
            }

        }

        return results;
    }


}
