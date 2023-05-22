package com.example.resumeparser.service.extractors.txt.education;

import com.example.resumeparser.entity.Education;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TxtEducationRecordsExtractorTest {

    private static final String EDUCATION_RECORD_1 = "SAMPLE EDUCATION RECORD 1";
    private static final String EDUCATION_RECORD_2 = "SAMPLE EDUCATION RECORD 2";
    private static final String EDUCATION_RECORD_3 = "SAMPLE EDUCATION RECORD 3";
    private static final String EDUCATION_CONTENT = EDUCATION_RECORD_1 + "\r\n" +
            EDUCATION_RECORD_2 + "\r\n" +
            EDUCATION_RECORD_3;

    @Mock
    private TxtEducationExtractor txtEducationExtractor;

    @InjectMocks
    private TxtEducationRecordsExtractor txtEducationRecordsExtractor;

    @Test
    void given_multiple_work_records_separated_by_an_empty_line__when_extract__then_call_extractor_for_each_work_record() {

        final Education work1 = mock(Education.class);
        final Education work2 = mock(Education.class);
        final Education work3 = mock(Education.class);

        when(txtEducationExtractor.extract(EDUCATION_RECORD_1)).thenReturn(work1);
        when(txtEducationExtractor.extract(EDUCATION_RECORD_2)).thenReturn(work2);
        when(txtEducationExtractor.extract(EDUCATION_RECORD_3)).thenReturn(work3);

        List<Education> workList = txtEducationRecordsExtractor.extract(EDUCATION_CONTENT);

        assertThat(workList, is(notNullValue()));
        assertThat(workList, hasItems(work1, work2, work3));
    }
}