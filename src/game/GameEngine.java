package game;

import game.arenas.AerialArena;
import game.arenas.ArenaType;
import game.racers.Airplane;

public class GameEngine {
    AerialArena airArena;
    ArenaType activeArena;
    GameEngine instance;

    /*public GameEngine getInstance()
    {

    }*/

    public boolean setArena(Object arena)
    {
        if(arena.getClass().isInstance(airArena.getClass()))
        {
            this.airArena=(AerialArena)arena;
            this.activeArena=ArenaType.AERIALARENA;
            return true;
        }
        return false;
    }

    public boolean addRacer(Object newRacer)
    {
        if(newRacer.getClass().isInstance(Airplane.class))
        {
            this.airArena.addAirplane((Airplane)newRacer);
            return true;
        }
        return false;
    }

    public void initRace()
    {
        if(activeArena.equals(ArenaType.AERIALARENA))airArena.initRace();
    }

    public void startRace()
    {
        if(activeArena.equals(ArenaType.AERIALARENA))
        {
            while (airArena.hasActiveRacers())
            {
                airArena.playTurn();
            }
            airArena.printWinners();
        }
    }
}
