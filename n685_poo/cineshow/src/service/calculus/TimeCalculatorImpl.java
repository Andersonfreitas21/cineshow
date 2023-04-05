package service.calculus;

import model.Title;

public class TimeCalculatorImpl extends TimeCalculator {
    @Override
    public void include(Title title) {
        System.out.println("Adding duration in minutes of " + title);
        this.setTotalTime(title.getDurationInMinutes());
    }
}
