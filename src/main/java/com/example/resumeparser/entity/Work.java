package com.example.resumeparser.entity;

public class Work {

    private final String company;
    private final String jobDescription;
    private final String yearsAttended;

    public Work(String company, String jobDescription, String yearsAttended) {

        this.company = company;
        this.jobDescription = jobDescription;
        this.yearsAttended = yearsAttended;
    }

    public String getCompany() {
        return company;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getYearsAttended() {
        return yearsAttended;
    }
}
