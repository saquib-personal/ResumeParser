package com.example.resumeparser.service;

import com.example.resumeparser.controllers.ResumeRequest;
import com.example.resumeparser.entity.Resume;
import com.example.resumeparser.exceptions.FileTypeNotSupportedException;
import com.example.resumeparser.service.builder.ResumeBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final List<ResumeBuilder> resumeBuilders;

    public ResumeServiceImpl(List<ResumeBuilder> resumeBuilders) {
        this.resumeBuilders = resumeBuilders;
    }


    @Override
    public Resume extractResume(final ResumeRequest resumeRequest) {

        final String fileType = resumeRequest.getFileType();

        return resumeBuilders.stream()
                .filter(resumeBuilder -> resumeBuilder.supportsFileType(fileType))
                .findFirst()
                .map(resumeBuilder -> resumeBuilder.build(resumeRequest))
                .orElseThrow(() -> new FileTypeNotSupportedException(fileType));
    }
}
