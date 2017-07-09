package pw.jor.ops;


import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 */
class NasCleanup {

    private Path rootDirectory;

    /**
     *
     * @param rootDirectory Base folder to search
     *
     * @throws FileNotFoundException when directory isn't found
     * @throws FileAlreadyExistsException when directory isn't a directory
     */
    NasCleanup(Path rootDirectory) throws FileNotFoundException, FileAlreadyExistsException{
        if(!Files.exists(rootDirectory)) {
            throw new FileNotFoundException(rootDirectory.toString());
        }

        if(!Files.isDirectory(rootDirectory)) {
            throw new FileAlreadyExistsException(rootDirectory.toString());
        }

        this.rootDirectory = rootDirectory;
    }

    void cleanup() {
        getFilteredDirectories().get().forEach(PathHelper::printShortestFileName);
        getFilteredDirectories().get().forEach(PathHelper::printDirectoryWithoutShortestFileName);
    }

    private Supplier<Stream<Path>> getFilteredDirectories() {
        return  () -> {

            try {
                return Files.list(rootDirectory)
                        .filter(Files::isDirectory)
                        .filter(PathHelper::hasMoreThanOneFile);
            } catch (Exception e) {
                System.out.println("Error listing files in " + rootDirectory);
            }

            return null;
        };
    }
}