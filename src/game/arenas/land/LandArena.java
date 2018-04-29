/**
 * this class represent the LandArena as a Arena with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.arenas.land;
import game.arenas.Arena;
import game.racers.Racer;
import game.racers.land.LandRacer;
import utilities.EnumContainer.Coverage;
import utilities.EnumContainer.LandSurface;

public class LandArena extends Arena {

    private Coverage coverage;
    private LandSurface landSurface;

    /**
     * this default constructs a LandArena
     */
    public LandArena()
    {
        super(800,8,0.5);
        this.setCoverage(Coverage.GRASS);
        this.setLandSurface(LandSurface.FLAT);
    }

    /**
     * this constructs a LandArena
     * @param length
     * @param maxRacers
     */
    public LandArena(double length, int maxRacers)
    {
        super(length,maxRacers,0.5);
        this.setCoverage(Coverage.GRASS);
        this.setLandSurface(LandSurface.FLAT);
    }

    @Override
    public boolean racerTypeArena(Racer racer)
    {
        if(racer instanceof LandRacer)return true;
        return false;
    }

    //Getter ad Setter
    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }

    public LandSurface getLandSurface() {
        return landSurface;
    }

    public void setLandSurface(LandSurface landSurface) {
        this.landSurface = landSurface;
    }

}