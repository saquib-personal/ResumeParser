package com.example.resumeparser.service.extractors.txt.work;

import com.example.resumeparser.entity.Work;
import com.example.resumeparser.service.extractors.Extractor;

public class TxtWorkExtractor implements Extractor<Work, String> {

    @Override
    public Work extract(String workExperienceContent) {

        final String firstLine = workExperienceContent.substring(0, workExperienceContent.indexOf("\r\n"));
        final String[] tokenizedFirstLine = firstLine.split(",");
        final String company = tokenizedFirstLine[0].trim();
        final String yearsAttended = tokenizedFirstLine[1].trim();

        final String jobDescription = workExperienceContent.split("Responsibilities:")[1].trim();

        return new Work(company, jobDescription, yearsAttended);
    }
}
