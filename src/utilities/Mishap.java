/**
 * this class represent the Mishap with all needed components
 * @version 29.42018
 * @author Eliran gabay 203062831
 */
package utilities;

import java.text.DecimalFormat;

public class Mishap {

    private boolean fixable;
    private double reductionFactor;
    private int turnsToFix;

    /**
     * this constructs a Mishap
     * @param fixable
     * @param turnsToFix
     * @param reductionFactor
     */
    public Mishap(boolean fixable, int turnsToFix, double reductionFactor)
    {
        this.setFixable(fixable);
        this.setTurnsToFix(turnsToFix);
        this.setReductionFactor(reductionFactor);
    }

    public void nextTurn() { if(this.isFixable()){this.setTurnsToFix(this.getTurnsToFix()-1);} }

    @Override
    public String toString()
    {
        DecimalFormat a= new DecimalFormat("0.00");
        return "("+this.isFixable()+", "+this.getTurnsToFix()+" ,"+ a.format(reductionFactor) +")";
    }

    //Getter and Setter
    public boolean isFixable() {
        return fixable;
    }

    public void setFixable(boolean fixable) {
        this.fixable = fixable;
    }

    public double getReductionFactor() {
        return reductionFactor;
    }

    public void setReductionFactor(double reductionFactor) {
        this.reductionFactor = reductionFactor;
    }

    public int getTurnsToFix() {
        return turnsToFix;
    }

    public void setTurnsToFix(int turnsToFix) {
        this.turnsToFix = turnsToFix;
    }
}
