package de.schneidersa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author Sandra Schneider
 */
public class GameLogic {

    private static final int HANGMAN_LIVES = 6;
    private final List<String> guessWords = new ArrayList<>();
    private final Set<Character> inputChars = new HashSet<>();
    private final GallowPrinter gallowPrinter = new GallowPrinter();
    private boolean wordMatched = false;
    private int wrongCharCounter = 0;

    /**
     * Fügt jedes neue Wort der Liste words hinzu.
     *
     * @param word
     * @param words
     */
    public void addWord(String word, String... words) {
        guessWords.add(word.toUpperCase());

        if (words == null) {
            return;
        }

        for (String singleWord : words) {
            guessWords.add(singleWord.toUpperCase());
        }
    }

    /**
     * Generiert eine Zufallszahl zwischen 0 und der Größe des words Arrays.
     *
     * @return randomWord als integer
     */
    public final int randomizeWords() {
        return (int) (Math.random() * guessWords.size());
    }

    /**
     * Konvertiert Buchstaben des incWord in _ und speichert dieses in der Variablen outWord ab
     *
     * @param wordIndex
     * @return String, in dem Buchstaben durch _ ersetzt sind
     */
    public String anonymizeAndCheckWord(int wordIndex) {
        String incWord = guessWords.get(wordIndex);
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
     *
     * @param wordIndex is the number of the random word
     */
    public void inputChar(int wordIndex) {
        String incWord = guessWords.get(wordIndex);
        String regex = "[a-zA-ZöäüÖÄÜß]";
        String userInput = Utils.readUserInput();

        if (userInput.length() > 1) {
            System.out.println("Fehler! Bitte geben Sie nur einen Buchstaben ein");
            return;
        } else if (userInput.length() == 0) {
            System.out.println("Fehler! Bitte geben Sie einen Buchstaben ein");
            return;
        } else if (!Pattern.matches(regex, userInput)) {
            System.out.println("Bitte geben sie einen gültigen Wertebereich (A-Z) ein");
            return;
        } else if (inputChars.contains(userInput.charAt(0))) {
            System.out.println("Diesen Buchstaben hatten wir doch schonmal");
            return;
        }

        if (incWord.indexOf(userInput.charAt(0)) == -1) {
            wrongCharCounter++;
            System.out.println("Schade! Der Buchstabe ist im Wort nicht enthalten");
        }

        // call the print function
        gallowPrinter.printGallow(wrongCharCounter);
        inputChars.add(userInput.charAt(0));
    }

    public boolean nextRound() {
        return wrongCharCounter < HANGMAN_LIVES && !wordMatched;
    }

    public boolean winGame() {
        return wordMatched;
    }

    public void resetGame() {
        inputChars.clear();
        wordMatched = false;
        wrongCharCounter = 0;
    }
}
