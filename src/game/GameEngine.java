package game;

import game.arenas.*;
import game.racers.*;

/**
 * this class represent the Game Engine with all needed components
 * @version 3.4.2018
 * @author Eliran gabay 203062831 & Linoy shriker 204027627
 */
public class GameEngine {
    private AerialArena airArena;
    private LandArena landArena;
    private NavalArena navalArena;
    private ArenaType activeArena;
    private static GameEngine instance=null;

    /**
     * @return instance implementaion of Singleton
     */
    public static GameEngine getInstance()
    {
        if(instance==null)
        {
            instance=new GameEngine();
        }
        return instance;
    }

    /**
     * ALL SETTERS AND GETTERS PARAMETERS& RETURN VALUES ARE:
     * airArena, landArena, navalArena, activeArena, arena.
     */
    //Getter & Setter
    public AerialArena getAirArena() {
        return airArena;
    }

    public boolean setAirArena(AerialArena airArena) {
        this.airArena = airArena;
        if(this.airArena!=null)return true;
        return false;
    }

    public LandArena getLandArena() {
        return landArena;
    }

    public boolean setLandArena(LandArena landArena) {
        this.landArena = landArena;
        if(this.landArena!=null)return true;
        return false;
    }

    public NavalArena getNavalArena() {
        return navalArena;
    }

    public boolean setNavalArena(NavalArena navalArena) {
        this.navalArena = navalArena;
        if(this.navalArena!=null)return true;
        return false;
    }

    public ArenaType getArenaType() {
        return activeArena;
    }

    public void setArenaType(ArenaType activeArena) {
        this.activeArena = activeArena;
    }

    //function
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

    
	/**
	 * @param newRacer
	 * @return false if the newRacer name exist, true otherwise.
	 */
    public boolean addRacer(Object newRacer)
    {
        if(newRacer instanceof Airplane && activeArena.equals(ArenaType.AERIALARENA))
        {
            if(this.airArena.addAirplane((Airplane)newRacer))return true;
            return false;
        }
        if(newRacer instanceof Helicopter && activeArena.equals(ArenaType.AERIALARENA))
        {
            if(this.airArena.addHelicopters((Helicopter)newRacer))return true;
            return false;
        }
        if(newRacer instanceof Horse && activeArena.equals(ArenaType.LANDARENA))
        {
            if(this.landArena.addHorse((Horse)newRacer))return true;
            return false;
        }
        if(newRacer instanceof Car && activeArena.equals(ArenaType.LANDARENA))
        {
            if(this.landArena.addCar((Car)newRacer))return true;
            return false;
        }
        if(newRacer instanceof RowBoat && activeArena.equals(ArenaType.NEVALARENA))
        {
            if(this.navalArena.addRowBoat((RowBoat)newRacer))return true;
            return false;
        }
        if(newRacer instanceof SpeedBoat && activeArena.equals(ArenaType.NEVALARENA))
        {
            if(this.navalArena.addSpeedBoat((SpeedBoat)newRacer))return true;
            return false;
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
            System.out.println("Aerial Race ended!");
            airArena.printWinners();
        }
        if(activeArena.equals(ArenaType.LANDARENA))
        {
            while (landArena.hasActiveRacers())
            {
                landArena.playTurn();
            }
            System.out.println("Land Race ended!");
            landArena.printWinners();
        }
        if(activeArena.equals(ArenaType.NEVALARENA))
        {
            while (navalArena.hasActiveRacers())
            {
                navalArena.playTurn();
            }
            System.out.println("Naval Race ended!");
            navalArena.printWinners();
        }
    }
}
