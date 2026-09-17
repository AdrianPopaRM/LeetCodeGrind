package main.java.dev.arrays;

import java.util.Arrays;

public class Candy {
    enum Monotony {
        DESCENDING,
        ASCENDING,
        NOT_DETERMINED
    }

    public int candy(int[] ratings) {
        int minNrCandies = 0, currentMonotonousStreak = 1;
        int size = ratings.length;
        Monotony monotony = Monotony.NOT_DETERMINED;

        if (size == 1) {
            return 1;
        }

        if (ratings[0] == ratings[1]) {
            minNrCandies++;
        }
        for (int i = 1; i < size; i++) {
            //ASCENDING
            if (ratings[i] > ratings[i - 1]) {
                switch (monotony){
                    case NOT_DETERMINED:
                    {
                        monotony= Monotony.ASCENDING;
                        currentMonotonousStreak++;
                        break;
                    }
                    case ASCENDING:
                    {
                        currentMonotonousStreak++;
                        break;
                    }
                    case DESCENDING:
                    {
                        minNrCandies+=currentMonotonousStreak*(currentMonotonousStreak+1)/2-1;
                        currentMonotonousStreak=2;
                        monotony = Monotony.ASCENDING;
                        break;
                    }
                }
                continue;
            }
            //DESCENDING
            if ( ratings[i] < ratings[i - 1] ){
                switch (monotony){
                    case NOT_DETERMINED:
                    {
                        monotony= Monotony.DESCENDING;
                        currentMonotonousStreak++;
                        break;
                    }
                    case DESCENDING:
                    {
                        currentMonotonousStreak++;
                        break;
                    }
                    case ASCENDING:
                    {
                        minNrCandies += (currentMonotonousStreak-1)*currentMonotonousStreak/2;
                        currentMonotonousStreak=2;
                        monotony = Monotony.DESCENDING;
                        break;
                    }
                }
                continue;
            }
            if ( ratings[i] == ratings[i - 1] ) {
                if (currentMonotonousStreak > 1) {
                    minNrCandies += currentMonotonousStreak * (currentMonotonousStreak + 1) / 2;
                    currentMonotonousStreak = 1;
                    monotony = Monotony.NOT_DETERMINED;
                }
                if (i == size - 1) {
                    minNrCandies++;
                } else {
                    if (ratings[i] == ratings[i + 1]) {
                        minNrCandies++;
                    }
                }
            }
        }
        if(currentMonotonousStreak>1){
            minNrCandies += currentMonotonousStreak * (currentMonotonousStreak + 1) / 2;
        }

        return minNrCandies;
    }

//    public int candy(int[] ratings) {
//        int minNrCandies = 0, currentMonotonousStreak = 1;
//        int size = ratings.length;
//
//        if (size == 1) {
//            return 1;
//        }
//
//        if (ratings[0] == ratings[1]) {
//            minNrCandies++;
//        }
//        for (int i = 1; i < size; i++) {
//            if (ratings[i] > ratings[i - 1] || ratings[i] < ratings[i - 1]) {
//                currentMonotonousStreak++;
//            }
//            if ( ratings[i] == ratings[i - 1] ) {
//                if (currentMonotonousStreak > 1) {
//                    minNrCandies += currentMonotonousStreak * (currentMonotonousStreak + 1) / 2;
//                    currentMonotonousStreak = 1;
//                }
//                if (i == size - 1) {
//                    minNrCandies++;
//                } else {
//                    if (ratings[i] == ratings[i + 1]) {
//                        minNrCandies++;
//                    }
//                }
//            }
//        }
//        if(currentMonotonousStreak>1){
//            minNrCandies += currentMonotonousStreak * (currentMonotonousStreak + 1) / 2;
//        }
//
//        return minNrCandies;
//    }

