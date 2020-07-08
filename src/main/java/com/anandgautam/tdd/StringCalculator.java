package com.anandgautam.tdd;

import java.util.LinkedList;
import java.util.List;

public class StringCalculator {

    public int Add(String numbers) throws NegativeNumberException {

        int sum = 0;
        if (numbers.isEmpty()) {
            return 0;
        }

        String delim = ",";
        if(numbers.startsWith("//")) {
            delim = String.valueOf(numbers.charAt(2));
            numbers = numbers.substring(4, numbers.length());
        }

        List<String> negativeNumbers = new LinkedList<>();

        if ((numbers.contains(delim) && numbers.split(delim).length > 0) || (numbers.contains("\n") && numbers.split("\n").length > 0)) {
            for (String n : numbers.split(delim)) {
                if (n.contains("\n")) {
                    for (String finalNumber : n.split("\n")) {
                        if (!finalNumber.isEmpty()) {
                            if(Integer.parseInt(finalNumber) < 0) {
                                negativeNumbers.add(finalNumber);
                            }
                            if(negativeNumbers.size() == 0 && Integer.parseInt(finalNumber) <= 1000) {
                                sum += Integer.parseInt(finalNumber);
                            }
                        }
                    }
                }
                else {
                    if(Integer.parseInt(n) < 0) {
                        negativeNumbers.add(n);
                    }
                    if(negativeNumbers.size() == 0 && Integer.parseInt(n) <= 1000) {
                        sum+= Integer.parseInt(n);
                    }
                }
            }
            if(negativeNumbers.size() > 0) {
                throw new NegativeNumberException("negative numbers are not allowed : " + negativeNumbers.toString());
            }
            return sum;
        }

        if(Integer.parseInt(numbers) < 0) {
            negativeNumbers.add(numbers);
        }
        if(negativeNumbers.size() == 0 && Integer.parseInt(numbers) <= 1000) {
            sum += Integer.parseInt(numbers);
        }
        if(negativeNumbers.size() > 0) {
            throw new NegativeNumberException("negative numbers are not allowed : " + negativeNumbers.toString());
        }

        return sum;
    }

}