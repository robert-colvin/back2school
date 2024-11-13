package datastructures.tries;

import java.util.ArrayList;
import java.util.List;

public class TestTrie {
    public static void main(String[] args) {
        System.out.println("INIT=================================================================================");
        List<String> states = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        states.add("pie");
        values.add(1);
        states.add("pies");
        values.add(6);
        states.add("pied");
        values.add(3);
        states.add("piedre");
        values.add(2);
        states.add("pies");
        values.add(11);
        states.add("lied");
        values.add(30);

        Trie trie = new Trie();
        trie.init(states, values);

        System.out.println("\nSEARCH=================================================================================");
        trie.contains("lied");
        trie.contains("pie");
        trie.contains("p");
        trie.contains("lie");

        System.out.println("\nDELETE=================================================================================");
        trie.delete("pie");
        trie.delete("lied");

        System.out.println("\nSEARCH AGAIN=================================================================================");
        trie.contains("lied");
        trie.contains("pie");
        trie.contains("p");
        trie.contains("lie");
        trie.contains("piedre");
    }
}
