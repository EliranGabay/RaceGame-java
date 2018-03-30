package game.arenas;

import java.util.ArrayList;
import game.racers.*;
import utilities.*;


public class AerialArena {
	private ArrayList<Airplane> airplanes;
	private ArrayList<Object> finished;
	private final double FRICTION = 0.4;
	private final int MAX_RACERS = 6;
	private Point start;
	private Point finish;

	//constructor
	public AerialArena(Point start, Point finish) {
		this.start = new Point(start);
		this.finish = new Point(finish);
		finished = new ArrayList<Object>();
		airplanes = new ArrayList<Airplane>();
	}

	//Airplane
	public boolean addAirplane(Airplane airplane) {
		for(Airplane plane : airplanes)
		{
			if (plane.getName().equals(airplane.getName()) || (airplanes.size()> MAX_RACERS))
			{
				return false;
			}
		}
		
		airplanes.add(airplane);
		return true;
	}

	public int crossFinishLine(Airplane airplane) {
		finished.add(airplane);
		return finished.size(); //return array size and racers position
	}
	
	public boolean hasActiveRacers() {
		boolean hasActive = true;
		if (airplanes.size() == 0)
			hasActive = false;
		return hasActive;
	}
	
	public void initRace() {
		for(Airplane plane : airplanes) {
			plane.initRace(this, start, finish);
		}
	}
	
	public void playTurn() {
		if (hasActiveRacers()) {
			for(Airplane plane : airplanes){
				plane.move(FRICTION);
				if (plane.isFinished()) {
					crossFinishLine(plane);
				}
			}
		//removeFinishedAircrafts();
		}
	}
	
	public void printWinners() {
		for(int i=0; i<finished.size();i++) {
				System.out.println("#" + (i + 1) + ":  " + finished.get(i).toString());
			}
		}
	
}
