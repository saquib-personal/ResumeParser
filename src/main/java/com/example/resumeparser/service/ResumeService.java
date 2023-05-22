package com.example.resumeparser.service;

import com.example.resumeparser.controllers.ResumeRequest;
import com.example.resumeparser.entity.Resume;

public interface ResumeService {
    Resume extractResume(ResumeRequest resumeRequest);
}
