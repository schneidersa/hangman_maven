package de.schneidersa;

/**
 * Printer-Klasse, die mit Hilfe des Interfaces IHangmanOutput den Hangman mit 
 * der ausgewählten Implementierung HangmanOutputConsole in der Console ausgibt.
 * 
 * @author Sandra Schneider
 */
public class GallowPrinter {

    private static final int SIX_FAILS = 6;
    private static final int FIVE_FAILS = 5;
    private static final int FOUR_FAILS = 4;
    private static final int THREE_FAILS = 3;
    private static final int TWO_FAILS = 2;
    private static final int ONE_FAIL = 1;
    private static final int NO_FAIL = 0;

    private final IHangmanOutput output;

    public GallowPrinter(IHangmanOutput output) {
        this.output = output;
    }

    public final void printGallow(final int wrongCharCounter) {
        switch (wrongCharCounter) {
            case NO_FAIL:
                printGallow();
                break;
            case ONE_FAIL:
                printGallowWithHead();
                break;
            case TWO_FAILS:
                printGallowWithHeadAndBody();
                break;
            case THREE_FAILS:
                printGallowWithHeadBodyAndRightLeg();
                break;
            case FOUR_FAILS:
                printGallowWithHeadBodyAndLegs();
                break;
            case FIVE_FAILS:
                printGallowWithHeadBodyLegsAndRightArm();
                break;
            case SIX_FAILS:
                printGallowWithHeadBodyLegsAndArms();
                break;
            default:
                break;
        }
    }

    private void printGallowWithHeadBodyLegsAndArms() {
        output.printGallowTop();
        output.printHangmansHead();
        output.printHangmansArms();
        output.printHangmansBody();
        output.printHangmansLegs();
        output.printGallowBottom();
    }

    private void printGallowWithHeadBodyLegsAndRightArm() {
        output.printGallowTop();
        output.printHangmansHead();
        output.printHangmansRightHand();
        output.printHangmansBody();
        output.printHangmansLegs();
        output.printGallowBottom();
    }

    private void printGallowWithHeadBodyAndLegs() {
        output.printGallowTop();
        output.printHangmansHead();
        output.printHangmansBody();
        output.printHangmansBody();
        output.printHangmansLegs();
        output.printGallowBottom();
    }

    private void printGallowWithHeadBodyAndRightLeg() {
        output.printGallowTop();
        output.printHangmansHead();
        output.printHangmansBody();
        output.printHangmansBody();
        output.printHangmangsRightLeg();
        output.printGallowBottom();
    }

    private void printGallowWithHeadAndBody() {
        output.printGallowTop();
        output.printHangmansHead();
        output.printHangmansBody();
        output.printHangmansBody();
        output.printGallowPiece();
        output.printGallowBottom();
    }

    private void printGallowWithHead() {
        output.printGallowTop();
        output.printHangmansHead();
        output.printGallowPiece();
        output.printGallowPiece();
        output.printGallowPiece();
        output.printGallowBottom();
    }

    private void printGallow() {
        output.printGallowTop();
        output.printHangmansRightArm();
        output.printGallowPiece();
        output.printGallowPiece();
        output.printGallowPiece();
        output.printGallowPiece();
        output.printGallowBottom();
    }
}
