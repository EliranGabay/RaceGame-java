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
		for(Object player :finished)
		{
			if(player.equals(airplane))return finished.size();
		}
		finished.add(airplane);
		return finished.size(); //return array size and racers position
	}
	
	public boolean hasActiveRacers() {
		boolean hasActive = true;
		if (finished.size()==airplanes.size())
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
		}
	}
	
	public void printWinners() {
		for(int i=0; i<finished.size();i++) {
				if(finished.get(i) instanceof Airplane)System.out.println("#" + (i + 1) + ":  " +((Airplane) finished.get(i)).getName());
			}
		}
	
}
