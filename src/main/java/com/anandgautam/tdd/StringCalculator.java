package com.anandgautam.tdd;

public class StringCalculator {
    
    public int Add(String numbers) {

        int sum = 0;
        if(numbers.isEmpty()) {
            return 0;
        }

        if(numbers.contains(",") && numbers.split(",").length > 0) {
            for(String n : numbers.split(",")) {
                if(!n.isEmpty()) {
                    sum+= Integer.parseInt(n);
                }
            }
        }
        else {
            sum+= Integer.parseInt(numbers);
        }
        return sum;
    }

}