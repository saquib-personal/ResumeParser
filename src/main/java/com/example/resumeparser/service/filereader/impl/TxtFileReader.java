package com.example.resumeparser.service.filereader.impl;

import com.example.resumeparser.exceptions.FileReadException;
import com.example.resumeparser.service.filereader.FileReader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TxtFileReader implements FileReader {

    public static final Charset UTF8_CHAR_SET = StandardCharsets.UTF_8;

    @Override
    public String readFile(Resource resource) {

        if (resource.exists() && resource.isOpen() && resource.isReadable()) {

            try {

                return resource.getContentAsString(UTF8_CHAR_SET);

            } catch (IOException e) {

                throw new FileReadException(resource.getFilename());
            }
        } else {

            throw new FileReadException(resource.getFilename());
        }
    }
}
