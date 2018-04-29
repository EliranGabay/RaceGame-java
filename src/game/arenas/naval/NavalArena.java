/**
 * this class represent the NavalArena as a Arena with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.arenas.naval;
import game.arenas.Arena;
import game.racers.Racer;
import game.racers.naval.NavalRacer;
import utilities.EnumContainer.Water;
import utilities.EnumContainer.NavalSurface;
import utilities.EnumContainer.Body;


public class NavalArena extends Arena {

    private Water water;
    private NavalSurface navalSurface;
    private Body body;

    /**
     * this default constructs a NavalArena
     */
    public NavalArena()
    {
        super(1000,5,0.7);
        this.setWater(Water.SWEET);
        this.setNavalSurface(NavalSurface.FLAT);
        this.setBody(Body.LAKE);
    }

    /**
     * this constructs a NavalArena
     * @param length
     * @param maxRacers
     */
    public NavalArena(double length, int maxRacers)
    {
        super(length,maxRacers,0.7);
        this.setWater(Water.SWEET);
        this.setNavalSurface(NavalSurface.FLAT);
        this.setBody(Body.LAKE);
    }

    @Override
    public boolean racerTypeArena(Racer racer)
    {
        if(racer instanceof NavalRacer)return true;
        return false;
    }

    //Getter and Setter
    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public NavalSurface getNavalSurface() {
        return navalSurface;
    }

    public void setNavalSurface(NavalSurface navalSurface) {
        this.navalSurface = navalSurface;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

}
