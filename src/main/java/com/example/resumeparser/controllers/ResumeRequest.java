package com.example.resumeparser.controllers;

import org.springframework.core.io.Resource;

public class ResumeRequest {

    private final String fileType;
    private final Resource resource;

    public ResumeRequest(String fileType, Resource resource) {

        this.fileType = fileType;
        this.resource = resource;
    }

    public String getFileType() {
        return fileType;
    }

    public Resource getResource() {
        return resource;
    }
}
