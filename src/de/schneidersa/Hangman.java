package de.schneidersa;

/**
 * @author Sandra Schneider
 */
public class Hangman {

    private Hangman() {
        super();
    }

    public static void main(String[] args) {

        GameLogic gameLogic = new GameLogic();

        initGame(gameLogic);
        startGame(gameLogic);
    }

    /**
     *
     * @param gameLogic
     */
    private static void initGame(GameLogic gameLogic) {
        // Game Settings
        gameLogic.addWord("Immatrikulationsbescheinigung", "Matrikelnummer", "Kaffee",
                "Verteilungsdiagramm", "Softwarearchitekt", "Sektflasche", "UML",
                "Softwareentwicklung");
    }

    /**
     *
     * @param gameLogic
     */
    private static void startGame(GameLogic gameLogic) {
        int randomWord = gameLogic.randomizeWords();
        System.out.println(gameLogic.anonymizeAndCheckWord(randomWord));

        System.out.println("Bitte geben Sie Ihren ersten Buchstaben ein:");
        do {
            gameLogic.inputChar(randomWord);
            System.out.println(gameLogic.anonymizeAndCheckWord(randomWord));
        } while (gameLogic.nextRound());

        if (gameLogic.winGame()) {
            printMessageWin();
        } else {
            printMessageLoose();
        }

        String userInput = Utils.readUserInput();
        if (userInput.contains("J")) {
            startNewGame(gameLogic);
        } else {
            printMessageNoNextTry();
        }
    }

    /**
     *
     * @param gameLogic
     */
    private static void startNewGame(GameLogic gameLogic) {
        gameLogic.resetGame();
        startGame(gameLogic);
    }

    /**
     * Print Messages
     */
    private static void printMessageNoNextTry() {
        System.out.println("Schade, dann ein andermal!");
    }

    private static void printMessageLoose() {
        System.out.println("Sie sind tot!");
        System.out.println("Möchten Sie es noch einmal versuchen? (J/N)");
    }

    private static void printMessageWin() {
        System.out.println("HERZLICHEN GLÜCKWUNSCH! \n Sie haben gewonnen!");
        System.out.println("Möchten Sie ein neues Spiel starten? (J/N)");
    }

}
