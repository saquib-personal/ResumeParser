package com.example.resumeparser.exceptions;

public class ContentParsingFailedException extends RuntimeException {

    public ContentParsingFailedException(Throwable throwable) {

        super(throwable);
    }
}
