package complete.src.main.java.com.example.zipprocessing;

import java.io.File;
import java.io.IOException;

public class FilesRename {

    public static void rename(String target) throws IOException {

        // creating new folder
        File myfolder = new File(target);

        File[] file_array = myfolder.listFiles();
        for (int i = 0; i < file_array.length; i++)
        {

            if (file_array[i].isFile())
            {

                File myfile = new File(target +
                        "\\" + file_array[i].getName());
                String long_file_name = file_array[i].getName();
                String[] tokens = long_file_name.split("\\s");
                String new_file_name = tokens[0];
                System.out.println(long_file_name);
                System.out.print(new_file_name);

                myfile.renameTo(new File(target+"\\" + i + ".csv"));
            }
        }
    }
}
