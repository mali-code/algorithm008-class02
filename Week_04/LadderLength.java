package week4;

import javafx.util.Pair;

import java.util.*;

public class LadderLength {

    //官网给大答案有问题
    public int ladderLength(String beginWord, String endWord, List<String> worldList) {
        int L = worldList.size();
        Map<String, List<String>> allComboDict = new HashMap<>();
        worldList.forEach(world -> {
            for (int i = 0; i < L; i++) {
                String newWord = world.substring(0, i) + "*" + world.substring(i + 1, L);
                List<String> orDefault = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                orDefault.add(world);
                allComboDict.put(newWord, orDefault);
            }
        });

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String world = node.getKey();
            Integer levle = node.getValue();
            for (int i = 0; i < L; i++) {
                String newworld = world.substring(0, i) + "*" + world.substring(i + 1, L);
                List<String> orDefault = allComboDict.getOrDefault(newworld, new ArrayList<>());
                for (String s : orDefault) {
                    if (s.equals(endWord)) {
                        return levle + 1;
                    }

                    if (!visited.containsKey(s)) {
                        visited.put(s, true);
                        queue.add(new Pair<>(s, levle + 1));
                    }
                }


            }


        }
        return 0;
    }


}
