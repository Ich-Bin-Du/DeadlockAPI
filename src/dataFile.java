import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.*;

public class dataFile {


    static void createFile(String name) {
        try {
            File file = new File("Files\\" + name + ".txt"); // Create File object
            if (file.createNewFile()) {
                out.println("File created: " + file.getName());
            } else {
                out.println("File already exists.");
            }
        } catch (IOException e) {
            out.println("An error occurred, while making the file.");
            e.printStackTrace();
        }
    }
    static void writeFile(String name, String text) {
            try {
                FileWriter myWriter = new FileWriter("Files\\" + name + ".txt");
                myWriter.write(text);
                myWriter.close();  // must close manually
                out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                out.println("An error occurred, while writing to the File.");
                e.printStackTrace();
            }
    }

    static void readFile(String name){ //Template function maybe for later use, probably not
        File myObj = new File("Files\\" + name + ".txt");

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                out.println(data);
            }
        } catch (FileNotFoundException e) {
            out.println("An error occurred, while reading the File");
            e.printStackTrace();
        }
    }

    static void readMatchData(String name){
        File myObj = new File("Files\\" + name + ".txt");
        int matchId = 0;
        int heroLevel = 0;
        int kills = 0;
        int deaths = 0;
        int assists = 0;
        long startTime;
        Date date = null;
        String[] heroes = {"Infernus", };
        boolean looping = true;

        try (Scanner myReader = new Scanner(myObj)) {
            while (looping) {
                String data = myReader.nextLine();
                //while (looping){
                    switch(data) { // gets all match Data
                        case String s when s.contains("match_id") -> {
                            matchId = Integer.parseInt(data.replaceAll("\\D", ""));
                        }
                        case String s when s.contains("hero_level") -> {
                            heroLevel = Integer.parseInt(data.replaceAll("\\D", ""));
                        }
                        case String s when s.contains("kills") -> {
                            kills = Integer.parseInt(data.replaceAll("\\D", ""));
                        }
                        case String s when s.contains("deaths") -> {
                            deaths = Integer.parseInt(data.replaceAll("\\D", ""));
                        }
                        case String s when s.contains("assists") -> {
                            assists = Integer.parseInt(data.replaceAll("\\D", ""));
                        }
                        case String s when s.contains("start_time") ->{
                            startTime = Long.parseLong(data.replaceAll("\\D", ""));
                            date = new Date(startTime*1000L);
                        }
                        case String s when s.contains("}") -> {
                            looping = false;

                        }

                        default -> out.print("");

                    }
                //}
            }
            out.println(date);
            out.println(matchId);
            out.println("Kills: " + kills);
            out.println("Deaths: " + deaths);
            out.println("Assists: " + assists);
            out.println("Hero Level: " + heroLevel);

        } catch (FileNotFoundException e) {
            out.println("An error occurred, while Reading your match results.");
            e.printStackTrace();
        }
    }
}

