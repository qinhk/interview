package hongke.interview.leetcode.questions;
//
//import java.util.*;
//
///**
// * Created by hongke on 4/5/14.
// */
//@SuppressWarnings("unused")
//public class KSum {
//
//    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
//        return kSum(num, 3, 1);
//    }
//
//    public ArrayList<ArrayList<Integer>> fourSum(int[] num) {
//        return kSum(num, 4, 1);
//    }
//
//    private ArrayList<ArrayList<Integer>> kSum(int[] num, int k,
//                                               int cacheLevel) {
//        if (num == null || num.length < k) {
//            return new ArrayList<ArrayList<Integer>>();
//        }
//
//        if (k > 2) {
//            Arrays.sort(num);
//        }
//
//
//        HashMap<Integer, ArrayList<ArrayList<Integer>> numbers = buildCache
//                (num,
//                cacheLevel);
//        Set<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();
//
//        int loopLevel = k - cacheLevel;
//        int[] indexes = new int[loopLevel];
//
//        while(moveForward(indexes, k, cacheLevel)) {
//            int partialSum = 0;
//            for (int i = 0; i < indexes.length; i++) {
//                partialSum += num[indexes[i]];
//            }
//
//            if (numbers.get(0 - partialSum) != null) {
//                ArrayList<Integer> subSet = new ArrayList<Integer>();
//                for (Integer index : indexes) {
//                    subSet.add(index);
//                }
//
//                for (List<Integer> cached : numbers.get(0 - partialSum))
//                for (Integer index : indexes) {
//                    subSet.add(index);
//                }
//
//            }
//        }
//
//        for (int i = 0; i < num.length; i++) {
//            for (int j = i + 1; j < num.length; j++) {
//                Integer k = 0 - num[i] - num[j];
//                if (i != j && numbers.get(k) != null) {
//                    ArrayList<Integer> index = numbers.get(k);
//                    int indexK = index.get(index.size() - 1);
//                    if (indexK <= j) {
//                        continue;
//                    }
//                    ArrayList<Integer> triple = new ArrayList<Integer>();
//                    triple.add(num[i]);
//                    triple.add(num[j]);
//                    triple.add(k);
//                    results.add(triple);
//                }
//            }
//        }
//
//        return new ArrayList<ArrayList<Integer>>(results);
//
//
//    }
//
//    private boolean moveForward(int[] indexes, int k, int cacheLevel) {
//    }
//
//    private HashMap<Integer, ArrayList<ArrayList<Integer>> buildCache(int[]
//                                                                              num,
//                                                            int cacheLevel) {
//        HashMap<Integer, ArrayList<Integer>> numbers = new HashMap<Integer,
//                ArrayList<Integer>>();
//        for (int i = 0; i < num.length; i++) {
//            if (numbers.get(num[i]) == null) {
//                numbers.put(num[i], new ArrayList<Integer>());
//            }
//            numbers.get(num[i]).add(i);
//        }Long.to
//        return numbers;
//    }
//
//    public static void main(String[] args) {
//        int[] test = new int[]{7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9,
//                11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6};
//        KSum s = new KSum();
//        long start = System.currentTimeMillis();
//        List solution = s.threeSum(test);
//        System.out.println(solution);
//        long end = System.currentTimeMillis();
//        System.out.println("Size of input:" + test.length + ", " +
//                "Size of solution:" + solution.size() +
//                ", Start:" + start + ", " +
//                "End:" + end + ", " +
//                "Time:" + (end - start) + "ms");
//    }
//}

import java.util.*;

public class KSum {
    public List<List<Integer>> fourSum1(int[] num, int target) {
        if (num == null) {
            return new ArrayList<List<Integer>>();
        }
        // value to index mapping
        Map<Long, List<List<Integer>>> cache = buildCache(num);

        // value to number mapping
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        for (Map.Entry<Long, List<List<Integer>>> entry : cache.entrySet()) {
            Long val = (long) target - entry.getKey();
            if (cache.get(val) != null) {
                for (List<Integer> index1 : cache.get(val)) {
                    for (List<Integer> index2 : entry.getValue()) {
                        if (Collections.disjoint(index2, index1)) {
                            ArrayList<Integer> subset = new ArrayList<Integer>();
                            subset.addAll(index2);
                            subset.addAll(index1);

                            // index to number transform
                            result.add(transform(subset, num));
                        }
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }

    private Map<Long, List<List<Integer>>> buildCache(int[] num) {
        Map<Long, List<List<Integer>>> cache = new HashMap<Long,
                List<List<Integer>>>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                Long val = (long) num[i] + (long) num[j];
                if (cache.get(val) == null) {
                    cache.put(val, new ArrayList<List<Integer>>());
                }
                List<Integer> index = new ArrayList<Integer>();
                index.add(i);
                index.add(j);
                cache.get(val).add(index);
            }
        }
        return cache;
    }

    private ArrayList<Integer> transform(List<Integer> indexes, int[] num) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer index : indexes) {
            result.add(num[index]);
        }
        Collections.sort(result);
        return result;
    }

