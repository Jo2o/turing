package functional;

import java.io.File;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.SneakyThrows;

public class FileLambdas {

    @SneakyThrows
    public static void main(String[] args) {

        /* List files in dir. */
        Files.list(Paths.get("."))
                .forEach(System.out::println);

        System.out.println();

        /* List dirs. */
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);

        System.out.println();

        /* List java files. */
        Files.newDirectoryStream(
                    Paths.get("src/functional"),
                    path -> path.toString().endsWith(".java")) // toString has to be here
                .forEach(System.out::println);

        System.out.println();

        /* List hidden files in the current directory. */
        Arrays.stream(
                Objects.requireNonNull(
                        new File(".")
                                .listFiles(File::isHidden)))
                .map(File::getAbsolutePath)
                .forEach(System.out::println);

        System.out.println();

        /* Immediate subdirs using flatmap */
        Stream.of(new File(".").listFiles())
                .flatMap(file -> (file.listFiles() == null) ? Stream.of(file) : Stream.of(file.listFiles())) // trick to make stream even from one item
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        /* Watch for file change. */
        Path path = Paths.get(".");
        WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        System.out.println("Watching...");
        WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
        if (watchKey != null) {
            watchKey.pollEvents()
                .forEach(action -> System.out.println(action.context()));
        }
    }
}
