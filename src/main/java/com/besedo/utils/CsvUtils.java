package com.besedo.utils;

import com.besedo.exception.CsvConvertorException;
import com.besedo.model.Data;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CsvUtils {

    private static final String CSV_SEPARATOR = ",";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String HEADER = "id,vowelscount";

    private static final Logger logger = LogManager.getLogger(CsvUtils.class);


    public static String convertToCSV(List<Data> dataList) {
        try {
            StringBuilder sb = new StringBuilder(HEADER);
            sb.append(NEW_LINE);
            for (Data data : dataList) {
                sb.append(data.getId());
                sb.append(CSV_SEPARATOR);
                sb.append(countVowels(data.getBody()));
                sb.append(NEW_LINE);
            }
            logger.debug("Converted csv data::"+sb.toString());
            return sb.toString();
        } catch (Exception e) {
            logger.error("Cant convert data to csv");
            throw new CsvConvertorException("Cant convert data to csv {}");
        }
    }

    private static int countVowels(String data) {
        data = data.toLowerCase();
        int count = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == 'a' || data.charAt(i) == 'e' || data.charAt(i) == 'i'
                    || data.charAt(i) == 'o' || data.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }

}
