package com.example.resumeparser.entity;

import java.util.List;

public class Resume {

    private List<Education> education;
    private List<Work> work;

    public Resume(List<Education> education, List<Work> work) {

        this.education = education;
        this.work = work;
    }

    public List<Education> getEducation() {
        return education;
    }

    public List<Work> getWork() {
        return work;
    }
}
