import java.util.ArrayList;

public class QuestionManager {

    public static boolean frageStellen(int indexQuestion, ArrayList<String> liste, FileHandler filehandler) {

        String questionArray[] = filehandler.getQuestionArray(indexQuestion, liste);
        final int MAX_QUESTION_IDX = questionArray.length-1;
        String userInput = "";
        boolean userAnswer = false;

        System.out.println("\nFrage " + (indexQuestion+1) + ": " + questionArray[0]);
        for (int i = 1; i < MAX_QUESTION_IDX; i++) {
            System.out.println("Antwortmöglichkeit " + i + ": " + questionArray[i]);
        }

        userInput = IO.readln("Bitte Antwort 1-4 auswählen: ");
        System.out.print("Lösung: Antwort " + questionArray[MAX_QUESTION_IDX] + "\n\n");

        if(userInput.equals(questionArray[MAX_QUESTION_IDX])) {
            userAnswer = true;
        }

        return userAnswer;
    }
}
