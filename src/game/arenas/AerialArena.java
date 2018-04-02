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

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getFinish() {
		return finish;
	}

	public void setFinish(Point finish) {
		this.finish = finish;
	}

	//Airplane
	public boolean addAirplane(Airplane airplane) {
		for(Airplane plane : airplanes)
		{
			if (plane.getName().equals(airplane.getName()))//if the airplain name exist return flase
			{
				return false;
			}
		}
		if(airplanes.size()+helicopters.size()>=MAX_RACERS)return false;//make sure the number of airplains and helicopters didnt exceed the max num of racers
		airplanes.add(airplane);//add to array
		return true;
	}

	//Helicopter
	public boolean addHelicopters(Helicopter helicopter) {
		for(Helicopter plane : helicopters)
		{
			if (plane.getName().equals(helicopter.getName()))//if the Helicopter name exist return flase
			{
				return false;
			}
		}
		if(airplanes.size()+helicopters.size()>=MAX_RACERS)return false;//make sure the number of airplains and helicopters didnt exceed the max num of racers
		helicopters.add(helicopter);//add to array
		return true;
	}

	//Airplane
	public int crossFinishLine(Airplane airplane) {// adds racer to finished, returns his place
		for(Object player :finished)
		{
			if(player.equals(airplane))return finished.size();
		}
		finished.add(airplane);
		return finished.size(); //return array size and Airplane position
	}

	//Helicopter
	public int crossFinishLine(Helicopter helicopter) {// adds racer to finished, returns his place
		for(Object player :finished)
		{
			if(player.equals(helicopter))return finished.size();
		}
		finished.add(helicopter);
		return finished.size(); //return array size and Helicopter position
	}
	
	public boolean hasActiveRacers() {
		boolean hasActive = true;
		if (finished.size()==airplanes.size()+helicopters.size())
			hasActive = false;
		return hasActive;// returns if there are active racers

	}
	
	public void initRace() {// init each racer
		for(Airplane plane : airplanes) {
			plane.initRace(this, start, finish);
		}
		for(Helicopter plane : helicopters) {
			plane.initRace(this, start, finish);
		}
	}
	
	public void playTurn() {// signal each racer to make a move, remove finished racers
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
	
	public void printWinners() {//print the winners
		for(int i=0; i<finished.size();i++) {
				System.out.println("#" + (i + 1) + ":  " +(finished.get(i)));
			}
		}
	
}
