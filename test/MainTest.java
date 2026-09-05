import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream capturedOut;
    private Path tempDir;

    @Before
    public void setUp() throws Exception {
        capturedOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOut, true, StandardCharsets.UTF_8));
        tempDir = Files.createTempDirectory("fileio-tests");
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
        if (tempDir != null) {
            Files.walk(tempDir)
                    .sorted((a, b) -> b.compareTo(a))
                    .forEach(path -> {
                        try {
                            Files.deleteIfExists(path);
                        } catch (Exception ignored) {
                        }
                    });
        }
    }

    @Test
    public void readFile_readsSampleCsv() {
        ArrayList<WeatherData> data = Main.ReadFile("testresources/sample-weather.csv");
        assertNotNull(data);
        assertEquals(3, data.size());
        assertEquals("Seattle Wash.", data.get(0).getCity());
        assertEquals(50.2, data.get(0).getAverageTemp(), 0.0001);
        assertEquals(37.07, data.get(0).getAverageHumidity(), 0.0001);
        assertEquals("Miami Fla.", data.get(1).getCity());
        assertEquals("Anchorage Alaska", data.get(2).getCity());
    }

    @Test
    public void readFile_missingFile_returnsEmptyList() {
        ArrayList<WeatherData> data = Main.ReadFile(tempDir.resolve("does-not-exist.csv").toString());
        assertNotNull(data);
        assertTrue(data.isEmpty());
    }

    @Test
    public void sortWeatherData_hottestToColdest() {
        ArrayList<WeatherData> data = new ArrayList<>(Arrays.asList(
                new WeatherData("Seattle Wash.", 50.2, 37.07),
                new WeatherData("Miami Fla.", 75.7, 58.53),
                new WeatherData("Anchorage Alaska", 36.3, 16.08)
        ));

        Main.SortWeatherData(data);

        assertEquals("Miami Fla.", data.get(0).getCity());
        assertEquals("Seattle Wash.", data.get(1).getCity());
        assertEquals("Anchorage Alaska", data.get(2).getCity());
    }

    @Test
    public void writeFile_overwritesExistingContents() throws Exception {
        Path out = tempDir.resolve("out.csv");
        Files.writeString(out, "old line that should disappear\n");

        ArrayList<WeatherData> data = new ArrayList<>(List.of(
                new WeatherData("Seattle Wash.", 50.2, 37.07),
                new WeatherData("Miami Fla.", 75.7, 58.53)
        ));

        Main.WriteFile(out.toString(), false, data);

        List<String> lines = Files.readAllLines(out);
        assertEquals(2, lines.size());
        assertEquals("Seattle Wash., 50.2, 37.07", lines.get(0));
        assertEquals("Miami Fla., 75.7, 58.53", lines.get(1));
    }

    @Test
    public void writeFile_appendsToExistingContents() throws Exception {
        Path out = tempDir.resolve("append.csv");
        Files.writeString(out, "existing city,1.0,2.0\n");

        ArrayList<WeatherData> data = new ArrayList<>(List.of(
                new WeatherData("Seattle Wash.", 50.2, 37.07)
        ));

        Main.WriteFile(out.toString(), true, data);

        List<String> lines = Files.readAllLines(out);
        assertEquals(2, lines.size());
        assertEquals("existing city,1.0,2.0", lines.get(0));
        assertEquals("Seattle Wash., 50.2, 37.07", lines.get(1));
    }

    @Test
    public void printWeatherData_printsOneCityPerLine() {
        ArrayList<WeatherData> data = new ArrayList<>(Arrays.asList(
                new WeatherData("Seattle Wash.", 50.2, 37.07),
                new WeatherData("Miami Fla.", 75.7, 58.53)
        ));

        Main.PrintWeatherData(data);

        String[] lines = capturedOut.toString(StandardCharsets.UTF_8).trim().split("\\R");
        assertEquals(2, lines.length);
        assertEquals("Seattle Wash., 50.2, 37.07", lines[0].trim());
        assertEquals("Miami Fla., 75.7, 58.53", lines[1].trim());
    }
}