    public static void main(String args[]) {
        Candy candy = new Candy();
        int[] testRatings1 = {1, 1, 1, 1, 1, 1, 1};
        int[] testRatings2 = {6, 5, 4, 4, 4, 3, 2};
        int[] testRatings3 = {1, 2, 5, 5, 5, 4, 6, 7};
        int[] testRatings4 = {1, 3, 5, 4, 3, 2, 1, 6, 7};
        System.out.println("Expected output: 7, actual output: " +candy.candy(testRatings1));
        System.out.println("Expected output: 13, actual output: " + candy.candy(testRatings2));
        System.out.println("Expected output: 15, actual output: " + candy.candy(testRatings3));
        System.out.println("Expected output: 23, actual output: " + candy.candy(testRatings4));

    }

//    public int candy(int[] ratings) {
//        int streak=1, nrCandies=0, direction=0; // 0 plateau 1 ascending 2 descending
//        if(ratings.length>1){
//            if(ratings[0]>ratings[1]){
//                direction=2;
//            }
//            else if(ratings[0]<ratings[1]){
//                direction=1;
//            }
//        }
//        for(int i=0;i<ratings.length-1;i++){
//            if(ratings[i]>ratings[i+1]){
//                if(direction==2||direction==0){
//                    streak++;
//                }
//                else{
//                    nrCandies+=streak*(streak-1)/2;
//                    streak=2;
//                    direction=2;
//                }
//            }
//            else if(ratings[i]<ratings[i+1]){
//                if(direction==1||direction==0){
//                    streak++;
//                }
//                else{
//                    if(true){
//                        nrCandies += streak * (streak - 1) / 2;
//                        streak = 2;
//                        direction = 1;
//                    }
//                }
//            }
//            else{
//                if(direction==0) nrCandies += 1;
//                else{

    /// /                    if(i==ratings.length-2){
    /// /
    /// /                    }
//                    nrCandies+=streak*(streak+1)/2;
//                    streak=1;
//                    direction=0;
//                }
//            }
//        }
//        if(direction==1){
//            nrCandies++;
//        }
//        nrCandies+=streak*(streak+1)/2;
//        return nrCandies;
//    }


//    public int candy(int[] ratings) {
//        int min=1, nrCandies=0, direction=0; // 0 plateau 1 ascending 2 descending
//        if(ratings.length>1){
//            if(ratings[0]>ratings[1]){
//                direction=2;
//            }
//            else if(ratings[0]<ratings[1]){
//                direction=1;
//            }
//        }
//        for(int i=0;i<ratings.length-1;i++){
//            nrCandies+=min;
//            if(ratings[i]>ratings[i+1]){
//                if(direction==2){
//                    min++;
//                }
//                else{
//                    direction=2;
//                }
//            }
//            else if(ratings[i]<ratings[i+1]){
//                if(direction==1){
//                    min++;
//                }
//                else{
//                    direction=1;
//                }
//            }
//            else{
//                direction=0;
//                min=1;
//            }
//        }
//        nrCandies+=min;
//        return nrCandies;
//    }

//    public int candyFinal(int[] ratings){
//        int streak, direction
//    }

//    public int candy(int[] ratings){
//        int[] candiesPerKid=new int[ratings.length];
//        Arrays.fill(candiesPerKid,1);
//        int index=satisfiesConditions(ratings,candiesPerKid);
//        while(index!=-1){
//            candiesPerKid[index]++;
//            index=satisfiesConditions(ratings,candiesPerKid);
//        }
//        return Arrays.stream(candiesPerKid).sum();
//    }
    private int satisfiesConditions(int[] ratings, int[] candiesPerKid) {
//        int size=ratings.length;
        for (int i = 0; i < ratings.length; i++) {
            if (i < ratings.length - 1) {
                if (ratings[i] > ratings[i + 1] && candiesPerKid[i] <= candiesPerKid[i + 1]) {
                    return i;
                }
            }
            if (i > 0) {
                if (ratings[i] > ratings[i - 1] && candiesPerKid[i] <= candiesPerKid[i - 1]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int candyV1(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] > ratings[i + 1]) {
                if (candies[i] <= candies[i + 1]) {
                    candies[i]++;
                }
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i] > ratings[i - 1]) {
                if (candies[i] <= candies[i - 1]) {
                    candies[i]++;
                }
            }
        }
        return Arrays.stream(candies).sum();
    }
}
