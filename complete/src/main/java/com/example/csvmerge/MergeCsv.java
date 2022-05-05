package complete.src.main.java.com.example.csvmerge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeCsv {

    public static void createOneCsv(String target) throws IOException {

        File myfolder = new File(target,"MergedSCV.csv");

        File folder =new File(target);

        File[] file_array = folder.listFiles();
//for(File file:file_array) {
//    System.out.println(file.getName());
//}

        File csv1 = new File(target+"\\" + "0.csv");

        List<String> csv1Headers = CsvParser.getHeadersFromACsv(csv1);
        for (String csv1Header : csv1Headers) {
            System.out.print(csv1Header + " ");
        }
//        // System.out.println();
       List<String> csv2Headers = CsvParser.getHeadersFromACsv(csv1);
//         csv2Headers.forEach(h -> System.out.print(h + " "));
//        // System.out.println();

//        List<String> allCsvHeaders = new ArrayList<>();
//        allCsvHeaders.addAll(csv1Headers);
////        allCsvHeaders.addAll(csv2Headers);
//         allCsvHeaders.forEach(h -> System.out.print(h + " "));
        // System.out.println();

       Set<String> uniqueHeaders = new HashSet<>(csv1Headers);
    //    uniqueHeaders.forEach(h -> System.out.print(h + " "));
//        // System.out.println();


    //    List<CsvVo> csv2Records = CsvParser.getRecodrsFromACsv(csv2, csv2Headers);


        List<CsvVo> allCsvRecords = new ArrayList<>();
        for (File file: file_array) {

            List<CsvVo> csv1Records = CsvParser.getRecodrsFromACsv(file, csv1Headers);
            allCsvRecords.addAll(csv1Records);
        }

     //   allCsvRecords.addAll(csv2Records);

        CsvParser.writeToCsv(myfolder, uniqueHeaders, allCsvRecords);

        for(File file: file_array)
            if (!file.isDirectory() && !file.getName().equals("schema-all.sql")){

                file.delete();
            }
    }
}
