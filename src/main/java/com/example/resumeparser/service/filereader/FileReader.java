package com.example.resumeparser.service.filereader;

import org.springframework.core.io.Resource;

public interface FileReader {

    String readFile(Resource resource);
}
