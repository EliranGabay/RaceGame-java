/**
 * this class represent the RacerLimitException extends Exception
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.arenas.exceptions;

@SuppressWarnings("serial")
public class RacerLimitException extends Exception {

    /**
     * @param ""
     *            + max_racers
     */
    public RacerLimitException(int max_racers, int racerNumber) {
        super("Arena is full! (" + max_racers + " active racers exist). racer #" + racerNumber + " was not added");
    }

}