    public List<List<Integer>> fourSum2(int[] num, int target) {
        if (num == null || num.length < 4) {
            return new ArrayList<List<Integer>>();
        }

        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Map<Integer, List<List<Integer>>> cache = new HashMap<Integer, List<List<Integer>>>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int key = num[i] + num[j];
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(i);
                pair.add(j);
                if (!cache.isEmpty() && cache.containsKey(target - key)) {
                    for (List<Integer> partial : cache.get(target - key)) {
                        if (partial.contains(i) || partial.contains(j))
                            continue;

                        result.add(getGroup(num, partial, pair));
                    }
                }
                if (!cache.containsKey(key)) {
                    cache.put(key, new ArrayList<List<Integer>>());
                }
                cache.get(key).add(pair);
            }
        }
        return new ArrayList<List<Integer>>(result);
    }

    private List<Integer> getGroup(int[] num, List<Integer>... partial) {
        List<Integer> group = new ArrayList<Integer>();
        for (List<Integer> list : partial) {
            for (Integer i : list) {
                group.add(num[i]);
            }
        }
        Collections.sort(group);
        return group;
    }

    public List<List<Integer>> fourSum(int[] num, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        if (num == null) {
            return new ArrayList(result);
        }

        Map<Integer, List<List<Integer>>> sums = buildMap(num);

        List<Integer> keys = new ArrayList(sums.keySet());
        for (int sum : keys) {
            int remain = target - sum;
            if (sums.containsKey(remain)) {
                List<List<Integer>> first = sums.get(sum);
                List<List<Integer>> second = sums.get(remain);
                result.addAll(getGroups(first, second, num));
            }
        }
        return new ArrayList(result);
    }

    private Map<Integer, List<List<Integer>>> buildMap(int[] num) {
        Map<Integer, List<List<Integer>>> sums = new TreeMap();
        for (int i = 0; i < num.length - 1; i ++) {
            for (int j = i + 1; j < num.length; j ++) {
                if (!sums.containsKey(num[i] + num[j])) {
                    sums.put(num[i] + num[j], new ArrayList());
                }
                sums.get(num[i] + num[j]).add(Arrays.asList(new Integer[]{i, j}));
            }
        }
        return sums;
    }

    private List<List<Integer>> getGroups(List<List<Integer>> first, List<List<Integer>> second, int[] nums) {
        List<List<Integer>> groups = new ArrayList<List<Integer>>();
        for (int i = 0; i < first.size(); i ++) {
            for (int j = 0; j < second.size(); j ++) {
                Set<Integer> set = new HashSet<Integer>();
                set.addAll(first.get(i));
                set.addAll(second.get(j));
                if (set.size() == 4) {
                    List<Integer> group = new ArrayList();
                    for (int  index : set) {
                        group.add(nums[index]);
                    }
                    Collections.sort(group);
                    groups.add(group);
                }
            }
        }
        return groups;
    }


    public static void main(String[] args) {
        int[] t1 = new int[]{91277418, 66271374, 38763793, 4092006, 11415077,
                60468277,
                1122637, 72398035, -62267800, 22082642, 60359529, -16540633, 92671879, -64462734, -55855043, -40899846, 88007957, -57387813, -49552230, -96789394, 18318594, -3246760, -44346548, -21370279, 42493875, 25185969, 83216261, -70078020, -53687927, -76072023, -65863359, -61708176, -29175835, 85675811, -80575807, -92211746, 44755622, -23368379, 23619674, -749263, -40707953, -68966953, 72694581, -52328726, -78618474, 40958224, -2921736, -55902268, -74278762, 63342010, 29076029, 58781716, 56045007, -67966567, -79405127, -45778231, -47167435, 1586413, -58822903, -51277270, 87348634, -86955956, -47418266, 74884315, -36952674, -29067969, -98812826, -44893101, -22516153, -34522513, 34091871, -79583480, 47562301, 6154068, 87601405, -48859327, -2183204, 17736781, 31189878, -23814871, -35880166, 39204002, 93248899, -42067196, -49473145, -75235452, -61923200, 64824322, -88505198, 20903451, -80926102, 56089387, -58094433, 37743524, -71480010, -14975982, 19473982, 47085913, -90793462, -33520678, 70775566, -76347995, -16091435, 94700640, 17183454, 85735982, 90399615, -86251609, -68167910, -95327478, 90586275, -99524469, 16999817, 27815883, -88279865, 53092631, 75125438, 44270568, -23129316, -846252, -59608044, 90938699, 80923976, 3534451, 6218186, 41256179, -9165388, -11897463, 92423776, -38991231, -6082654, 92275443, 74040861, 77457712, -80549965, -42515693, 69918944, -95198414, 15677446, -52451179, -50111167, -23732840, 39520751, -90474508, -27860023, 65164540, 26582346, -20183515, 99018741, -2826130, -28461563, -24759460, -83828963, -1739800, 71207113, 26434787, 52931083, -33111208, 38314304, -29429107, -5567826, -5149750, 9582750, 85289753, 75490866, -93202942, -85974081, 7365682, -42953023, 21825824, 68329208, -87994788, 3460985, 18744871, -49724457, -12982362, -47800372, 39958829, -95981751, -71017359, -18397211, 27941418, -34699076, 74174334, 96928957, 44328607, 49293516, -39034828, 5945763, -47046163, 10986423, 63478877, 30677010, -21202664, -86235407, 3164123, 8956697, -9003909, -18929014, -73824245};
        KSum s = new KSum();
        long start = System.currentTimeMillis();
        List<List<Integer>> solution = s.fourSum2(t1, -236727523);
        System.out.println(solution);
        long end = System.currentTimeMillis();
        System.out.println("Size of input:" + t1.length + ", " +
                "Size of solution:" + solution.size() +
                " Time:" + (end - start) + "ms");
    }
}
