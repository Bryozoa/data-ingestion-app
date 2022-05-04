package complete.src.main.java.com.example.batchprocessing;

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

			Unzipper.unzipFolder(source, target);
			System.out.println("Files were unzipped");

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.exit(SpringApplication.exit(SpringApplication.run(BatchProcessingApplication.class, args)));
	}
}
