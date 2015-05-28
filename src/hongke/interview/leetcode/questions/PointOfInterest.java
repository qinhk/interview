package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongke on 2/5/15.
 */
public class PointOfInterest {

    // O(n) quick select solution.
    public List<Point> getNearest(Point[] points, Point current, int k) {
        List<Point> result = new ArrayList<Point>();
        if (points == null || points.length == 0 || current == null || k <= 0) {
            return result;
        }

        kClosest(current, points, k);
        for (int i = 0; i < points.length && result.size() < k; i++) {
                result.add(points[i]);
        }
        return result;
    }

    private Point kClosest(Point current, Point[] points, int k) {
        int l = 0, r = points.length - 1;
        if (k <= 0 || k > r - l + 1)
            return null;
        while (l < r) {
            int pivot = partition(current, points, l, r);
            if (pivot == k - 1)
                break;
            else if (pivot > k - 1)
                r = pivot - 1;
            else
                l = pivot + 1;
        }
        return points[l];
    }

    private int partition(Point current, Point[] points, int l, int r) {
        swap(points, l + (r - l) / 2, r);
        int dist = dist(points[r], current), i = l;
        for (int j = l; j < r; j++) {
            if (dist(points[j], current) < dist) {
                swap(points, i++, j);
            }
        }
        swap(points, i, r);
        return i;
    }

    private void swap(Point[] points, int i, int j) {
        Point t = points[i];
        points[i] = points[j];
        points[j] = t;
    }

    private int dist(Point p1, Point p2) {
        return sq(p1.x - p2.x) + sq(p1.y - p2.y);
    }

    private int sq(int val) {
        return val * val;
    }

    public static void main(String[] args) {
        PointOfInterest poi = new PointOfInterest();
        Point[] points = new Point[]{new Point(5, 5), new Point(5, 4), new Point(4, 5)};
        System.out.println(poi.getNearest(points, new Point(3, 3), 2));

        points = new Point[]{
                new Point(0, 3), new Point(1, 3), new Point(2, 3), new Point(3, 3),
                new Point(0, 2), new Point(1, 2), new Point(2, 2), new Point(3, 2),
                new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1),
                new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0)};
        System.out.println(poi.getNearest(points, new Point(1, 1), 7));


    }
}
