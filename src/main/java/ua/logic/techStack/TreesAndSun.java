package ua.logic.techStack;

import java.util.ArrayList;
import java.util.List;

//The Sun is on the left
//What high-rise buildings will be visible
public class TreesAndSun {
    List<Integer> getSunnyTrees(List<Integer> trees) {
        int highestTree = 0;

        List<Integer> result = new ArrayList<>();
        if (trees.isEmpty()) {
            return result;
        }

        for (int i = 0; i < trees.size(); i++) {
            if(trees.get(i) > highestTree) {
                highestTree = trees.get(i);
                result.add(i);
            }
        }

        return result;
    }
}
