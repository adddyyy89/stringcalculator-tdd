package com.anandgautam.tdd;

public class StringCalculator {
    
    public int Add(String numbers) {
        
        int sum = 0;
        if(numbers.isEmpty()) {
            return 0;
        }

        
        sum+= Integer.parseInt(numbers);
        return sum;
    }
}