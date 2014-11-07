package hongke.interview.algorithms.dp.model;

/**
 * Created by hongke on 11/5/14.
 */
public class Box {
    public int l;
    public int w;
    public int h;

    public Box(int l, int w, int h) {
        if (l <= 0 || w <= 0 || h <= 0) {
            throw new IllegalArgumentException("Invalid box!");
        }
        this.l = l;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Box{" +
                "l=" + l +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}
