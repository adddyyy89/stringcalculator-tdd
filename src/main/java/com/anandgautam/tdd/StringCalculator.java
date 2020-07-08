package com.anandgautam.tdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StringCalculator {

    public int Add(String numbers) throws NegativeNumberException {

        int sum = 0;
        if (numbers.isEmpty()) {
            return 0;
        }


        List<String> delimList = new ArrayList<>();
        if(numbers.startsWith("//")) {
            delimList = getDelimiters(numbers);
            numbers = numbers.substring(numbers.indexOf("\n")+1, numbers.length());
        }

        // Replace each delimitor with a single dilimitor for easier processing
        for(String delimStr : delimList) {
            numbers = numbers.replace(delimStr, ",");
        }

        List<String> negativeNumbers = new LinkedList<>();

        if ((numbers.contains(",") && numbers.split(",").length > 0) || (numbers.contains("\n") && numbers.split("\n").length > 0)) {
            for (String n : numbers.split(",")) {
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

    /* Get all delimiters */
    private List<String> getDelimiters(String numbers) {
        List<String> delimList = new ArrayList<>();

        if(numbers.startsWith("//")) {

            String delimStr = numbers.substring(2, numbers.indexOf("\n"));
            if(delimStr.contains("[") && delimStr.contains("]")) {
                String delim = "";
                for(char c : delimStr.toCharArray()) {
                    if(c == '[') {
                        delim="";   
                    }
                    else if(c == ']') {
                        delimList.add(delim);
                    }
                    else {
                        delim+=c;
                    }
                }
            }

            // Get single delimitor
            else {
                delimList.add(String.valueOf(numbers.charAt(2)));
            }
        }

        return delimList;
    }

}