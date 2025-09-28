import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class dataFile {


    static void createFile(String name) {
        try {
            File file = new File("Files\\" + name + ".txt"); // Create File object
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred, while making the file.");
            e.printStackTrace();
        }
    }
    static void writeFile(String name, String text) {
            try {
                FileWriter myWriter = new FileWriter("Files\\" + name + ".txt");
                myWriter.write(text);
                myWriter.close();  // must close manually
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred, while writing to the File.");
                e.printStackTrace();
            }
    }

    static void readFile(String name){
        File myObj = new File("Files\\" + name + ".txt");

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred, while reading the File");
            e.printStackTrace();
        }
    }

    static void readMatchResult(String name){
        File myObj = new File("Files\\" + name + ".txt");
        int wins = 0;
        int losses = 0;

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("\"match_result\": 0,"))
                    wins++;
                else if (data.equals("\"match_result\": 1,")) {
                    losses++;
                }
            }
            double winrate = (double) Math.round(((double) wins / (double) losses) * 100) / 100;
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);
            System.out.println("Winrate: " + winrate);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred, while Reading your match results.");
            e.printStackTrace();
        }
    }


}

