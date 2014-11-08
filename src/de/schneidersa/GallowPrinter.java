package de.schneidersa;

/**
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

    /**
     *
     * @param wrongCharCounter
     */
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
        printGallowTop();
        printHangmansHead();
        printHangmansArms();
        printHangmansBody();
        printHangmansLegs();
        printGallowBottom();
    }

    private void printGallowWithHeadBodyLegsAndRightArm() {
        printGallowTop();
        printHangmansHead();
        printHangmansRightArm();
        printHangmansBody();
        printHangmansLegs();
        printGallowBottom();
    }

    private void printGallowWithHeadBodyAndLegs() {
        printGallowTop();
        printHangmansHead();
        printHangmansBody();
        printHangmansBody();
        printHangmansLegs();
        printGallowBottom();
    }

    private void printGallowWithHeadBodyAndRightLeg() {
        printGallowTop();
        printHangmansHead();
        printHangmansBody();
        printHangmansBody();
        printHangmansRightLeg();
        printGallowBottom();
    }

    private void printGallowWithHeadAndBody() {
        printGallowTop();
        printHangmansHead();
        printHangmansBody();
        printHangmansBody();
        printGallowPiece();
        printGallowBottom();
    }

    private void printGallowWithHead() {
        printGallowTop();
        printHangmansHead();
        printGallowPiece();
        printGallowPiece();
        printGallowPiece();
        printGallowBottom();
    }

    private void printGallow() {
        printGallowTop();
        printGallowCrossbar();
        printGallowPiece();
        printGallowPiece();
        printGallowPiece();
        printGallowPiece();
        printGallowBottom();
    }

    private void printGallowTop() {
        System.out.println(" __________");
    }

    private void printGallowCrossbar() {
        System.out.println(" |/     ");
    }

    private void printGallowPiece() {
        System.out.println(" |      ");
    }

    private void printHangmansHead() {
        System.out.println(" |/      |");
        System.out.println(" |      (_)");
    }

    private void printHangmansRightArm() {
        System.out.println(" |       |/");
    }

    private void printHangmansArms() {
        System.out.println(" |      \\|/");
    }

    private void printHangmansBody() {
        System.out.println(" |       |");
    }

    private void printHangmansRightLeg() {
        System.out.println(" |        \\");
    }

    private void printHangmansLegs() {
        System.out.println(" |      / \\");
    }

    private void printGallowBottom() {
        System.out.println("_|___");
    }
}
