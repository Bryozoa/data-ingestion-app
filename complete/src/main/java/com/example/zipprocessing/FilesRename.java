package complete.src.main.java.com.example.zipprocessing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FilesRename {

    public void rename() throws IOException {
        // Path of folder where files are located
        String target = Paths.get("src/main/resources/").toString();

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
                String new_file_name = tokens[1];
                System.out.println(long_file_name);
                System.out.print(new_file_name);

                myfile.renameTo(new File(i + ".csv"));
            }
        }
    }
}
