package utilities;

/**
 * Contains all Enums for the game.
 * 
 * To set a field type: 
 * 		EnumContainer.Vision vision;
 * To set a value:
 * 		this.vision = EnumContainer.Vision.Sunny
 * 
 * @author Bar Ohayon
 *
 */
public class EnumContainer {

	public static enum Vision {
		CLOUDS, SUNNY, FOG
	}
	public static enum Color{
		RED,GREEN,BLUE,BLACK,YELLOW
	}

	public static enum Engine{
		FOURSTROKE, VTYPE, STRAIGHT, BOXER, ROTARY
	}

	public static enum BicycleType{
		MOUNTAIN,HYBRID,CRUISER,ROAD
	}

	public static enum Breed{
		THOROUGHBRED,STANDARDBRED,MORGAN,FRIESIAN
	}

	public static enum RowType{
		SKULLING,SWEEP
	}

	public static enum Team{
		SINGLE,DOUBLE,QUAD,EIGHT
	}
}
