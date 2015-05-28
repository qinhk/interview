package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.Interval;

import java.util.*;

/**
 * Created by hongke on 9/4/14.
 */
public class MergeInterval {
    public List<Interval> merge1(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<Interval>();
        if (intervals == null || intervals.isEmpty()) {
            return merged;
        }

        Map<Integer, List<Interval>> sorted = new TreeMap<Integer, List<Interval>>();
        for (Interval i : intervals) {
            if (!sorted.containsKey(i.start)) {
                sorted.put(i.start, new ArrayList<Interval>());
            }
            sorted.get(i.start).add(i);
        }

        Interval prev = null;
        for (List<Interval> list : sorted.values()) {
            for (Interval i : list) {
                if (prev != null) {
                    if (i.start <= prev.end) {
                        prev.end = Math.max(i.end, prev.end);
                        continue;
                    }
                    merged.add(prev);
                }

                prev = i;
            }
        }

        if (prev != null) {
            merged.add(prev);
        }
        return merged;
    }


    private final class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval  a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return merged;

        PriorityQueue<Interval> sorted = new PriorityQueue<Interval>(intervals.size(), new IntervalComparator());
        sorted.addAll(intervals);
        Interval pre = sorted.poll();
        while (!sorted.isEmpty()) {
            Interval interval = sorted.poll();
            if (pre.end >= interval.start) {
                pre.end = Math.max(pre.end, interval.end);
            } else {
                merged.add(pre);
                pre = interval;
            }
        }
        if (pre != null)
            merged.add(pre);
        return merged;
    }

    public static void main(String[] args) {
        MergeInterval test = new MergeInterval();
        System.out.println(test.merge(Arrays.asList(new Interval[] {new Interval(2, 3), new Interval(5, 5), new Interval(2, 2), new Interval(3, 4), new Interval(3, 4)})));
    }
}
