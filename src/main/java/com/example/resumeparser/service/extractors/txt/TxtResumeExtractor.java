package com.example.resumeparser.service.extractors.txt;

import com.example.resumeparser.entity.Education;
import com.example.resumeparser.entity.Resume;
import com.example.resumeparser.entity.Work;
import com.example.resumeparser.service.extractors.Extractor;

import java.util.List;

public class TxtResumeExtractor implements Extractor<Resume, String> {


    public static final String EDUCATION_SECTION_TITLE = "Education:";
    public static final String WORK_SECTION_TITLE = "Work Experience:";

    private final Extractor<List<Work>, String> workListExtractor;
    private final Extractor<List<Education>, String> educationListExtractor;

    public TxtResumeExtractor(Extractor<List<Work>, String> txtWorkRecordsExtractor, Extractor<List<Education>, String> txtEducationListExtractor) {
        this.workListExtractor = txtWorkRecordsExtractor;
        this.educationListExtractor = txtEducationListExtractor;
    }

    @Override
    public Resume extract(String resumeContent) {

        final String contentAfterEducationTitle = resumeContent.split(EDUCATION_SECTION_TITLE)[1];
        final String educationContent = contentAfterEducationTitle.split(WORK_SECTION_TITLE)[0].trim();
        final List<Education> educationExperiences = educationListExtractor.extract(educationContent);


        final String contentAfterWorkTitle = resumeContent.split(WORK_SECTION_TITLE)[1];
        final String workContent = contentAfterWorkTitle.split(EDUCATION_SECTION_TITLE)[0].trim();
        final List<Work> workExperiences = workListExtractor.extract(workContent);

        return new Resume(educationExperiences, workExperiences);
    }
}
