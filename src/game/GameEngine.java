package game;

import game.arenas.*;
import game.racers.*;

public class GameEngine {
    private AerialArena airArena;
    private LandArena landArena;
    private NavalArena navalArena;
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
        if(arena instanceof LandArena)
        {
            this.landArena=(LandArena)arena;
            this.activeArena=ArenaType.LANDARENA;
            return true;
        }
        if(arena instanceof NavalArena)
        {
            this.navalArena=(NavalArena)arena;
            this.activeArena=ArenaType.NEVALARENA;
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
        if(newRacer instanceof Helicopter)
        {
            this.airArena.addHelicopters((Helicopter)newRacer);
            return true;
        }
        if(newRacer instanceof Horse)
        {
            this.landArena.addHorse((Horse)newRacer);
            return true;
        }
        if(newRacer instanceof Car)
        {
            this.landArena.addCar((Car)newRacer);
            return true;
        }
        if(newRacer instanceof RowBoat)
        {
            this.navalArena.addRowBoat((RowBoat)newRacer);
            return true;
        }
        if(newRacer instanceof SpeedBoat)
        {
            this.navalArena.addSpeedBoat((SpeedBoat)newRacer);
            return true;
        }
        return false;
    }

    public void initRace()
    {
        if(activeArena.equals(ArenaType.AERIALARENA))airArena.initRace();
        if(activeArena.equals(ArenaType.LANDARENA))landArena.initRace();
        if(activeArena.equals(ArenaType.NEVALARENA))navalArena.initRace();
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
        if(activeArena.equals(ArenaType.LANDARENA))
        {
            while (landArena.hasActiveRacers())
            {
                landArena.playTurn();
            }
            landArena.printWinners();
        }
        if(activeArena.equals(ArenaType.NEVALARENA))
        {
            while (navalArena.hasActiveRacers())
            {
                navalArena.playTurn();
            }
            navalArena.printWinners();
        }
    }
}
