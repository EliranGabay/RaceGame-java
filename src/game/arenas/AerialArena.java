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

	//constructor
	public AerialArena(Point start, Point finish) {
		this.start = new Point(start);
		this.finish = new Point(finish);
		finished = new ArrayList<Object>();
		airplanes = new ArrayList<Airplane>();
		helicopters= new ArrayList<Helicopter>();
	}

	//Airplane
	public boolean addAirplane(Airplane airplane) {
		for(Airplane plane : airplanes)
		{
			if (plane.getName().equals(airplane.getName()))
			{
				return false;
			}
		}
		if(airplanes.size()+helicopters.size()>MAX_RACERS)return false;
		airplanes.add(airplane);
		return true;
	}

	//Helicopter
	public boolean addHelicopters(Helicopter helicopter) {
		for(Helicopter plane : helicopters)
		{
			if (plane.getName().equals(helicopter.getName()))
			{
				return false;
			}
		}
		if(airplanes.size()+helicopters.size()>MAX_RACERS)return false;
		helicopters.add(helicopter);
		return true;
	}

	//Airplane
	public int crossFinishLine(Airplane airplane) {
		for(Object player :finished)
		{
			if(player.equals(airplane))return finished.size();
		}
		finished.add(airplane);
		return finished.size(); //return array size and Airplane position
	}

	//Helicopter
	public int crossFinishLine(Helicopter helicopter) {
		for(Object player :finished)
		{
			if(player.equals(helicopter))return finished.size();
		}
		finished.add(helicopter);
		return finished.size(); //return array size and Helicopter position
	}
	
	public boolean hasActiveRacers() {
		boolean hasActive = true;//
		if (finished.size()==airplanes.size()+helicopters.size())
			hasActive = false;
		return hasActive;
	}
	
	public void initRace() {
		for(Airplane plane : airplanes) {
			plane.initRace(this, start, finish);
		}
		for(Helicopter plane : helicopters) {
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
			for(Helicopter plane : helicopters){
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
				if(finished.get(i) instanceof Helicopter)System.out.println("#" + (i + 1) + ":  " +((Helicopter) finished.get(i)).getName());
			}
		}
	
}
