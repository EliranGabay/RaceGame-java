package game.arenas;

import java.util.ArrayList;
import game.racers.*;
import utilities.*;


public class AerialArena {
	private ArrayList<Airplane> airplanes;
	private ArrayList<Helicopter> helicopters;
	private ArrayList<Object> finished;
	private final double FRICTION = 0.4;
	private final int MAX_RACERS = 6;
	private Point start;
	private Point finish;
	
	public AerialArena(Point start, Point finish) {
		this.start = new Point(start);
		this.finish = new Point(finish);
		finished = new ArrayList<Object>();
		airplanes = new ArrayList<Airplane>();
		helicopters = new ArrayList<Helicopter>();
	}
	
	public boolean addAirplane(Airplane airplane) {
		for(Airplane plane : airplanes)
		{
			if (plane.getName() == airplane.getName || (airplanes.size() + helicopters.size() > MAX_RACERS))
			{
				return false;
			}
		}
		
		airplanes.add(airplane);
		return true;
	}

	public boolean addHelicopter(Helicopter helicopter) {
		for(Helicopter heli : helicopters)
		{
			if (heli.getName() == helicopter.getName() || (airplanes.size() + helicopters.size() > MAX_RACERS))
			{
				return false;
			}
		}
		
		helicopters.add(helicopter);
		return true;
	}

	public int crossFinishLine(Helicopter helicopter) {
		finished.add(helicopter);
		return finished.size(); //return arraysize and racers position
	}
	
	public int crossFinishLine(Airplane airplane) {
		finished.add(airplane);
		return finished.size(); //return array size and racers position
	}
	
	public boolean hasActiveRacers() {
		boolean hasActive = true;
		if (airplanes.size() == 0 && helicopters.size() == 0)
			hasActive = false;
		return hasActive;
	}
	
	public void initRace() {
		for(Airplane plane : airplanes) {
			plane.initRace(this, start, finish);
		}
		
		for(Helicopter heli : helicopters)	
			heli.initRace(this,start,finish); 
	}
	
	public void playTurn() {
		if (hasActiveRacers()) {
			for(Airplane plane : airplanes){
				plane.move(FRICTION);
				if (plane.isFinished()) {
					crossFinishLine(plane);
				}
			}
			
			for(Helicopter heli: helicopters) {
				heli.move(FRICTION);
				if (heli.isFinished()) {
					crossFinishLine(heli);
				}
			}
	
		removeFinishedAircrafts();
		}
	}
	
	public void printWinners() {
		for(int i=0; i<finished.size();i++) {
				System.out.println("#" + (i + 1) + ":  " + finished.get(i).toString());
			}
		}
	
}
