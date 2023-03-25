package com.besedo.utils;

import com.besedo.model.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvUtilsTest {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String CSV_SEPARATOR = ",";

    @Test
    void correctVowelCountTest() {

        // GIVEN
        List<Data> dataList = new ArrayList<>();
        Data row1 = createTestData("1", "aido");
        Data row2 = createTestData("2", "aieooou BLUE");
        dataList.add(row1);
        dataList.add(row2);

        // WHEN
        String result = CsvUtils.convertToCSV(dataList);
        String[] rows = result.split(NEW_LINE);

        String vowelCountFirstRow = rows[1].split(CSV_SEPARATOR)[1];
        String vowelCountSecondRow = rows[2].split(CSV_SEPARATOR)[1];

        // MATCH
        assertEquals(3, rows.length);
        assertEquals("3", vowelCountFirstRow);
        assertEquals("9", vowelCountSecondRow);
    }

    @Test
    void correctVowelCountTestForEmptyBody() {
        // GIVEN
        List<Data> dataList = new ArrayList<>();
        Data row1 = createTestData("1", "");
        dataList.add(row1);

        // WHEN
        String result = CsvUtils.convertToCSV(dataList);
        String[] rows = result.split(NEW_LINE);

        String vowelCountFirstRow = rows[1].split(CSV_SEPARATOR)[1];

        // MATCH
        assertEquals(2, rows.length);
        assertEquals("0", vowelCountFirstRow);
    }

    @Test
    void correctVowelCountTestForNoVowel() {

        // GIVEN
        List<Data> dataList = new ArrayList<>();
        Data row1 = createTestData("1", "fly");
        dataList.add(row1);

        // WHEN
        String result = CsvUtils.convertToCSV(dataList);
        String[] rows = result.split(NEW_LINE);

        String vowelCountFirstRow = rows[1].split(CSV_SEPARATOR)[1];

        // MATCH
        assertEquals(2, rows.length);
        assertEquals("0", vowelCountFirstRow);
    }


    private static Data createTestData(String id, String body) {
        Data data = new Data();
        data.setId(id);
        data.setBody(body);
        return data;
    }
}
