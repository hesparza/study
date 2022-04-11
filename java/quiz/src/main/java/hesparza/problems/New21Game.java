package hesparza.problems;

import hesparza.util.Combinations;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class New21Game {
    public void run() {
//        System.out.println(new21Game(10, 1, 10));
//        System.out.println(new21Game(6, 1, 10));
//        System.out.println(new21Game(21, 17, 10));
//        generate(11, 2).forEach(a -> System.out.println(Arrays.toString(a)));
          System.out.println(getCustomCombinations(10, 2, 21, 17));
//          System.out.println(splitNumber(10, 10));
    }


    private double new21Game(int n, int k, int maxPts) {
        int z = (int)Math.floor((k/maxPts) + 1);
        int y = n <= maxPts ? n : maxPts;
        double pz = 0.0;
        double pn = 0.0;
        final List<Integer> range = getRange(maxPts);
        Combinations combinations = new Combinations();
        while(z <= k && z < 7) {
            pz = 1/Math.pow(maxPts, z);
//            List<List<Integer>> listCombinations = getCombinations(n, z);
//
//            List<List<Integer>> filtered = listCombinations.stream().filter(a -> a.stream().limit(a.size()-1).reduce(0, (sum, curr) -> sum + curr) < k)
//                    .filter(a -> a.stream().reduce(0, (sum, curr) -> sum + curr) <= n)
//                    .filter(a -> a.stream().reduce(0, (sum, curr) -> sum + curr) >= k).collect(Collectors.toList());
//            Set<List<Integer>> unique = new HashSet(filtered);
//            System.out.println("Total complying: " + unique.size());
//            unique.stream().forEach(a -> System.out.println(Arrays.toString(a.stream().toArray(Integer[]::new))));
//
//            pn += pz * unique.size();
//            z++;
        }
        return pn;
    }

    private List<Integer> getRange(int maxPts) {
        final List<Integer> range = new LinkedList<>();
        for (int i = 1; i <= maxPts; i++) {
            range.add(i);
        }
        return range;
    }
    private Integer[] getSampleSpace(List<Integer> range, int z) {
        final List<Integer> sampleSpace = new LinkedList<>();
        for (int i = 0; i < z; i ++) {
            sampleSpace.addAll(range);
        }
        return sampleSpace.stream().toArray(Integer[]::new);
    }
    private List<List<Integer>> getCustomCombinations(int rangeTop, int slots,int n, int k) {
        List<Integer> initialCombination = new ArrayList<>();
        int firstSlotValue = 1;
        initialCombination.add(firstSlotValue);
        for (int i = 1; i + 2 < slots; i++) {
            initialCombination.add(1);
        }
        List<List<Integer>> combinations =  new LinkedList<>();
        for (int i = 1; i <= rangeTop; i++) {
            int currSum = initialCombination.stream().reduce(0, (sum, element) -> sum + element);
            List<List<Integer>> splitPair = splitNumber(k - currSum, rangeTop);
            if (splitPair.isEmpty()) {
                break;
            }
            splitPair.forEach( a -> combinations.add(Stream.concat(initialCombination.stream(), a.stream()).collect(Collectors.toList())));
            firstSlotValue++;
            initialCombination.clear();
            initialCombination.add(firstSlotValue);
            for (int j = 1; j + 2 < slots; j++) {
                initialCombination.add(1);
            }
        }
        Set<List<Integer>> uniqueCombinations = new HashSet();
        combinations.stream().forEach(a-> { Collections.sort(a); uniqueCombinations.add(a);});
        System.out.println("Size: " + uniqueCombinations.size());
        System.out.println(" dedup  " + uniqueCombinations);
        System.out.println();
        combinations.clear();
        combinations.addAll(uniqueCombinations);
        return combinations;
    }


    private List<List<Integer>> splitNumber(int number, int limit) {
        List<List<Integer>> results = new LinkedList<>();
        int b = number/2;
        int a = number%2 == 0 ? b : b + 1;
        while (true) {
            if (b > limit || a <= 0) {
                break;
            }
            results.add(Arrays.asList(a,b));
            a--;
            b++;
        }
        return results;
    }

    public List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];

        // initialize with lowest lexicographic combination
        for (int i = 0; i < r; i++) {
            combination[i] = i+1;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());

            // generate next combination in lexicographic order
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }

        return combinations;
    }

    private List<List<Integer>> helper(List<Integer> n, int k, Integer element) {
        List<List<Integer>> result = new LinkedList<>();
        n.forEach(a -> result.add(Arrays.asList(element, a)));
        return result;
    }
}
