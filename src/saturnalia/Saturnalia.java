package saturnalia;

import java.io.*;
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
     *
     * @param args Input.
     */
    public static void main(String[] args) {

        String writeFilePath = args[1];

        try {

            String filePath = args[0];
            String input = readFile(filePath);
            String output = processInput(input);

            writeFile(writeFilePath, output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Process Input
     * @param input Data to be processed.
     * @return      Processed data
     */
    public static String processInput(String input) {
        String lines[] = input.split("\\r?\\n");

        int numberOfLines = Integer.parseInt(lines[0]);

        StringBuilder outputBuilder = new StringBuilder();

        IntStream.range(1, numberOfLines + 1).forEach(i -> {

            outputBuilder.append("Case #").append(i).append(":").append("\n");

            appendBox(lines[i], outputBuilder);

        });
        return outputBuilder.toString();
    }

    /**
     * Prints the box around every line.
     *
     * @param line A string representing the line.
     * @param output String builder instance.
     */
    private static void appendBox(String line, StringBuilder output) {

        StringBuilder boxBuilder = new StringBuilder();

        generateBoxBorder(line, boxBuilder);

        boxBuilder.append("| ").append(line).append(" |");
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

        IntStream.range(0, borderLength).forEach(i -> boxBuilder.append("-"));

        boxBuilder.append("+");
        boxBuilder.append(LINE_SEPARATOR);
    }

    /**
     * Read the file.
     *
     * @param filePath      The path of the file to read.
     * @return              String representing the content inside the file.
     * @throws IOException Thrown when the file can not be read.
     */
    public static String readFile(String filePath) throws IOException {

        InputStream is = new FileInputStream(filePath);
        @SuppressWarnings("resource")
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(is, "UTF8"));

        String line = bufferedReader.readLine();

        StringBuilder builder = new StringBuilder();

        while (line != null) {
            builder.append(line).append("\n");
            line = bufferedReader.readLine();
        }

        return builder.toString();
    }

    /**
     * Write into a file
     *
     * @param writeFilePath The path of the file to write.
     */
    private static void writeFile(String writeFilePath, String data) {

        try {

            Files.write(Paths.get(writeFilePath), data.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
