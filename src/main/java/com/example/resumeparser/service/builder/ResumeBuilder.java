package com.example.resumeparser.service.builder;

import com.example.resumeparser.controllers.ResumeRequest;
import com.example.resumeparser.entity.Resume;

public interface ResumeBuilder {

    boolean supportsFileType(String fileType);

    Resume build(ResumeRequest resumeRequest);
}
