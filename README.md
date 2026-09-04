# Project: File IO

## Table of Contents

- [Project: File IO](#project-file-io)
  - [Table of Contents](#table-of-contents)
  - [Good work pledge](#good-work-pledge)
  - [Getting started](#getting-started)
  - [The Project](#the-project)
  - [Committing your Changes and Turning In The Project](#committing-your-changes-and-turning-in-the-project)
  - [Grading](#grading)

## Good work pledge

We are here to broaden your exposure to Computer Science. We can only achieve that purpose when you work hard and honestly. It may be tempting to copy-paste code from a classmate, or let a classmate do all your work for you—don't! You will be cheating yourself from the most valuable thing course has to offer—overcoming challenges.

We know that hard, and honest work doesn't come easily. If you feel like you are falling behind:

1. Don't copy-paste code, or let someone do your work for you
2. Ask for help!
3. Tell the teaching-team you need more time

## Getting started

1. Open the assignment link your teacher posts in **Teams** or **OneNote**, and accept the assignment. GitHub will create a private project just for you.
2. On your new project page, click the green **Code** button, copy the link, and clone the project into IntelliJ (File → New → Project from Version Control, then paste the link).
3. When IntelliJ asks if you trust the project, say yes / trust it so it can finish setting things up.
4. If IntelliJ asks you to pick a Java version (JDK), choose **17** or newer.
5. Use the green play **dropdown** near the top-right of IntelliJ and choose `Main` to run the program.

If anything looks confusing the first time you open the project, ask a teacher — IntelliJ asks a few one-time setup questions, and then day-to-day work is just writing code and using that green play button.


## The Project

In this project, you will be implementing functionality to read data from a file and write data to a file. Along with reading and writing to a file, you will get a flavor for dealing with exceptions and sorting.

The program allows you to run several commands that allows you to read data, manipulate data, and write data. The only manipulation we will be doing is sorting. Here are the commands that the program allows you to run:

- **Read**: takes in a file path and reads the weather data from the file.
- **Sort**: must be called after at least one 'read'. This command sorts the weather data that was read into the program in order of highest average temperature (the city with the highest average temperature will come first).
- **Write**: must be called after at least one 'read'. This commmand takes in a path and writes the data we have read into the file at that path. If the file already contains data, it is overwritten.
- **Append**: must be called after at least one 'read'. This commmand takes in a path and writes the data we have read into the file at that path. If the file already contains data, the new data will be appended to the existing contents.
- **Quit**: ends the program.

These are the functions you will implement:

- In Main.java:

  - **ReadFile**: Reads a file from the given path and puts the information into an ArrayList. If the file does not exist, the function catches the exception, prints a message to the console, and return an empty (not null) array.
  - **PrintWeatherData**: Prints the weather data ArrayList to the console. Each weather data item should go on a new line:

    [City1], [Average Temperature], [Average Humidity]
    [City2], [Average Temperature], [Average Humidity]

  - **SortWeatherData**: Sorts the given ArrayList from hottest average temperature to coldest average temperature
  - **WriteFile**: Writes the weather data information into the file with the given path. If shouldAppend is false, the function replaces the existing contents of the file (if it exists) with the new weatherData. If shouldAppend is true, the function adds the weather data to the end of the file. If the file cannot be created, the function catches the exception, prints a message to the console, and does not try to write to the file.

- In WeatherData.java:

  - **toString**: Returns a string representation of WeatherData:

    [City], [Average Temperature], [Average Humidity]

  - **compareTo**: Read the compareTo documentation and implement it here: <https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html#compareTo-T->

## Committing your Changes and Turning In The Project

At the end of every class period, commit and push your work from IntelliJ:

1. Click **Git > Commit…** (or use the Commit tool window).
2. Review the changed files. You can double-click a file to see the diff.
3. Enter a short commit message, then choose **Commit and Push…**.
4. Confirm the push to your project's `main` branch.
5. On GitHub, confirm your latest commits are visible.

Pushing to `main` is how you turn in work for this assignment. You can keep improving and pushing after the deadline if your teacher allows late work — ask about any late penalty.


## Grading

Your grade for each project will fall into one of four categories:

| Grade Level            | Explanation                                                                                                                                                                                  |
| :--------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| _Exceeds Expectations_ | <ul><li>Quality is outstanding.</li></ul>                                                                                                                                                    |
| _Excellent_            | <ul><li>Overall quality is high.</li></ul>                                                                                                                                                   |
| _Satisfactory_         | <ul><li>Overall quality is good.</li><li>Improvements can be made to bring the quality up to <i>Excellent</i>.</li></ul>                                                                     |
| _Needs Improvement_    | <ul><li>Overall quality is not yet high enough and the submission will not be accepted.</li><li>Improvements must be made to bring the quality up to at least <i>Satisfactory</i>.</li></ul> |
