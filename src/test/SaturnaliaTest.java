package test;

import org.junit.Test;
import saturnalia.Saturnalia;

import java.io.IOException;

/**
 * @author Juhi Gaba
 */
public class SaturnaliaTest {

    @Test
    public void TestFormat() throws IOException {

        final String input = "4" + "\n" + "z" + "\n"
                + "WlabEwES.LGnsQduEcvsGwujieFFSxOHGMOcbk.ZTHmdpvEZvXsc" + "\n"
                + " " + "\n" + "TexC,vTTIfu GKCWZq?zi,BFX.D .brLlUgep ";
        final String expectedOutputFile = "/Users/juhi.gaba/Saturnalia/src/data/expectedOutput";

        String actualOutput = Saturnalia.processInput(input);

        String expectedOutput = Saturnalia.readFile(expectedOutputFile);
        assert expectedOutput.equals(actualOutput);
    }
}
