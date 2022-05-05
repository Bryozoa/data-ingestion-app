package complete.src.main.java.com.example.zipprocessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzipper {

    public static void unzipFolder(Path source, Path target) throws IOException {

        //searching .zip file in the directory
        File searchFile = new File(String.valueOf(target));
        File[] findZipFile = searchFile.listFiles((dir, name) -> name.endsWith(".zip"));

        for (File file : findZipFile) {
            String path = file.getPath();

            try (ZipInputStream zis = new ZipInputStream(new FileInputStream(path))) {

                // list files in zip
                ZipEntry zipEntry = zis.getNextEntry();

                while (zipEntry != null) {

                    boolean isDirectory = false;
                    if (zipEntry.getName().endsWith(File.separator)) {
                        isDirectory = true;
                    }

                    Path newPath = zipSlipProtect(zipEntry, target);

                    if (isDirectory) {
                        Files.createDirectories(newPath);
                    } else {
                        if (newPath.getParent() != null) {
                            if (Files.notExists(newPath.getParent())) {
                                Files.createDirectories(newPath.getParent());
                            }
                        }

                        // copy files, nio
                        System.out.println("copy files, nio");
                        Files.copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);

                    }

                    zipEntry = zis.getNextEntry();
//TODO rename all files to 1, 2, 3 etc
                }
                zis.closeEntry();

            }
        }

    }

    // protect zip slip attack
    public static Path zipSlipProtect(ZipEntry zipEntry, Path targetDir)
            throws IOException {

        // test zip slip vulnerability
        // Path targetDirResolved = targetDir.resolve("../../" + zipEntry.getName());

        Path targetDirResolved = targetDir.resolve(zipEntry.getName());

        // make sure normalized file still has targetDir as its prefix
        // else throws exception
        Path normalizePath = targetDirResolved.normalize();
        if (!normalizePath.startsWith(targetDir)) {
            throw new IOException("Bad zip entry: " + zipEntry.getName());
        }

        return normalizePath;
    }

}