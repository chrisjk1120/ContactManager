package se.lexicon;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.StandardOpenOption;


public class Storage {
    String filename ="";
    List<String> lines = new ArrayList<>();
    public Storage(String file) {
        this.file = file;

    }

    public void readFile() throws IOException {
        List<String> lines = Files.readAllLines(Path.of(this.filename));
        this.lines.addAll(lines);
    }
    public void addLine(String line){

    }

    public void flush(List<String> csvLines)
    {
        Files.write(
                Path.of(this.filename),
                lines,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }
}
