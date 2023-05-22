package com.example.resumeparser.service.extractors.txt.work;

import com.example.resumeparser.entity.Work;
import com.example.resumeparser.service.extractors.Extractor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TxtWorkRecordsExtractor implements Extractor<List<Work>, String> {

    private final Extractor<Work, String> txtWorkExtractor;

    public TxtWorkRecordsExtractor(Extractor<Work, String> txtWorkExtractor) {

        this.txtWorkExtractor = txtWorkExtractor;
    }

    @Override
    public List<Work> extract(String workContent) {

        return Arrays.stream(workContent.split("\r\n\r\n"))
                .map(txtWorkExtractor::extract)
                .collect(Collectors.toList());
    }
}
