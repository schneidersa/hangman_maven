package de.schneidersa;

/**
 *
 * @author Sandra Schneider
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // init GameLogic      
        GameLogic gameLogic = new GameLogic();

        // Game Settings
        gameLogic.addWord("Immatrikulationsbescheinigung");
        gameLogic.addWord("Matrikelnummer");
        gameLogic.addWord("Kaffee");
        gameLogic.addWord("Verteilungsdiagramm");
        gameLogic.addWord("Softwarearchitekt");
        gameLogic.addWord("Sektflasche");
        gameLogic.addWord("UML");
        gameLogic.addWord("Softwareentwicklung");
        

        /**
         * Game Loop
         */
        System.out.println("Wenn Sie nicht gehängt werden wollen, geben Sie SOFORT einen Buchstaben ein!");
        do {
            gameLogic.inputChar(2);
            System.out.println(gameLogic.anonymizeAndCheckWord(2));
            System.out.println("Counter:" + gameLogic.wrongCharCounter);
        } while (gameLogic.wrongCharCounter < 6 && gameLogic.matchedWord() == false);
        
        if(gameLogic.wordMatched == true) {
            System.out.println("HERZLICHEN GLÜCKWUNSCH, Sie wurden nicht erhängt!");
        } else {
            System.out.println("Sie sind tot!");
        }
    }

}
