package com.anandgautam.tdd;

public class StringCalculator {

    public int Add(String numbers) {

        int sum = 0;
        if (numbers.isEmpty()) {
            return 0;
        }

        String delim = ",";
        if(numbers.startsWith("//")) {
            delim = String.valueOf(numbers.charAt(2));
            numbers = numbers.substring(4, numbers.length());
        }

        if ((numbers.contains(delim) && numbers.split(delim).length > 0) || (numbers.contains("\n") && numbers.split("\n").length > 0)) {
            for (String n : numbers.split(delim)) {
                if (n.contains("\n")) {
                    for (String finalNumber : n.split("\n")) {
                        if (!finalNumber.isEmpty()) {
                            sum += Integer.parseInt(finalNumber);
                        }
                    }
                }
                else {
                    sum+= Integer.parseInt(n);
                }
            }
            return sum;
        }

        sum += Integer.parseInt(numbers);

        return sum;
    }

}