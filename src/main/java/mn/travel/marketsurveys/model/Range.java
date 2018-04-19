package mn.travel.marketsurveys.model;

/**
 * Created by hadrien on 13/04/18.
 */
public class Range {

    private int min;
    private int max;

    public Range() {
    }

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
