package com.example.resumeparser.service.extractors;

public interface Extractor<TObject, TContent> {

    TObject extract(TContent tContent);
}
