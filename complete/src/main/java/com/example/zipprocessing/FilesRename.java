package complete.src.main.java.com.example.zipprocessing;

import java.io.File;
import java.io.IOException;

public class FilesRename {

    public static void rename(String target) throws IOException {

        File myfolder = new File(target);

        File[] file_array = myfolder.listFiles();
            for (int i = 0; i < file_array.length; i++) {
                System.out.println("file name: " + file_array[i].getName());

                if (file_array[i].isFile() && !file_array[i].getName().equals("schema-all.sql") &&
                        !file_array[i].getName().equals("data.zip")) {

                    File myfile = new File( target +"\\"+ file_array[i].getName());
                    myfile.renameTo(new File(target + "\\" + i + ".csv"));
                }
            }

    }
}
