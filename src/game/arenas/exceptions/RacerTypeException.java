/**
 * this class represent the RacerTypeException extends Exception
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.arenas.exceptions;

import game.arenas.Arena;
import game.racers.Racer;

public class RacerTypeException extends Exception {

    private static final long serialVersionUID = 1L;

    public RacerTypeException(Racer racer,Arena arena)
    {
        super("Invalid Racer of type ["+ racer.className()+"] for "+arena.getClass().getSimpleName()+".");
    }

}
