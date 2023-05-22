package com.example.resumeparser.service.builder.impl;

import com.example.resumeparser.controllers.ResumeRequest;
import com.example.resumeparser.entity.Resume;
import com.example.resumeparser.exceptions.ContentParsingFailedException;
import com.example.resumeparser.exceptions.FileReadException;
import com.example.resumeparser.service.builder.ResumeBuilder;
import com.example.resumeparser.service.extractors.Extractor;
import com.example.resumeparser.service.filereader.FileReader;
import com.example.resumeparser.service.filereader.impl.TxtFileReader;
import org.springframework.core.io.Resource;

public class TxtResumeBuilder implements ResumeBuilder {

    public static final String SUPPORTED_FILE_EXTENSION = "txt";

    private final FileReader txtFileReader;
    private final Extractor<Resume, String> txtResumeExtractor;

    public TxtResumeBuilder(TxtFileReader txtFileReader, Extractor<Resume, String> txtResumeExtractor) {
        this.txtFileReader = txtFileReader;
        this.txtResumeExtractor = txtResumeExtractor;
    }

    @Override
    public boolean supportsFileType(String fileType) {

        return SUPPORTED_FILE_EXTENSION.equalsIgnoreCase(fileType);
    }

    @Override
    public Resume build(ResumeRequest resumeRequest) {

        try {

            return this.tryBuild(resumeRequest);

        } catch (FileReadException fileReadException) {

            throw fileReadException;

        } catch (Exception exception) {

            throw new ContentParsingFailedException(exception);
        }

    }

    private Resume tryBuild(ResumeRequest resumeRequest) {

        final Resource resumeFile = resumeRequest.getResource();

        final String resumeContent = txtFileReader.readFile(resumeFile);

        return txtResumeExtractor.extract(resumeContent);
    }
}
