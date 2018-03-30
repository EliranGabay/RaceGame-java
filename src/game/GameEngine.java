package game;

import game.arenas.AerialArena;
import game.arenas.ArenaType;
import game.racers.Airplane;

public class GameEngine {
    private AerialArena airArena;
    private ArenaType activeArena;
    private static GameEngine instance=null;

    public static GameEngine getInstance()
    {
        if(instance==null)
        {
            instance=new GameEngine();
        }
        return instance;
    }

    public boolean setArena(Object arena)
    {
        if(arena instanceof AerialArena)
        {
            this.airArena=(AerialArena)arena;
            this.activeArena=ArenaType.AERIALARENA;
            return true;
        }
        return false;
    }

    public boolean addRacer(Object newRacer)
    {
        if(newRacer instanceof Airplane)
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
