package com.example.resumeparser.exceptions;

public class FileReadException extends RuntimeException {

    public FileReadException(String fileName) {

        super("Could not read from file:" + fileName);
    }
}
