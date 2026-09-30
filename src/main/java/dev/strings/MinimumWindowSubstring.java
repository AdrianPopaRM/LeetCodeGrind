package main.java.dev.strings;

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        StringBuilder minimumWindowSubstring = new StringBuilder();

        Map<Character, ArrayList<Integer>> characterIndexes = new HashMap<>();
        Map<Character, Integer> characterOccurrenceInT = new HashMap<>();

        //This maps out all character present in S and their indexes
        for (int i = 0; i < s.length(); i++) {
            characterIndexes.computeIfAbsent(s.charAt(i), key -> new ArrayList<>()).add(i);
        }
        //This map is responsible for knowing how many instances of each character do i need to satisfy the requirement
        for (int i = 0; i < t.length(); i++) {
            char currentCharacter = t.charAt(i);
            characterOccurrenceInT.put(currentCharacter, characterOccurrenceInT.getOrDefault(currentCharacter, 0) + 1);
            //This if condition checks out the edge case where appearances of a character in T > appearances in S
            if (!characterIndexes.containsKey(currentCharacter)) {
                return "";
            }
            if (characterOccurrenceInT.get(currentCharacter) > characterIndexes.get(currentCharacter).size()) {
                return "";
            }
        }

        //This set is responsible for tracking the substring window. I've used navigable as it provides native
        //function for quickly accessing first element while also maintaining natural order
        NavigableSet<Integer> characterIndexSet = new TreeSet<>();


        //Sorted the keys in the map by the number of indexes in S
        ArrayList<Character> charsToProcess = new ArrayList<>(characterOccurrenceInT.keySet());
        charsToProcess.sort((c1, c2) -> {
            int size1 = characterIndexes.get(c1).size();
            int size2 = characterIndexes.get(c2).size();
            return Integer.compare(size1, size2);
        });

        Character firstChar = charsToProcess.getLast();
        int startingIndexOfFirstChar = 0;

        //Cose the element with most indexes available, and we choose our next
        //components for the minimum window substring around this first element indexes
        while (true) {
            characterIndexSet.clear();
            int requiredOccurrencesOfFirstChar = characterOccurrenceInT.get(firstChar);
            int totalSize = characterIndexes.get(firstChar).size();

            if (startingIndexOfFirstChar + requiredOccurrencesOfFirstChar > totalSize) {
                break;    //If required number of first character, starting from current starting index, is greater
                // than total number of indexes we finished the program
            }
            //Adding the current slice of indexes for the first element.
            characterIndexSet.addAll(characterIndexes.get(firstChar).subList(startingIndexOfFirstChar, startingIndexOfFirstChar + requiredOccurrencesOfFirstChar));

            for (Character nextChar : charsToProcess) {
                //Checking to make sure the current element isn't the same as first
                if (nextChar.equals(firstChar)) {
                    continue;
                }

                ArrayList<Integer> indexesForNextChar = characterIndexes.get(nextChar);
                int requiredOccurrencesOfNextChar = characterOccurrenceInT.get(nextChar);
                int totalSizeForCurrentChar = indexesForNextChar.size();

                //If number of available indexes = number of required characters we add the slice and continue to the next character
                if (totalSizeForCurrentChar == requiredOccurrencesOfNextChar) {
                    characterIndexSet.addAll(indexesForNextChar);
                    continue;
                }

                //Computing the first slice interval difference
                int startingIndexOfNextChar = 0;
                int alreadyEstablishedIntervalLowerBound = characterIndexSet.first();
                int alreadyEstablishedIntervalUpperBound = characterIndexSet.last();

                int indexOfLowerBoundOfCurrentSlice = indexesForNextChar.get(startingIndexOfNextChar);
                int indexOfUpperBoundOfCurrentSlice = indexesForNextChar.get(startingIndexOfNextChar + requiredOccurrencesOfNextChar - 1);

                // This variable keeps track of how much the interval would grow if i used the current slice of nextChar
                int intervalDifferenceForPreviousSlice = getIntervalDifference(indexOfLowerBoundOfCurrentSlice, indexOfUpperBoundOfCurrentSlice, alreadyEstablishedIntervalLowerBound, alreadyEstablishedIntervalUpperBound);

                // If the previous slice is contained in the already established interval we just add it
                if (intervalDifferenceForPreviousSlice == 0) {
                    characterIndexSet.addAll(indexesForNextChar.subList(startingIndexOfNextChar, startingIndexOfNextChar + requiredOccurrencesOfNextChar));
                    continue;
                }

                startingIndexOfNextChar++;

                while (startingIndexOfNextChar <= totalSizeForCurrentChar - requiredOccurrencesOfNextChar) {

                    int indexOfLowerBoundOfNextSlice = indexesForNextChar.get(startingIndexOfNextChar);
                    int indexOfUpperBoundOfNextSlice = indexesForNextChar.get(startingIndexOfNextChar + requiredOccurrencesOfNextChar-1);

                    int intervalDifferenceForCurrentSlice = getIntervalDifference(indexOfLowerBoundOfNextSlice, indexOfUpperBoundOfNextSlice, alreadyEstablishedIntervalLowerBound, alreadyEstablishedIntervalUpperBound);


                    //If the next interval doesn't offer a better alternative, we add the current slice
                    if (intervalDifferenceForPreviousSlice < intervalDifferenceForCurrentSlice) {
                        startingIndexOfNextChar-=1;
                        characterIndexSet.addAll(indexesForNextChar.subList(startingIndexOfNextChar, startingIndexOfNextChar + requiredOccurrencesOfNextChar));
                        break;
                    } else {
                        intervalDifferenceForPreviousSlice=intervalDifferenceForCurrentSlice;
                    }

                    startingIndexOfNextChar++;
                }


                //If the while ended on the last valid slice, it means that this is the best one yet,and we need to add it
                if (startingIndexOfNextChar-1 == totalSizeForCurrentChar - requiredOccurrencesOfNextChar) {
                    startingIndexOfNextChar--;
                    characterIndexSet.addAll(indexesForNextChar.subList(startingIndexOfNextChar, startingIndexOfNextChar + requiredOccurrencesOfNextChar));
                }
            }

            if (minimumWindowSubstring.isEmpty()) {
                minimumWindowSubstring.append(s, characterIndexSet.first(), characterIndexSet.last() + 1);
            } else {
                if (minimumWindowSubstring.length() > characterIndexSet.last() - characterIndexSet.first() + 1) {
                    minimumWindowSubstring.delete(0, minimumWindowSubstring.length());
                    minimumWindowSubstring.append(s, characterIndexSet.first(), characterIndexSet.last() + 1);
                }
            }

            startingIndexOfFirstChar++;
        }
        return minimumWindowSubstring.toString();
    }

    public int getIntervalDifference(int indexOfLowerBoundOfCurrentSlice, int indexOfUpperBoundOfCurrentSlice, int alreadyEstablishedIntervalLowerBound, int alreadyEstablishedIntervalUpperBound) {
        int intervalDifferenceForCurrentSlice = 0;
        //This checks to see if lowerBound of nextChar interval is greater than already established interval
        if (indexOfLowerBoundOfCurrentSlice > alreadyEstablishedIntervalLowerBound) {
            //If upperbound is also lower than already established interval, the whole interval is contained so we add it
            if (indexOfUpperBoundOfCurrentSlice < alreadyEstablishedIntervalUpperBound) {
                return 0;
            }
            //If it got here, it means the upper bound is not contained so we add the difference
            intervalDifferenceForCurrentSlice += Math.abs(indexOfUpperBoundOfCurrentSlice - alreadyEstablishedIntervalUpperBound);
        } else {
            intervalDifferenceForCurrentSlice += Math.abs(indexOfLowerBoundOfCurrentSlice - alreadyEstablishedIntervalLowerBound);

            //Checks to see if upper bound is also not contained
            if (indexOfUpperBoundOfCurrentSlice > alreadyEstablishedIntervalUpperBound) {
                intervalDifferenceForCurrentSlice += Math.abs(indexOfUpperBoundOfCurrentSlice - alreadyEstablishedIntervalUpperBound);
            }
        }
        return intervalDifferenceForCurrentSlice;
    }

    public static void main(String args[]) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.println(test.minWindow("coobdafceeaxab", "abc"));
        System.out.println(test.minWindow("wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon", "ozgzyywxvtublcl"));

//        System.out.println(test.minWindow("a","a"));
//        System.out.println(test.minWindow("a","aa").equals(""));

    }

//        for (Integer indexOfFirstChar : characterIndexes.get(firstChar)) {
//
//            if (characterIndexSet.size() < characterOccurrenceInT.get(firstChar)) {
//                characterIndexSet.add(indexOfFirstChar);
//                continue;
//            }
//
//            for (Character currentChar : characterIndexes.keySet()) {
//                if (currentChar.equals(firstChar)) {
//                    continue;
//                }
//                int requiredNrOccurrences = characterOccurrenceInT.get(currentChar);
//                ArrayList<Integer> indexListForCurrentChar = characterIndexes.get(currentChar);
//                for (int indexOfCurrentChar = 0; indexOfCurrentChar < indexListForCurrentChar.size(); indexOfCurrentChar++) {
//                    if (characterIndexSet.first() > indexListForCurrentChar.get(indexOfCurrentChar)) {
//                        if(indexListForCurrentChar.size()-indexOfCurrentChar>requiredNrOccurrences){
//
//                        }
//                    }
//                }
//            }
//        }
}

