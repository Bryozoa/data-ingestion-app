package complete.src.main.java.com.example.csvmerge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeCsv {

    public static void createOneCsv(String target) throws IOException {


        // creating new folder
        File myfolder = new File(target);

        File[] file_array = myfolder.listFiles();
        for (int i = 0; i < file_array.length; i++)
        {
            File csv = new File(target+"\\" + i + ".csv");
            List<String> csvHeaders = CsvParser.getHeadersFromACsv(csv);

            List<String> allCsvHeaders = new ArrayList<>();
            allCsvHeaders.addAll(csvHeaders);

            Set<String> uniqueHeaders = new HashSet<>(allCsvHeaders);

            List<CsvVo> csvRecords = CsvParser.getRecodrsFromACsv(csv, csvHeaders);

            List<CsvVo> allCsvRecords = new ArrayList<>();
            allCsvRecords.addAll(csvRecords);

            CsvParser.writeToCsv(new File(target), uniqueHeaders, allCsvRecords);
        }

    }
}
