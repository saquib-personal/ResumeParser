package com.example.resumeparser.entity;

public class Education {

    private final String degree;
    private final String university;
    private final String yearsAttended;

    public Education(String degree, String university, String yearsAttended) {

        this.degree = degree;
        this.university = university;
        this.yearsAttended = yearsAttended;
    }

    public String getDegree() {
        return degree;
    }

    public String getUniversity() {
        return university;
    }

    public String getYearsAttended() {
        return yearsAttended;
    }
}
