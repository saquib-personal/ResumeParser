package com.example.resumeparser.controllers;

import com.example.resumeparser.entity.Resume;
import com.example.resumeparser.exceptions.FileReadException;
import com.example.resumeparser.exceptions.FileTypeNotSupportedException;
import com.example.resumeparser.service.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ResumeController {

    private final ResumeServiceImpl resumeServiceImpl;

    @Autowired
    public ResumeController(ResumeServiceImpl resumeServiceImpl) {

        this.resumeServiceImpl = resumeServiceImpl;
    }

    @PostMapping("/resume")
    public Resume uploadResume(@RequestParam(value = "file") MultipartFile multipartFile) {

        final String fileType = this.getFileType(multipartFile.getOriginalFilename());

        final ResumeRequest resumeRequest = new ResumeRequest(fileType, multipartFile.getResource());

        return resumeServiceImpl.extractResume(resumeRequest);
    }

    private String getFileType(String fileName) {

        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @ExceptionHandler(FileTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleFileTypeNotSupportedException(FileTypeNotSupportedException exception) {

        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), exception.getClass().getName(), exception.getMessage()));
    }

    @ExceptionHandler(FileReadException.class)
    public ResponseEntity<ErrorResponse> handleFileReadException(FileReadException exception) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getClass().getName(), exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedException(Exception exception) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getClass().getName(), exception.getMessage()));
    }
}
