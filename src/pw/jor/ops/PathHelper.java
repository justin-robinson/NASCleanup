package pw.jor.ops;

import java.nio.file.Files;
import java.nio.file.Path;

class PathHelper {

    static boolean hasMoreThanOneFile(Path p){
        try {
            return Files.list(p).count() > 1;
        } catch (Exception e){
            return false;
        }
    }

    static void printShortestFileName(Path p){
        try{
            Files.list(p)
                    .min(new PathComparator())
                    .ifPresent(System.out::println);
        } catch(Exception e) {
            System.out.println("Error listing files in " + p);
        }
    }
}
