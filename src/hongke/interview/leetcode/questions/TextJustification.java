package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 7/17/14.
 */
public class TextJustification {
    public List<String> fullJustify1(String[] words, int L) {
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

    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if (words == null || words.length == 0 || L < 0)
            return result;

        Deque<String> line = new ArrayDeque<String>();
        int dryLen = 0;
        for (String w : words) {
            if (line.size() + dryLen + w.length() <= L) {
                line.add(w);
                dryLen += w.length();
            } else {
                int interval = line.size() == 1 ? 0 : (L - dryLen) / (line.size() - 1);
                int spare = L - dryLen - (line.size() - 1) * interval;
                StringBuilder sb = new StringBuilder();
                while(sb.length() < L) {
                    if (line.size() > 0) {
                        sb.append(line.removeFirst());
                    }
                    if (line.size() > 0) {
                        for (int i = 0; i < interval; i ++)
                            sb.append(' ');
                    }
                    if (spare -- > 0) {
                        sb.append(' ');
                    }
                }
                result.add(sb.toString());
                line.add(w);
                dryLen = w.length();
            }
        }
        StringBuilder lastLine = new StringBuilder();
        while(line.size() > 0) {
            lastLine.append(line.removeFirst());
            if (line.size() > 0) {
                lastLine.append(' ');
            }
        }
        if (lastLine.length() > 0)
            result.add(lastLine.toString());
        return result;
    }

    public static void main(String[] args) {
        TextJustification test = new TextJustification();
        List<String> result;
                result = test.fullJustify(new String[] {"a"}, 1);
        for (String s : result) {
            System.out.println("\"" + s + "\"");
        }
        result = test.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "12345678901", "justification."}, 16);
        for (String s : result) {
            System.out.println("\"" + s + "\"");
        }


    }
}
