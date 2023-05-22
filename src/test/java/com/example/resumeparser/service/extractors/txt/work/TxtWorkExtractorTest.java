package com.example.resumeparser.service.extractors.txt.work;

import com.example.resumeparser.entity.Work;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class TxtWorkExtractorTest {

    private static final String COMPANY_NAME = "Atimi Software";
    private static final String YEARS_ATTENDED = "2022-2023";
    private static final String JOB_DESCRIPTION = """
            Worked as a contractor for an Agile team within Audible.\r
            Worked as Full Stack developer working on fixing issues with various aspects of the User\r
            Library and User Reviews modules.\r
            Became familiar and comfortable with a variety of proprietary front-end tools/frameworks\r
            used at Amazon.\r
            Worked with Amazon Code Pipelines to build and deploy code.\r
            Worked on improving the health of code pipelines by improving Integration Test coverage\r
            at different stages of the pipelines using the internal services and tools owned by Amazon.\r
            Gained an understanding of how services/responsibilities are distributed across Audible’s\r
            microservices-based architecture.\r
            Worked with the team to get changes through the code pipelines via code reviews and\r
            change management tools.""";

    private static final String WORK_EXPERIENCE_FORMAT_1 = COMPANY_NAME + ", " + YEARS_ATTENDED + "\r\n" +
            "Responsibilities:\r\n" + JOB_DESCRIPTION;

    private final TxtWorkExtractor txtWorkExtractor = new TxtWorkExtractor();

    @Test
    public void given_work_content_in_txt_format__when_extract__then_return_work_experience() {

        Work work = txtWorkExtractor.extract(WORK_EXPERIENCE_FORMAT_1);

        assertThat(work, is(notNullValue()));
        assertThat(work.getCompany(), is(COMPANY_NAME));
        assertThat(work.getYearsAttended(), is(YEARS_ATTENDED));
        assertThat(work.getJobDescription(), is(JOB_DESCRIPTION));
    }

}