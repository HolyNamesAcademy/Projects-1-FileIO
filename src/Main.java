import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
    Takes commands from the user and executes them. Possible commands are
    'read' - reads a file of weather data into the system
    'write' - writes weather data to a file -- overwrites the file if it exists
    'sort' - sorts weather data by the hottest to coldest average temperature
    'append' - writes weather data to a file -- appends data to the file if it exists
    'quit' - ends the program
     */
    public static void main(String[] args)
    {
        ArrayList<WeatherData> weatherData = null;
        while (true)
        {
            System.out.print("Enter a command: ");
            Scanner sc = new Scanner(System.in);

            String command = sc.next().toLowerCase();
            switch (command)
            {
                case "read":
                {
                    System.out.print("Enter the path to the file: ");
                    String path = sc.next();

                    weatherData = ReadFile(path);
                    PrintWeatherData(weatherData);
                    break;
                }
                case "sort":
                {
                    if (weatherData == null)
                    {
                        System.out.println("Please call 'read' first, before calling 'append'.");
                        break;
                    }

                    SortWeatherData(weatherData);
                    break;
                }
                case "write":
                {
                    if (weatherData == null)
                    {
                        System.out.println("Please call 'read' first, before calling 'write'.");
                        break;
                    }

                    System.out.print("Enter the path to the file: ");
                    String path = sc.next();

                    WriteFile(path, false, weatherData);
                    break;
                }
                case "append":
                {
                    if (weatherData == null)
                    {
                        System.out.println("Please call 'read' first, before calling 'append'.");
                        break;
                    }

                    System.out.print("Enter the path to the file: ");
                    String path = sc.next();

                    WriteFile(path, true, weatherData);
                    break;
                }
                case "quit":
                {
                    return;
                }
                default:
                {
                    System.out.println("Unrecognized command. Possible commands are 'read', 'write', 'append', 'sort', and 'quit'");
                    break;
                }
            }
        }
    }

    /*
    Reads a file from the given path and puts the information into an ArrayList.
    If the file does not exist, catch the exception, print a message, and return
    an empty (not null) ArrayList — do not rethrow.
    CSV: split on comma, trim each field, skip lines where parts.length != 3.
     */
    public static ArrayList<WeatherData> ReadFile(String path)
    {
        // remove the line below and implement your function here
        throw new UnsupportedOperationException();
    }

    /*
    Prints the weather data ArrayList to the console. Each weather data item should
    go on a new line:

    [City1], [Average Temperature], [Average Humidity]
    [City2], [Average Temperature], [Average Humidity]
    ...
     */
    public static void PrintWeatherData(ArrayList<WeatherData> weatherData)
    {
        // remove the line below and implement your function here
        throw new UnsupportedOperationException();
    }

    /*
    Sorts the given ArrayList from hottest average temperature to coldest average temperature.
    Hint: Collections.sort(list); Collections.reverse(list); after natural compareTo.
     */
    public static void SortWeatherData(ArrayList<WeatherData> weatherData)
    {
        // remove the line below and implement your function here
        throw new UnsupportedOperationException();
    }

    /*
    Writes the weather data information into the file with the given path.
    Prefer new FileWriter(path, shouldAppend) wrapped in PrintWriter.
    Warning: new PrintWriter(stream, boolean)'s boolean is autoFlush, not append.
    If the file cannot be created, catch the exception, print a message, and do not write.
     */
    public static void WriteFile(String path, boolean shouldAppend, ArrayList<WeatherData> weatherData)
    {
        // remove the line below and implement your function here
        throw new UnsupportedOperationException();
    }
}
