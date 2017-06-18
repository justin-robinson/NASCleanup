package pw.jor.ops;

import java.nio.file.Path;
import java.util.Comparator;

class PathComparator implements Comparator<Path> {

    @Override
    public int compare(Path a, Path b) {
        return Integer.compare(a.toString().length(), b.toString().length());
    }
}
