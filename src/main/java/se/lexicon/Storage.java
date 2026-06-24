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
        this.filename = file;

    }

    public void readFile() throws IOException {
        List<String> lines = Files.readAllLines(Path.of(this.filename));
        this.lines.addAll(lines);
    }
    public void addLine(String line){

    }

    public void flush(List<String> csvLines)
    {
        try {
            Files.write(
                    Path.of(this.filename),
                    csvLines,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING // Very ugly way to handle things. But empty the file before writing the objects.
            );
        } catch(IOException e) {
            IO.println("I was not able to save to file: " + this.filename);
        }
    }
}
