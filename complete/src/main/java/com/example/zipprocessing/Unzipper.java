package complete.src.main.java.com.example.zipprocessing;

import net.lingala.zip4j.ZipFile;

import java.io.IOException;
import java.nio.file.Path;

public class Unzipper {
    public static void unzipFolderZip4j(Path source, Path target)
            throws IOException {

        new ZipFile(source.toFile()).extractAll(target.toString());

    }
}
