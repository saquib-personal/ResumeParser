package com.example.resumeparser.exceptions;

public class FileTypeNotSupportedException extends RuntimeException {

    public FileTypeNotSupportedException(String fileType) {

        super("Unsupported file type:" + fileType);
    }
}
