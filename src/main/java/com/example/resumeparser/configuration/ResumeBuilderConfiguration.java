package com.example.resumeparser.configuration;

import com.example.resumeparser.service.builder.ResumeBuilder;
import com.example.resumeparser.service.builder.impl.TxtResumeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ResumeBuilderConfiguration {

    @Bean("resumeBuilders")
    public List<ResumeBuilder> getResumeBuilders(TxtResumeBuilder txtResumeBuilder) {

        List<ResumeBuilder> resumeBuilderList = new ArrayList<>();
        resumeBuilderList.add(txtResumeBuilder);
        return resumeBuilderList;
    }
}
