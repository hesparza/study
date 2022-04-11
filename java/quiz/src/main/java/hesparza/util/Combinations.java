package hesparza.util;


import org.paukov.combinatorics3.Generator;
import org.paukov.combinatorics3.IGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Combinations {

    public void run() {
       getCombinations();
    }

    private void getCombinations() {
        IGenerator<List<Integer>> list =  Generator.combination(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .simple(2);
                list.forEach(System.out::println);
        System.out.println("total combinations: " + list.stream().count());
        List<List<Integer>> filtered = list.stream().filter( x -> x.stream().reduce(0, (sum, element) -> sum + element) >= 17).filter(x -> x.stream().reduce(0, (sum, element) -> sum + element) <= 21).collect(Collectors.toList());
        Set unique = new HashSet(filtered);
        System.out.println("Total complying: " + unique.size());
        unique.forEach(System.out::println);
    }

    public List<List<Integer>> getCombinations(Integer[] elements, int k) {
        IGenerator<List<Integer>> list = Generator.combination(elements).multi(k);
//        list.forEach(System.out::println);
        System.out.println("total combinations: " + list.stream().count());

        return list.stream().collect(Collectors.toList());
    }
}
