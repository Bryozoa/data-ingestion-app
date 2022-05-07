package complete.src.main.java.com.example;

import complete.src.main.java.com.example.zipprocessing.FilesRename;
import complete.src.main.java.com.example.zipprocessing.Unzipper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class BatchProcessingApplication {

	public static void main(String[] args) throws Exception {

		Path source = Paths.get("src/main/resources/data.zip");
		Path target = Paths.get("src/main/resources/");

		try {

			Unzipper.unzipFolderZip4j(source, target);
			System.out.println("Files were unzipped");

			FilesRename.rename(target.toString());
			System.out.println("Files were renamed");

		} catch (IOException e) {
			e.printStackTrace();
		}

		SpringApplication.run(BatchProcessingApplication.class, args);

		for (int i = 0; i < new File("src\\main\\resources").listFiles().length - 2; i++) {
			File myObj = new File(source.toString() + i + ".csv");
			if (myObj.delete()) {
				System.out.println("Deleted the file: " + myObj.getName());
			} else {
				System.out.println("Failed to delete the file.");
			}
		}

		System.exit(SpringApplication.exit(SpringApplication.run(BatchProcessingApplication.class, args)));
	}
}
