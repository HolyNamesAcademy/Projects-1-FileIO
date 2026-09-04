import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherDataTest {
    @Test
    public void toString_formatsCityTempHumidity() {
        WeatherData data = new WeatherData("Seattle Wash.", 50.2, 37.07);
        assertEquals("Seattle Wash., 50.2, 37.07", data.toString());
    }

    @Test
    public void compareTo_hotterThanOther_returnsPositive() {
        WeatherData hot = new WeatherData("Miami Fla.", 75.7, 58.53);
        WeatherData cold = new WeatherData("Anchorage Alaska", 36.3, 16.08);
        assertTrue(hot.compareTo(cold) > 0);
    }

    @Test
    public void compareTo_colderThanOther_returnsNegative() {
        WeatherData hot = new WeatherData("Miami Fla.", 75.7, 58.53);
        WeatherData cold = new WeatherData("Anchorage Alaska", 36.3, 16.08);
        assertTrue(cold.compareTo(hot) < 0);
    }

    @Test
    public void compareTo_sameTemperature_returnsZero() {
        WeatherData a = new WeatherData("City A", 50.0, 10.0);
        WeatherData b = new WeatherData("City B", 50.0, 90.0);
        assertEquals(0, a.compareTo(b));
    }
}
