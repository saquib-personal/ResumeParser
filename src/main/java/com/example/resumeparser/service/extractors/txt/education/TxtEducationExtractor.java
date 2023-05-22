package com.example.resumeparser.service.extractors.txt.education;

import com.example.resumeparser.entity.Education;
import com.example.resumeparser.service.extractors.Extractor;

public class TxtEducationExtractor implements Extractor<Education, String> {

    @Override
    public Education extract(String educationContent) {

        final String[] tokenizedEducation = educationContent.split(",");

        final String university = tokenizedEducation[0].trim();
        final String yearsAttended = tokenizedEducation[1].trim();
        final String degree = tokenizedEducation[2].trim();

        return new Education(degree, university, yearsAttended);
    }
}
