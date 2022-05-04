package complete.src.main.java.com.example.csvmerge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeCsv {

    public void createOneCsv() throws IOException {

        //TODO for statement to parse all files from directory
        File csv1 = new File("src/main/resources/");
        File csv2 = new File("src/main/resources/");

        List<String> csv1Headers = CsvParser.getHeadersFromACsv(csv1);
        // csv1Headers.forEach(h -> System.out.print(h + " "));
        // System.out.println();
        List<String> csv2Headers = CsvParser.getHeadersFromACsv(csv2);
        // csv2Headers.forEach(h -> System.out.print(h + " "));
        // System.out.println();

        List<String> allCsvHeaders = new ArrayList<>();
        allCsvHeaders.addAll(csv1Headers);
        allCsvHeaders.addAll(csv2Headers);
        // allCsvHeaders.forEach(h -> System.out.print(h + " "));
        // System.out.println();

        Set<String> uniqueHeaders = new HashSet<>(allCsvHeaders);
        // uniqueHeaders.forEach(h -> System.out.print(h + " "));
        // System.out.println();

        List<CsvVo> csv1Records = CsvParser.getRecodrsFromACsv(csv1, csv1Headers);
        List<CsvVo> csv2Records = CsvParser.getRecodrsFromACsv(csv2, csv2Headers);

        List<CsvVo> allCsvRecords = new ArrayList<>();
        allCsvRecords.addAll(csv1Records);
        allCsvRecords.addAll(csv2Records);

        CsvParser.writeToCsv(new File("C:/csv/csv.csv"), uniqueHeaders, allCsvRecords);
    }
}
