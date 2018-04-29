/**
 * this class represent the RacerLimitException extends Exception
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.arenas.exceptions;

import game.racers.Racer;

public class RacerLimitException extends Exception {

    private static final long serialVersionUID = 1L;

    public RacerLimitException(int size, Racer racer)
    {
        super("Arena is full! ( "+size+" active racers exist).racer #"+racer.getSerialNumber()+ " was not added" );
    }
}
