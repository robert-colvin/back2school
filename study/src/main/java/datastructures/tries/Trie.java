package datastructures.tries;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Trie {
    // number of edges from each node. configurable here but for an alphabet trie, it's 26 for number of letters in English alphabet
    private static final int NUM_STATE_TRANSITIONS = 26;
    private final Node root = new Node();

    private static class Node {
        Integer val;
        Node[] edges = new Node[NUM_STATE_TRANSITIONS]; // reminder each node contains each possible outgoing edge in the decision space
    }

    private int mapToArrayIndex(char letter) {
        return letter - 'a';
    }

    // parallel arrays for ease right now
    public void init(List<String> terminalStates, List<Integer> stateValues) {
        for (int i = 0; i < terminalStates.size(); i++) {
            insert(terminalStates.get(i), stateValues.get(i));
        }
    }

    public Node insert(String terminalState, int stateValue) {
        // currNode keeps track of the  latest node/state along the path so far
        Node currNode = root;
        for (char letter : terminalState.toCharArray()) {
            int edgeIndex = mapToArrayIndex(letter);

            if (currNode.edges[edgeIndex] == null) {
                System.out.println("Inserted the letter " + letter + " along the path for " + terminalState);
                currNode.edges[edgeIndex] = new Node();
            }

            currNode = currNode.edges[edgeIndex];
        }

        // note this will overwrite the existing value if a state is inserted more than once with a different stateValue
        currNode.val = stateValue;
        System.out.println("finished inserting " + terminalState + " with stateVal " + stateValue);
        return currNode;
    }

    public boolean contains(String terminalState) {
        Node currNode = root;
        for (char letter : terminalState.toCharArray()) {
            int edgeIndex = mapToArrayIndex(letter);

            if (currNode.edges[edgeIndex] == null) {
                System.out.println(terminalState + " not found in trie");
                return false;
            }

            System.out.println("found " + letter + " along search path for " + terminalState);
            currNode = currNode.edges[edgeIndex];
        }
        // Only return true if the given state already is marked as terminal in the trie
        if (currNode.val != null) {
            System.out.println("found " + terminalState);
            return true;
        }
        System.out.println(terminalState + " found in trie but is not a terminal state");
        return false;
    }

    // returns whether the item to delete was present to begin with
    public boolean delete(String terminalState) {
        Node currNode = root;
        Node prevNode = null;
        for (char letter : terminalState.toCharArray()) {
            int edgeIndex = mapToArrayIndex(letter);

            if (currNode.edges[edgeIndex] == null) {
                return false;
            }

            prevNode = currNode;
            currNode = currNode.edges[edgeIndex];
        }

        currNode.val = null;
        boolean hasChildren = Arrays.stream(currNode.edges).anyMatch(Objects::nonNull);

        // if the deleted state has children (aka is a substring for another terminal state), do nothing further
        // else delete that state transition from parent node's array of edges to free up memory
        if (!hasChildren) {
            int lastEdge = mapToArrayIndex(terminalState.charAt(terminalState.length() - 1));
            prevNode.edges[lastEdge] = null;
        }
        return true;
    }
}
