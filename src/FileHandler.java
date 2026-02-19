import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {

    private String[] pfadLevel = {"src/Level1Questions.txt", "src/Level2Questions.txt", "src/Level3Questions.txt"};
    private String pfadHighscore = "src/Highscore.txt";

    private ArrayList<String> questionList = new ArrayList<>();

    public int highscoreAuslesen() {
        Integer highscore = null;
        String highscoreString = dateiScannen(pfadHighscore).getFirst();

        try {
            highscore = Integer.parseInt(highscoreString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid highscore format");
        }
        return highscore;
    }

    public void setFileHighscore(Integer userScore) throws IOException{
        if(userScore > highscoreAuslesen())
            Files.writeString(Path.of(pfadHighscore), String.valueOf(userScore));
    }

    public ArrayList<String> fragenAuslesen(Level level) {
        String pfadString = null;

        switch (level) {
            case level.EASY -> {
                pfadString = pfadLevel[0];
            }
            case level.MEDIUM -> {
                pfadString = pfadLevel[1];
            }
            case level.HARD -> {
                pfadString = pfadLevel[2];
            }
        }
        return dateiScannen(pfadString);
    }

    public ArrayList<String> dateiScannen(String dateiPfad) {
        ArrayList<String> fileList = new ArrayList<>();

        File f = new File(dateiPfad);
        Scanner scan = null;

        try {
            scan = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        while(scan.hasNextLine()) {
        fileList.add(scan.nextLine());
      }
        scan.close();
    return fileList;
    }

    public String[] getQuestionArray(int indexQuestion, ArrayList<String> liste) {
        String[] questionArray = (liste.get(indexQuestion).split("[|]"));
        return questionArray;
    }

}















