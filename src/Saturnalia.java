import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Task-1
 * @author Juhi Gaba
 */
public class Saturnalia {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * Entry point of code.
     * @param args Input.
     */
    public static void main(String[] args) {

        String writeFilePath = args[1];

        try {

            String filePath = args[0];
            String lines[] = readFile(filePath).split("\\r?\\n");

            int numberOfLines = Integer.parseInt(lines[0]);

            StringBuilder outputBuilder = new StringBuilder();

            IntStream.range(1,numberOfLines+1).forEach(i-> {

                outputBuilder.append("Case #")
                        .append(i)
                        .append(":")
                        .append("\n");

                appendBox(lines[i], outputBuilder);

            });

            writeFile(writeFilePath, outputBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the box around every line.
     *
     * @param line          A string representing the line.
     * @param output String builder instance.
     */
    private static void appendBox(String line, StringBuilder output) {

        StringBuilder boxBuilder = new StringBuilder();

        generateBoxBorder(line, boxBuilder);

        boxBuilder.append("| ")
                .append(line)
                .append(" |");
        boxBuilder.append(LINE_SEPARATOR);

        generateBoxBorder(line, boxBuilder);

        output.append(boxBuilder);
    }

    /**
     * Generate the border for the box.
     *
     * @param line       Line for which the border has to be generated
     * @param boxBuilder Instance of builder.
     */
    private static void generateBoxBorder(String line, StringBuilder boxBuilder) {

        int borderLength = line.length() + 2;

        boxBuilder.append("+");

        IntStream.range(0,borderLength)
                .forEach(i-> boxBuilder.append("-"));

        boxBuilder.append("+");
        boxBuilder.append(LINE_SEPARATOR);
    }

    /**
     * Read the file.
     *
     * @param filePath      The path of the file to read.
     * @return              String representing the content inside the file.
     * @throws IOException  Thrown when the file can not be read.
     */
    private static String readFile(String filePath) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        Path inputFilePath = Paths.get(filePath);

        try (Stream<String> stream = Files.lines(inputFilePath)) {

            stream.forEach(line->
                    stringBuilder.append(line)
                                .append(LINE_SEPARATOR)
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    /**
     * Write into a file
     *
     * @param writeFilePath The path of the file to write.
     */
    private static void writeFile(String writeFilePath, String data) {

        try {

            Files.write(
                    Paths.get(writeFilePath),
                    data.getBytes()
            );

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
