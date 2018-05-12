/**
 * this class represent the RacerTypeException extends Exception
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.arenas.exceptions;

@SuppressWarnings("serial")
public class RacerTypeException extends Exception {

    public RacerTypeException(String racerType, String arenaType) {
        super("Invalid Racer of type \"" + racerType + "\" for " + arenaType + " arena.");
    }

}
