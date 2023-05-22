package com.example.resumeparser.service.extractors.txt;

import com.example.resumeparser.entity.Education;
import com.example.resumeparser.entity.Resume;
import com.example.resumeparser.entity.Work;
import com.example.resumeparser.service.extractors.Extractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TxtResumeExtractorTest {

    private static final String SAMPLE_EDUCATION_CONTENT = "Sample Education Content";
    private static final String SAMPLE_WORK_CONTENT = "Sample Work Content";

    private static final String RESUME_CONTENT_WITH_EDUCATION_FIRST = "Candidate Name and other Details\r\n" +
            TxtResumeExtractor.EDUCATION_SECTION_TITLE + " \r\n" +
            SAMPLE_EDUCATION_CONTENT + "\r\n" +
            TxtResumeExtractor.WORK_SECTION_TITLE + "\r\n" +
            SAMPLE_WORK_CONTENT;

    private static final String RESUME_CONTENT_WITH_WORK_FIRST = "Candidate Name and other Details\r\n" +
            TxtResumeExtractor.WORK_SECTION_TITLE + " \r\n" +
            SAMPLE_WORK_CONTENT + "\r\n" +
            TxtResumeExtractor.EDUCATION_SECTION_TITLE + "\r\n" +
            SAMPLE_EDUCATION_CONTENT;

    @Mock
    private Extractor<List<Work>, String> workListExtractor;

    @Mock
    private Extractor<List<Education>, String> educationListExtractor;

    private TxtResumeExtractor txtResumeExtractor;

    @BeforeEach
    public void setUp() {

        txtResumeExtractor = new TxtResumeExtractor(workListExtractor, educationListExtractor);
    }

    @Test
    public void given_resume_content_with_education_first__when_extract__then_return_resume() {

        List<Education> educationExperiences = mock(List.class);
        List<Work> workExperiences = mock(List.class);

        when(educationListExtractor.extract(SAMPLE_EDUCATION_CONTENT)).thenReturn(educationExperiences);
        when(workListExtractor.extract(SAMPLE_WORK_CONTENT)).thenReturn(workExperiences);

        Resume resume = txtResumeExtractor.extract(RESUME_CONTENT_WITH_EDUCATION_FIRST);

        assertThat(resume, is(notNullValue()));
        assertThat(resume.getWork(), is(workExperiences));
        assertThat(resume.getEducation(), is(educationExperiences));

        verify(workListExtractor, times(1)).extract(SAMPLE_WORK_CONTENT);
        verify(educationListExtractor, times(1)).extract(SAMPLE_EDUCATION_CONTENT);
    }

    @Test
    public void given_resume_content_with_work_first__when_extract__then_return_resume() {

        List<Education> educationExperiences = mock(List.class);
        List<Work> workExperiences = mock(List.class);

        when(educationListExtractor.extract(SAMPLE_EDUCATION_CONTENT)).thenReturn(educationExperiences);
        when(workListExtractor.extract(SAMPLE_WORK_CONTENT)).thenReturn(workExperiences);

        Resume resume = txtResumeExtractor.extract(RESUME_CONTENT_WITH_WORK_FIRST);

        assertThat(resume, is(notNullValue()));
        assertThat(resume.getWork(), is(workExperiences));
        assertThat(resume.getEducation(), is(educationExperiences));

        verify(workListExtractor, times(1)).extract(SAMPLE_WORK_CONTENT);
        verify(educationListExtractor, times(1)).extract(SAMPLE_EDUCATION_CONTENT);
    }

}