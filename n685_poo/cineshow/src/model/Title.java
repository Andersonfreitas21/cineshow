package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Title {
    private String name;
    private int releaseYear;
    private boolean includedInThePlan;
    private double sumOfRatings;
    private int totalRatings;
    private int durationInMinutes;

    public Title(String name) {
        this.name = name;
    }

    public Title(String name, int releaseYear, int durationInMinutes) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.durationInMinutes = durationInMinutes;
    }



    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isIncludedInThePlan() {
        return includedInThePlan;
    }

    public void setIncludedInThePlan(boolean includedInThePlan) {
        this.includedInThePlan = includedInThePlan;
    }

    public double getSumOfRatings() {
        return sumOfRatings;
    }

    public void setSumOfRatings(double sumOfRatings) {
        this.sumOfRatings = sumOfRatings;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void exibeFichaTecnica(){
        System.out.println("Film's name: " + name);
        System.out.println("Release year: " + releaseYear);
    }

    public void value(double nota){
        sumOfRatings += nota;
        totalRatings++;
    }

    public double getAverage() {
        double d = sumOfRatings / totalRatings;
        BigDecimal bd = new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN);
        return bd.doubleValue();
    }

    @Override
    public String toString() {
        return " name=" + name +
                ", releaseYear=" + releaseYear +
                ", totalRatings=" + totalRatings +
                ", durationInMinutes=" + durationInMinutes +
                ", ";
    }
}
