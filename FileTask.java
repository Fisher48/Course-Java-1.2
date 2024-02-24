import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileTask {

    public static List<Path> func (File path, String ext, boolean flag) {
        int N = 1;
        if (flag) {
            N = 2;
        }
        List<Path> files = null;
        try {
            files = Files.walk(Paths.get(String.valueOf(path)), N)
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith(ext))
                    .collect(Collectors.toList());

        } catch (IOException | NullPointerException e) {
            System.err.println(e);
        }
        List<Path> dirs = null;
        try {
            dirs = Files.walk(Paths.get(String.valueOf(path)), N)
                    .parallel().filter(Files::isDirectory)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Path> list = new ArrayList<>();
        list.addAll(dirs);
        list.addAll(files);
        return list;
    }
    public static void main (String[]args) {
        File path = new File("D:\\Microsoft VS Code");
        String ext = ".exe";
        boolean flag = true;
        System.out.println(func(path,ext,flag));
    }
}