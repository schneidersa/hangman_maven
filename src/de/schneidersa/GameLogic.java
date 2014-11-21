package de.schneidersa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * GameLogic für Java-Spiel Hangman.
 * 
 * @author Sandra Schneider
 */
public class GameLogic {

    private static final int HANGMAN_LIVES = 6;
    private final List<String> guessWords = new ArrayList<>();
    private final Set<Character> inputChars = new HashSet<>();
    private final GallowPrinter gallowPrinter = new GallowPrinter(new HangmanOutputConsole());
    private boolean wordMatched = false;
    private int wrongCharCounter = 0;
    private int randomWordIndex;

    public void start() {
        randomWordIndex = randomizeWords();
    }

    public void addWords(String word, String... words) {
        guessWords.add(word.toUpperCase());

        if (words == null) {
            return;
        }

        for (String singleWord : words) {
            guessWords.add(singleWord.toUpperCase());
        }
    }

    /**
     * Generiert eine Zufallszahl zwischen 0 und der Größe des Array words.
     *
     * @return randomWord als integer
     */
    private int randomizeWords() {
        return (int) (Math.random() * guessWords.size());
    }

    /**
     * Konvertiert Buchstaben des incWord in _ und speichert dieses in der Variablen outWord ab
     *
     * @return String, in dem Buchstaben durch _ ersetzt sind
     */
    public String anonymizeAndCheckWord() {
        String incWord = guessWords.get(randomWordIndex);
        StringBuilder outWord = new StringBuilder("");
        wordMatched = true;

        for (int i = 0; i < incWord.length(); i++) {
            if (inputChars.contains(incWord.charAt(i))) {
                outWord.append(incWord.charAt(i));
                outWord.append(" ");
            } else {
                // Wenn inputChars leer ist, ersetze den Buchstaben mit _
                outWord.append("_ ");
                wordMatched = false;
            }
        }
        return outWord.toString();
    }

    public void handleUserInput() {
        String incWord = guessWords.get(randomWordIndex);
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

        checkWordContainsUserInput(incWord, userInput);

        gallowPrinter.printGallow(wrongCharCounter);
        inputChars.add(userInput.charAt(0));
    }

    private void checkWordContainsUserInput(String incWord, String userInput) {
        if (incWord.indexOf(userInput.charAt(0)) == -1) {
            wrongCharCounter++;
            System.out.println("Schade! Der Buchstabe ist im Wort nicht enthalten");
        }
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
