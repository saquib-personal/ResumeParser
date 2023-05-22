package com.example.resumeparser.service.extractors.txt.education;

import com.example.resumeparser.entity.Education;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

class TxtEducationExtractorTest {

    private static final String UNIVERSITY_NAME = "University of Dallas";
    private static final String YEARS_ATTENDED = "2013-2016";
    private static final String DEGREE_NAME = "Master of Science";
    private static final String EDUCATION_CONTENT = UNIVERSITY_NAME + ", " + YEARS_ATTENDED + ", " + DEGREE_NAME;

    private final TxtEducationExtractor txtEducationExtractor = new TxtEducationExtractor();

    @Test
    void given_education_content__when_extract__then_return_education() {

        Education education = txtEducationExtractor.extract(EDUCATION_CONTENT);

        assertThat(education, is(notNullValue()));
        assertThat(education.getDegree(), is(DEGREE_NAME));
        assertThat(education.getYearsAttended(), is(YEARS_ATTENDED));
        assertThat(education.getUniversity(), is(UNIVERSITY_NAME));
    }
}