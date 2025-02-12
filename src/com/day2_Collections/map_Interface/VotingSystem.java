package com.day2_Collections.map_Interface;
import java.util.*;

public class VotingSystem {
    // HashMap to store votes
    private Map<String, Integer> votesMap;
    // Maintaining order of votes
    private LinkedHashMap<String, Integer> voteHistory;

    //constructor
    public VotingSystem() {
        votesMap = new HashMap<>();
        voteHistory = new LinkedHashMap<>();
    }

    // Method to cast a vote
    public void castVote(String candidate) {
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
        voteHistory.put(candidate, votesMap.get(candidate));
    }

    // Displaying results in sorted order using TreeMap
    public void displayResults() {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(votesMap);
        System.out.println("\nElection Results (Sorted by Candidate Name):");
        sortedVotes.forEach((candidate, votes) ->
                System.out.println(candidate + " -> " + votes + " votes"));
    }

    // Displaying voting order using LinkedHashMap
    public void displayVoteHistory() {
        System.out.println("\nVote History (Order of Votes Cast):");
        voteHistory.forEach((candidate, votes) ->
                System.out.println(candidate + " -> " + votes + " votes"));
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Rahul");
        votingSystem.castVote("Babloo");
        votingSystem.castVote("Ankit");
        votingSystem.castVote("Chanchal");
        votingSystem.castVote("Bittu");
        votingSystem.castVote("Aalok");

        //  results
        votingSystem.displayResults();
        votingSystem.displayVoteHistory();
    }
}
