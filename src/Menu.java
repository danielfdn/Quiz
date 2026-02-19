import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import static java.lang.IO.readln;

public class Menu {
        public static final String GUELTIGE_EINGABE = "Bitte triff eine gültige Eingabe!";

    @Contract(" -> new")
    public static @NotNull Player createPlayer() {
        String name = readln("Name: ");
        Level level = null;

        while(level == null) {
            level = switch (IO.readln("\nSchwierigkeit wählen (1-3): ")) {
                case "1" -> level.EASY;
                case "2" -> level.MEDIUM;
                case "3" -> level.HARD;
                default -> null;
            };
        String output = level == null ? GUELTIGE_EINGABE : "Du hast Schwierigkeitsgrad " + level + " gewählt!";
            System.out.println(output + "\n");
        }
            return new Player(0, name, level);
    }
    public static int anzeigen(Player player) {
        int auswahl = 4;

        System.out.println("Willkommen zum Quizspiel Spieler " + player.getName() + "! Triff eine Menüeingabe (1-4)");

        while(true) {
        System.out.println("---------------------");
        System.out.print("\t" + Auswahl.SPIELEN.index + "\t"  + Auswahl.SPIELEN + "\n\t" + Auswahl.HIGHSCORE.index + "\t"  + Auswahl.HIGHSCORE + "\n\t" +
                            Auswahl.REGELWERK.index + "\t"  + Auswahl.REGELWERK + "\n\t" + Auswahl.BEENDEN.index + "\t" + Auswahl.BEENDEN + "\n");
        System.out.println("---------------------");

        try {
            auswahl = Integer.parseInt(readln());
            break;
        }
        catch (NumberFormatException e) {
            System.out.println(GUELTIGE_EINGABE);
            }
        }
        return auswahl;
     }

     public static void regelwerk() {

        System.out.println("\n\t\t\t\t\t\t\t\t\tDAS GROßE REGELWERK");
         System.out.println("--------------------------------------------------------------------------------------------" +
                                    "\n\t\t1. Die Fragen werden im Multible-Choice Format gestellt" +
                                    "\n\t\t2. Es gibt eine korrekte Antwortmöglichkeit pro Fragestellung" +
                                    "\n\t\t3. Der Schwierigkeitsgrad bestimmt die Anzahl der Punkte pro Frage" +
                                    "\n\t\t4. Um einen neuen Highscore aufzustellen muss der alte überboten werden");
         System.out.println("--------------------------------------------------------------------------------------------");
     }

     public static void highscoreAusgeben(Player player, FileHandler fileHandler) {
        boolean eingabe = false;
        String userPrompt = "Welchen Highscore möchtest du auslesen?\n1. Persönlicher Highscore\n2. Alltime Highscore\n";

        while(!eingabe) {
         switch(IO.readln(userPrompt)) {
             case "1":
                 System.out.println("Highscore " + player.getName().toUpperCase() + ": " + (player.getScore()));
                 eingabe = true;
                 break;
             case "2":
                 System.out.println("Highscore ALL TIME: " + fileHandler.highscoreAuslesen());
                 eingabe = true;
                 break;
             default:
                 System.out.println("Bitte triff eine gültige Eingabe");
                 break;
            }
         }
     }
}
