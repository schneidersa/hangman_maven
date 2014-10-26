package de.schneidersa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 *
 * @author Sandra Schneider
 */
public class GameLogic {

    List<String> words = new ArrayList<>();
    Set<Character> inputChars = new HashSet<>();
    boolean wordMatched = false;
    int wrongCharCounter = 0;

    public void addWord(String word) {
        words.add(word.toUpperCase());
    }

    /**
     * Konvertiert Buchstaben des incWord in _ und speichert dieses in der Variablen outWord ab
     *
     * @param wordIndex 
     * @return          String, in dem Buchstaben durch _ ersetzt sind
     */
    public String anonymizeAndCheckWord(int wordIndex) {
        String incWord = words.get(wordIndex);
        StringBuilder outWord = new StringBuilder("");
        wordMatched = true;

        for (int i = 0; i < incWord.length(); i++) {
            if (inputChars.contains(incWord.charAt(i))) {
                outWord.append(incWord.charAt(i));
                outWord.append(" ");
            } else {
                // Wenn Set inputChars leer ist, ersetze den Buchstaben mit _
                outWord.append("_ ");
                wordMatched = false;
            }
        }

        return outWord.toString();
    }

    /**
     * User Input
     */
    public Character inputChar(int wordIndex) {
        String incWord = words.get(wordIndex);
        String regex = "[a-zA-Z]";
        Scanner in = new Scanner(System.in);
        String readChar = in.nextLine().toUpperCase();
//        Pattern p = Pattern.compile("[a-zA-Z]");
//        Matcher m = p.matcher(readChar);
//        boolean b = m.matches();
//        System.out.println(b);

        if (readChar.length() > 1) {
            System.out.println("Fehler! Bitte geben Sie nur einen Buchstaben ein");
            return '#';
        } else if (readChar.length() == 0) {
            System.out.println("Fehler! Bitte geben Sie einen Buchstaben ein");
            return '#';
        } else if (!Pattern.matches(regex, readChar)) {
            System.out.println("Bitte geben sie einen gültigen Wertebereich (A-Z) ein");
            return '#';
        }
//            else if (b == false) {
//            System.out.println("Bitte geben sie einen gültigen Wertebereich (A-Z) ein");
//            return '#';
//        }

        if (incWord.indexOf(readChar.charAt(0)) == -1) {
            wrongCharCounter++;
            System.out.println("Der Buchstabe ist im Wort nicht enthalten");
        }

        printHangman();
        inputChars.add(readChar.charAt(0));

        return readChar.charAt(0);
    }

    public boolean matchedWord() {
        return wordMatched;
    }

    public void printHangman() {
        switch (wrongCharCounter) {
            case 0:
                System.out.println(" __________");
                System.out.println(" |/     ");
                System.out.println(" |      ");
                System.out.println(" |      ");
                System.out.println(" |      ");
                System.out.println(" |      ");
                System.out.println("_|___");
                break;
            case 1:
                System.out.println(" __________");
                System.out.println(" |/      |");
                System.out.println(" |      (_)");
                System.out.println(" |     ");
                System.out.println(" |       ");
                System.out.println(" |      ");
                System.out.println("_|___");
                break;
            case 2:
                System.out.println(" __________");
                System.out.println(" |/      |");
                System.out.println(" |      (_)");
                System.out.println(" |       |");
                System.out.println(" |       |");
                System.out.println(" |      ");
                System.out.println("_|___");
                break;
            case 3:
                System.out.println(" __________");
                System.out.println(" |/      |");
                System.out.println(" |      (_)");
                System.out.println(" |       |");
                System.out.println(" |       |");
                System.out.println(" |        \\");
                System.out.println("_|___");
                break;
            case 4:
                System.out.println(" __________");
                System.out.println(" |/      |");
                System.out.println(" |      (_)");
                System.out.println(" |       |");
                System.out.println(" |       |");
                System.out.println(" |      / \\");
                System.out.println("_|___");
                break;
            case 5:
                System.out.println(" __________");
                System.out.println(" |/      |");
                System.out.println(" |      (_)");
                System.out.println(" |       |/");
                System.out.println(" |       |");
                System.out.println(" |      / \\");
                System.out.println("_|___");
                break;
            case 6:
                System.out.println(" __________");
                System.out.println(" |/      |");
                System.out.println(" |      (_)");
                System.out.println(" |      \\|/");
                System.out.println(" |       |");
                System.out.println(" |      / \\");
                System.out.println("_|___");
                break;
        }
    }
}
