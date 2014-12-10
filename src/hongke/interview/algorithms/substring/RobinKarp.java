package hongke.interview.algorithms.substring;

/**
 * Created by hongke on 12/6/14.
 */
public class RobinKarp {

    private static final long SEED = 997L;

    private static final int R = 256;

    private final int patternLength;

    private final long patternHash;

    RobinKarp(String pattern) {
        long hash = 0;
        for (char c : pattern.toCharArray()) {
            hash = (hash * R + c) % SEED;
        }
        patternHash = hash;
        patternLength = pattern.length();
    }

    int search(String text) {
        long hash = 0;
        int index = 0;
        for (char c : text.toCharArray()) {
            hash = (hash * R + c) % SEED;
            if (hash == patternHash) {
                return index - patternLength;
            }
            index ++;
        }
        return -1;
    }
}
