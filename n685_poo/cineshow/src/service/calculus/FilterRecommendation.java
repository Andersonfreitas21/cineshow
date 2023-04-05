package service.calculus;

public class FilterRecommendation {

    private String recommendation;
    public void filters(Sortable sortable) {
        if (sortable.getRating() >= 4) {
            System.out.println("It is among the favorites of the moment");
        } else if (sortable.getRating() >= 2) {
            System.out.println("Very highly rated at the moment!");
        } else {
            System.out.println("Put it on your list to watch later");
        }
    }
}
