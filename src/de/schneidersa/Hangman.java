package de.schneidersa;

/**
 * Kleines Java-Spiel, bei dem ein anonymisiertes Wort erraten werden soll.
 * Der Spieler hat dabei eine begrenzte Anzahl an Leben, die durch einen 
 * Hangman symbolisiert werden. Sobald das Männchen komplett am Galgen hängt,
 * ist das Spiel verloren.
 * 
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

    private static void initGame(GameLogic gameLogic) {
        // Game Settings
        gameLogic.addWords("Immatrikulationsbescheinigung", "Matrikelnummer", "Kaffee",
                "Verteilungsdiagramm", "Softwarearchitekt", "Sektflasche", "UML",
                "Softwareentwicklung");
    }

    private static void startGame(GameLogic gameLogic) {
        gameLogic.start();
        printMessageStart(gameLogic);

        do {
            gameLogic.handleUserInput();
            printAnonymizeWord(gameLogic);
        } while (gameLogic.nextRound());

        if (gameLogic.winGame()) {
            printMessageWin();
        } else {
            printMessageLoose();
        }

        askUserForNewGame(gameLogic);
    }

    private static void askUserForNewGame(GameLogic gameLogic) {
        String userInput = Utils.readUserInput();
        if (userInput.contains("J")) {
            startNewGame(gameLogic);
        } else {
            printMessageNoNextTry();
        }
    }

    private static void startNewGame(GameLogic gameLogic) {
        gameLogic.resetGame();
        startGame(gameLogic);
    }

    private static void printAnonymizeWord(GameLogic gameLogic) {
        System.out.println(gameLogic.anonymizeAndCheckWord());
    }

    private static void printMessageStart(GameLogic gameLogic) {
        printAnonymizeWord(gameLogic);
        System.out.println("Bitte geben Sie Ihren ersten Buchstaben ein:");
    }

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
