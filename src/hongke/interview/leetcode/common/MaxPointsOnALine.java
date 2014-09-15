package hongke.interview.leetcode.common;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by hongke on 9/12/14.
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
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
                if (!lines.containsKey(key) ) {
                    lines.put(key, new ArrayList<int[]>());
                }
                lines.get(key).add(new int[]{i,j});

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

    public static void main(String[] args) {
        MaxPointsOnALine test = new MaxPointsOnALine();
        System.out.println(test.maxPoints(new Point[] {new Point(3, 10), new Point(0, 2), new Point(0, 2), new Point(3, 10)}));
    }
}
