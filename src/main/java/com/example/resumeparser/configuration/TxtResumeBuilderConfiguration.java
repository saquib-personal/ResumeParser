package com.example.resumeparser.configuration;

import com.example.resumeparser.service.builder.impl.TxtResumeBuilder;
import com.example.resumeparser.service.extractors.txt.TxtResumeExtractor;
import com.example.resumeparser.service.extractors.txt.education.TxtEducationExtractor;
import com.example.resumeparser.service.extractors.txt.education.TxtEducationRecordsExtractor;
import com.example.resumeparser.service.extractors.txt.work.TxtWorkExtractor;
import com.example.resumeparser.service.extractors.txt.work.TxtWorkRecordsExtractor;
import com.example.resumeparser.service.filereader.impl.TxtFileReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TxtResumeBuilderConfiguration {

    @Bean
    public TxtResumeExtractor getTxtResumeExtractor() {

        final TxtWorkRecordsExtractor txtWorkRecordsExtractor = new TxtWorkRecordsExtractor(new TxtWorkExtractor());
        final TxtEducationRecordsExtractor txtEducationRecordsExtractor = new TxtEducationRecordsExtractor(new TxtEducationExtractor());
        return new TxtResumeExtractor(txtWorkRecordsExtractor, txtEducationRecordsExtractor);
    }

    @Bean
    public TxtResumeBuilder getTxtResumeBuilder(TxtResumeExtractor txtResumeExtractor) {

        return new TxtResumeBuilder(new TxtFileReader(), txtResumeExtractor);
    }
}
