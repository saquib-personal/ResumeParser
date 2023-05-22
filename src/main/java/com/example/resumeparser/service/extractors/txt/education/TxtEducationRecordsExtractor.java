package com.example.resumeparser.service.extractors.txt.education;

import com.example.resumeparser.entity.Education;
import com.example.resumeparser.service.extractors.Extractor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TxtEducationRecordsExtractor implements Extractor<List<Education>, String> {

    private final TxtEducationExtractor txtEducationExtractor;

    public TxtEducationRecordsExtractor(TxtEducationExtractor txtEducationExtractor) {
        this.txtEducationExtractor = txtEducationExtractor;
    }

    @Override
    public List<Education> extract(String educationContent) {

        return Arrays.stream(educationContent.split("\r\n"))
                .map(txtEducationExtractor::extract)
                .collect(Collectors.toList());
    }
}
