package hongke.interview.leetcode.common;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by hongke on 9/12/14.
 */
public class MaxPointsOnALine {
    public int maxPoints1(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Map<String, List<int[]>> lines = new HashMap<String, List<int[]>>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int deltaX = points[j].x - points[i].x;
                int deltaY = points[j].y - points[i].y;
                int gcd = BigInteger.valueOf(deltaY).gcd(BigInteger.valueOf(deltaX)).intValue();
                if (deltaX < 0) {
                    deltaX = -deltaX;
                    deltaY = -deltaY;
                }
                String key = deltaX != 0 ? String.valueOf(deltaY / gcd) + "/" + String.valueOf(deltaX / gcd) : "INF";
                if (!lines.containsKey(key)) {
                    lines.put(key, new ArrayList<int[]>());
                }
                lines.get(key).add(new int[]{i, j});

            }
        }

        int longest = 1;
        for (Map.Entry<String, List<int[]>> entry : lines.entrySet()) {
            List<List<Integer>> merged = new ArrayList<List<Integer>>();
            for (int[] shortLine : entry.getValue()) {
                boolean added = false;
                for (List<Integer> line : merged) {
                    if (line.contains(shortLine[0]) && !line.contains(shortLine[1])) {
                        line.add(shortLine[1]);
                        longest = Math.max(line.size(), longest);
                        added = true;
                        break;
                    } else if (line.contains(shortLine[1]) && !line.contains(shortLine[0])) {
                        line.add(shortLine[0]);
                        longest = Math.max(line.size(), longest);
                        added = true;
                        break;
                    } else if (line.contains(shortLine[1]) && line.contains(shortLine[0])) {
                        added = true;
                    }
                }
                if (!added) {
                    List<Integer> line = new ArrayList<Integer>();
                    line.add(shortLine[0]);
                    line.add(shortLine[1]);
                    merged.add(line);
                    longest = Math.max(longest, line.size());
                }
            }
        }

        return longest;
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        } else if (points.length == 1) {
            return 1;
        }

        int max = 1;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> cache = new HashMap<String, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                Point p1 = points[i], p2 = points[j];
                String slop = getSlop(p1, p2);
                if (!cache.containsKey(slop)) {
                    cache.put(slop, 1);
                } else {
                    cache.put(slop, cache.get(slop) + 1);
                    int dup = cache.containsKey("DUP") ? cache.get("DUP") : 0;
                    dup = slop.equals("DUP") ? 0 : dup;
                    max = Math.max(max, cache.get(slop) + dup);
                }
            }
        }
        return max + 1;
    }

    private String getSlop(Point p1, Point p2) {
        int deltaX = p1.x - p2.x, deltaY = p1.y - p2.y;
        String slop;
        if (deltaX == 0 && deltaY == 0) {
            slop = "DUP";
        } else if (deltaX == 0) {
            slop = "INF";
        } else if (deltaY == 0) {
            slop = "0";
        } else {
            slop = String.valueOf(Double.valueOf(deltaY) / Double.valueOf(deltaX));
        }
        return slop;
    }

    public static void main(String[] args) {
        MaxPointsOnALine test = new MaxPointsOnALine();
        System.out.println(test.maxPoints(new Point[]{new Point(3, 10), new Point(3, 10)}));
        System.out.println(test.maxPoints(new Point[]{new Point(3, 10), new Point(3, 10), new Point(3, 10)}));
        System.out.println(test.maxPoints(new Point[]{new Point(3, 10), new Point(0, 2), new Point(0, 2), new Point(3, 10)}));
        System.out.println(System.currentTimeMillis());
        System.out.println(test.maxPoints(new Point[]{new Point(29, 87), new Point(145, 227), new Point(400, 84), new Point(800, 179), new Point(60, 950), new Point(560, 122), new Point(-6, 5), new Point(-87, -53), new Point(-64, -118), new Point(-204, -388), new Point(720, 160), new Point(-232, -228), new Point(-72, -135), new Point(-102, -163), new Point(-68, -88), new Point(-116, -95), new Point(-34, -13), new Point(170, 437), new Point(40, 103), new Point(0, -38), new Point(-10, -7), new Point(-36, -114), new Point(238, 587), new Point(-340, -140), new Point(-7, 2), new Point(36, 586), new Point(60, 950), new Point(-42, -597), new Point(-4, -6), new Point(0, 18), new Point(36, 586), new Point(18, 0), new Point(-720, -182), new Point(240, 46), new Point(5, -6), new Point(261, 367), new Point(-203, -193), new Point(240, 46), new Point(400, 84), new Point(72, 114), new Point(0, 62), new Point(-42, -597), new Point(-170, -76), new Point(-174, -158), new Point(68, 212), new Point(-480, -125), new Point(5, -6), new Point(0, -38), new Point(174, 262), new Point(34, 137), new Point(-232, -187), new Point(-232, -228), new Point(232, 332), new Point(-64, -118), new Point(-240, -68), new Point(272, 662), new Point(-40, -67), new Point(203, 158), new Point(-203, -164), new Point(272, 662), new Point(56, 137), new Point(4, -1), new Point(-18, -233), new Point(240, 46), new Point(-3, 2), new Point(640, 141), new Point(-480, -125), new Point(-29, 17), new Point(-64, -118), new Point(800, 179), new Point(-56, -101), new Point(36, 586), new Point(-64, -118), new Point(-87, -53), new Point(-29, 17), new Point(320, 65), new Point(7, 5), new Point(40, 103), new Point(136, 362), new Point(-320, -87), new Point(-5, 5), new Point(-340, -688), new Point(-232, -228), new Point(9, 1), new Point(-27, -95), new Point(7, -5), new Point(58, 122), new Point(48, 120), new Point(8, 35), new Point(-272, -538), new Point(34, 137), new Point(-800, -201), new Point(-68, -88), new Point(29, 87), new Point(160, 27), new Point(72, 171), new Point(261, 367), new Point(-56, -101), new Point(-9, -2), new Point(0, 52), new Point(-6, -7), new Point(170, 437), new Point(-261, -210), new Point(-48, -84), new Point(-63, -171), new Point(-24, -33), new Point(-68, -88), new Point(-204, -388), new Point(40, 103), new Point(34, 137), new Point(-204, -388), new Point(-400, -106)}));
        System.out.println(System.currentTimeMillis());
    }
}
