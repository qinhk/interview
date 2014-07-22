package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hongke on 7/17/14.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        if (L == 0 || words == null || words.length == 0) {
            return Arrays.asList(new String[]{""});
        }

        for (String s : words) {
            if (s.length() > L) {
                return Arrays.asList(new String[]{""});
            }
        }

        int wordCount = 0;
        List<String> result = new ArrayList<String>();
        while (words.length > wordCount) {
            int lineLength = 0;
            List<StringBuilder> sbs = new ArrayList<StringBuilder>();
            while (lineLength < L) {
                if (wordCount < words.length && lineLength + words[wordCount].length() + sbs.size() - 1 < L) {
                    lineLength += words[wordCount].length();
                    sbs.add(new StringBuilder(words[wordCount]));
                    wordCount++;
                } else if (wordCount == words.length) {
                    for (int i = 0; i < sbs.size() - 1; i++) {
                        sbs.get(i).append(' ');
                        lineLength++;
                    }
                    for (; lineLength < L; lineLength++) {
                        sbs.get(sbs.size() - 1).append(' ');
                    }
                } else {
                    int spaceCount = L - lineLength;
                    for (int i = 0; i < spaceCount; i++) {
                        int slot = sbs.size() > 1 ? i % (sbs.size() - 1) : 0;
                        sbs.get(slot).append(' ');
                        lineLength++;
                    }
                }
            }
            for (int i = 1; i < sbs.size(); i++) {
                sbs.get(0).append(sbs.get(i));
            }
            result.add(sbs.get(0).toString());
        }
        return result;
    }

    public static void main(String[] args) {
        TextJustification test = new TextJustification();
        List<String> result = test.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "12345678901", "justification."}, 16);
        for (String s : result) {
            System.out.println("\"" + s + "\"");
        }
    }
}
