/**
 * this class represent the RaceBuilder with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package factory;

import game.arenas.Arena;
import game.racers.Racer;
import utilities.EnumContainer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RaceBuilder {

    private static RaceBuilder instance;
    //Singleton
    public static RaceBuilder getInstance() {
        if (instance == null) {
            instance = new RaceBuilder();
        }
        return instance;
    }

    /**
     * java reflection
     * buildArena
     * @param arenaType
     * @param length
     * @param maxRacers
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public Arena buildArena(String arenaType, double length, int maxRacers) throws ClassNotFoundException,NoSuchMethodException,SecurityException,
            InstantiationException,IllegalAccessException,IllegalArgumentException,InvocationTargetException
    {
        Class c;
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        c=cl.loadClass(arenaType);
        Constructor con=c.getConstructor(double.class,int.class);
        return (Arena)con.newInstance(length,maxRacers);
    }

    /**
     * java reflection
     * buildRacer
     * @param racerType
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public Racer buildRacer(String racerType, String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color)throws ClassNotFoundException,NoSuchMethodException,SecurityException,
            InstantiationException,IllegalAccessException,IllegalArgumentException,InvocationTargetException
    {
        Class c;
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        c=cl.loadClass(racerType);
        Constructor con=c.getConstructor(String.class,double.class,double.class,EnumContainer.Color.class);
        return (Racer) con.newInstance(name,maxSpeed,acceleration,color);
    }

    /**
     * java reflection
     * buildWheeledRacer
     * @param racerType
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @param numOfWheels
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public Racer buildWheeledRacer(String racerType, String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color, int numOfWheels)throws ClassNotFoundException,NoSuchMethodException,SecurityException,
            InstantiationException,IllegalAccessException,IllegalArgumentException,InvocationTargetException
    {
        Class c;
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        c=cl.loadClass(racerType);
        Constructor con=c.getConstructor(String.class,double.class,double.class,EnumContainer.Color.class,int.class);
        return (Racer) con.newInstance(name,maxSpeed,acceleration,color,numOfWheels);
    }
}
