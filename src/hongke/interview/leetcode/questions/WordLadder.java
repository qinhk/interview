package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 3/26/14.
 */

@SuppressWarnings("unused")
public class WordLadder {

    HashSet<String> dict;

    Integer maxDepth;

    /*
    Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    Return
      [
        ["hit","hot","dot","dog","cog"],
        ["hit","hot","lot","log","cog"]
      ]
    Note:
    All words have the same length.
    All words contain only lowercase alphabetic characters.
     */

    /*
    DFS does not work fast enough!!!
     */
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {

        if (start == null || end == null || dict == null) {
            return null;
        }

        if (start.equals(end)) {
            return new ArrayList<ArrayList<String>>();
        }

        this.dict = dict;
        this.maxDepth = dict.size();
        return bfs(start.trim().toLowerCase(), end.trim().toLowerCase());
    }


    private ArrayList<ArrayList<String>> bfs(String start, String end) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        Stack<String> stack = new Stack<String>();
//        bfsHorizontal(start.trim().toLowerCase(), end.trim().toLowerCase(),                stack,
//                result);

        return result;
    }

    private ArrayList<ArrayList<String>> dfs(String start, String end) {
        ArrayList<ArrayList<String>> result = new
                ArrayList<ArrayList<String>>();

        Stack<String> stack = new Stack<String>();
        dfsHorizontal(start.trim().toLowerCase(), end.trim().toLowerCase(), stack,
                result);

        return result;
    }

    private void dfsHorizontal(String current, String end,
                               Stack<String> stack,
                               ArrayList<ArrayList<String>> results) {

        for (int i = 0; i < current.length(); i++) {
            String next;
            for (char l = 'a'; l <= 'z'; l++) {
                char[] chars = current.toCharArray();
                chars[i] = l;
                next = new String(chars);
                if (dict.contains(next) && !stack.contains(next)) {
                    stack.push(next);
                    dfsVertical(end, stack, results);
                    stack.pop();
                }
            }
        }
    }

    private void dfsVertical(String end,
                             Stack<String> stack,
                             ArrayList<ArrayList<String>> results) {
        if (stack.size() > maxDepth || stack.size() == 0) {
            // skip some useless path
            return;
        } else {
            if (isTheEnd(stack.peek(), end)) {
                // found a valid leaf
                if (stack.size() == maxDepth) {
                    // need to record the stack
                    results.add(new ArrayList(Arrays.asList(stack.toArray())));
                } else {
                    // stack.size() < maxDepth
                    // need to record the stack and delete all previous records
                    // since found a better one.
                    results.clear();
                    results.add(new ArrayList(Arrays.asList(stack.toArray())));

                    // update the known shortestPath.
                    this.maxDepth = new Integer(stack.size());
                }
                return;
            }

            // searching horizontal in the new depth.
            dfsHorizontal(stack.peek(), end, stack, results);

        }
    }

    private void bfsHorizontal(String end, Stack<String> stack,
                               ArrayList<ArrayList<String>> results) {

    }

    private void bfsVertical(String end, Stack<String> stack,
                             ArrayList<ArrayList<String>> results) {

    }

    private boolean isTheEnd(String current, String target) {
        int diffCount = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != target.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        HashSet<String> dict = new HashSet(Arrays.asList(new String[]{"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"}));
        System.out.println(wl.findLadders("cet", "ism", dict));
    }

}
