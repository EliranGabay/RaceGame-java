/**
 * this class represent the AerialArena as a Arena with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package game.arenas.air;
import game.arenas.Arena;
import game.racers.Racer;
import game.racers.air.AerialRacer;
import utilities.EnumContainer.Vision;
import utilities.EnumContainer.Weather;
import utilities.EnumContainer.Height;
import utilities.EnumContainer.Wind;


public class AerialArena extends Arena {

    private Vision vision;
    private Weather weather;
    private Height height;
    private Wind wind;

    /**
     * this default constructs a AerialArena
     */
    public AerialArena()
    {
        super(1500,6,0.4);
        this.setVision(Vision.SUNNY);
        this.setWeather(Weather.DRY);
        this.setHeight(Height.HIGH);
        this.setWind(Wind.HIGH);
    }

    /**
     * this constructs a AerialArena
     * @param length
     * @param maxRacers
     */
    public AerialArena(double length, int maxRacers)
    {
        super(length,maxRacers,0.4);
        this.setVision(Vision.SUNNY);
        this.setWeather(Weather.DRY);
        this.setHeight(Height.HIGH);
        this.setWind(Wind.HIGH);
    }

    @Override
    public boolean racerTypeArena(Racer racer)
    {
        if(racer instanceof AerialRacer)return true;
        return false;
    }

    //Getter and Setter
    public Vision getVision() {
        return vision;
    }

    public void setVision(Vision vision) {
        this.vision = vision;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}

