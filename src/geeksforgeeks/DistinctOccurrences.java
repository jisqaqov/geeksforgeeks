package geeksforgeeks;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: Distinct occurrences
 * algorithm: DP
 * time complexity:
 * space complexity:
 */
public class DistinctOccurrences {

    public static void main (String[] args) {
        DistinctOccurrences solution = new DistinctOccurrences();
        solution.test();
    }

    private void test() {
        System.out.println(subsequenceCount("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco", "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxp"));
        System.out.println(subsequenceCount("banana", "ban"));
        System.out.println(subsequenceCount("geeksforgeeks", "ge"));
    }

    int subsequenceCount(String s, String t) {
        Map<Character, Set<Integer>> indexes = new HashMap<>();
        for (int i = t.length() - 1; i >= 0; i--) {
            indexes.putIfAbsent(t.charAt(i), new LinkedHashSet<>());

            indexes.get(t.charAt(i)).add(i + 1);
        }

        Map<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!indexes.containsKey(ch)) {
                continue;
            }

            for (int len : indexes.get(ch)) {
                if (counter.containsKey(len - 1)) {
                    counter.put(len, counter.get(len - 1) + counter.getOrDefault(len, 0));
                } else if (len == 1) {
                    counter.put(len, counter.getOrDefault(len, 0) + 1);
                }
            }
        }

        return counter.get(t.length());
    }

}
