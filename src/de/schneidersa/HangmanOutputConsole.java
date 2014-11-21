package de.schneidersa;

/**
 * Implementierung des Interfaces für Ausgabe des Hangman in die Konsole.
 * 
 * @author Sandra Schneider
 */
public class HangmanOutputConsole implements IHangmanOutput {

    @Override
    public void printHangmansLegs() {
        System.out.println(" |      / \\");
    }

    @Override
    public void printHangmansHead() {
        System.out.println(" |/      |");
        System.out.println(" |      (_)");
    }

    @Override
    public void printHangmansRightArm() {
        System.out.println(" |/     ");
    }

    @Override
    public void printGallowBottom() {
        System.out.println("_|___");
    }

    @Override
    public void printHangmansBody() {
        System.out.println(" |       |");
    }

    @Override
    public void printHangmangsRightLeg() {
        System.out.println(" |        \\");
    }

    @Override
    public void printHangmansRightHand() {
        System.out.println(" |       |/");
    }

    @Override
    public void printGallowTop() {
        System.out.println(" __________");
    }

    @Override
    public void printHangmansArms() {
        System.out.println(" |      \\|/");
    }

    @Override
    public void printGallowPiece() {
        System.out.println(" |      ");
    }
    
}
