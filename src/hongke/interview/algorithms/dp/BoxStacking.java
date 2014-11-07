package hongke.interview.algorithms.dp;

import hongke.interview.algorithms.dp.model.Box;

import java.util.*;

/**
 * Box Stacking. You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i), width w(i)
 * and depth d(i) (all real numbers). You want to create a stack of boxes which is as tall as possible, but you can only
 * stack a box on top of another box if the dimensions of the 2-D base of the lower box are each strictly larger than
 * those of the 2-D base of the higher box. Of course, you can rotate a box so that any side functions as its base. It
 * is also allowable to use multiple instances of the same type of box. Created by hongke on 11/2/14.
 * <p/>
 * Retrun: maximum possible height
 */
public class BoxStacking {

    private List<Box> rotateBox(Box box) {
        Map<String, Box> boxes = new HashMap<String, Box>();
        boxes.put(box.toString(), box);
        Box box1 = new Box(box.h, box.w, box.l);
        boxes.put(box1.toString(), box1);
        Box box2 = new Box(box.h, box.l, box.w);
        boxes.put(box2.toString(), box2);
        return new ArrayList<Box>(boxes.values());
    }

    private boolean preconditions(List<Box> boxes) {
        return boxes != null;
    }

    public int boxStacking(List<Box> boxes) {
        if (!preconditions(boxes)) {
            return -1;
        }

        List<Box> rotatedBoxes = new ArrayList<Box>();
        for (Box box : boxes) {
            rotatedBoxes.addAll(rotateBox(box));
        }

        Collections.sort(rotatedBoxes, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return Integer.compare(o2.l, o1.l);
            }
        });

        return stackBox(rotatedBoxes, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, new HashMap<String, Integer>());
    }

    private String getCacheKey(int index, int l, int w) {
        int length = Math.max(l, w);
        int width = Math.min(l, w);
        return String.valueOf(Arrays.asList(new Integer[]{index, length, width}));
    }

    public int stackBox(List<Box> boxes, int index, int l, int w, Map<String, Integer> cache) {
        String cacheKey = getCacheKey(index, l, w);
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);
        int i = index;
        while (i < boxes.size() && (
                Math.max(boxes.get(i).l, boxes.get(i).w) >= Math.max(l, w)
                        || Math.min(boxes.get(i).l, boxes.get(i).w) >= Math.min(l, w))) {
            i++;
        }

        int height = 0;
        if (i < boxes.size()) {
            Box box = boxes.get(i);
            height = Math.max(stackBox(boxes, index + 1, l, w, cache), box.h + stackBox(boxes, i + 1, box.l, box.w, cache));
        }
        cache.put(cacheKey, height);
        return height;
    }

}
