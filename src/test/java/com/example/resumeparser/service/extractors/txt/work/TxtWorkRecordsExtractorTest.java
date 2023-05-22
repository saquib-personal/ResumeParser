package com.example.resumeparser.service.extractors.txt.work;

import com.example.resumeparser.entity.Work;
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
class TxtWorkRecordsExtractorTest {

    private static final String WORK_RECORD_1 = "SAMPLE WORK RECORD 1";
    private static final String WORK_RECORD_2 = "SAMPLE WORK RECORD 2";
    private static final String WORK_RECORD_3 = "SAMPLE WORK RECORD 3";
    private static final String WORK_CONTENT = WORK_RECORD_1 + "\r\n" +
            "\r\n" +
            WORK_RECORD_2 + "\r\n" +
            "\r\n" +
            WORK_RECORD_3;

    @Mock
    private TxtWorkExtractor txtWorkExtractor;

    @InjectMocks
    private TxtWorkRecordsExtractor txtWorkRecordsExtractor;

    @Test
    void given_multiple_work_records_separated_by_an_empty_line__when_extract__then_call_extractor_for_each_work_record() {

        final Work work1 = mock(Work.class);
        final Work work2 = mock(Work.class);
        final Work work3 = mock(Work.class);

        when(txtWorkExtractor.extract(WORK_RECORD_1)).thenReturn(work1);
        when(txtWorkExtractor.extract(WORK_RECORD_2)).thenReturn(work2);
        when(txtWorkExtractor.extract(WORK_RECORD_3)).thenReturn(work3);

        List<Work> workList = txtWorkRecordsExtractor.extract(WORK_CONTENT);

        assertThat(workList, is(notNullValue()));
        assertThat(workList, hasItems(work1, work2, work3));
    }
}