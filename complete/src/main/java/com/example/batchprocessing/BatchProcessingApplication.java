package complete.src.main.java.com.example.batchprocessing;

import complete.src.main.java.com.example.csvmerge.MergeCsv;
import complete.src.main.java.com.example.zipprocessing.FilesRename;
import complete.src.main.java.com.example.zipprocessing.Unzipper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

			MergeCsv.createOneCsv(target.toString());
			System.out.println("One CSV created");

		} catch (IOException e) {
			e.printStackTrace();
		}



		System.exit(SpringApplication.exit(SpringApplication.run(BatchProcessingApplication.class, args)));
	}
}
