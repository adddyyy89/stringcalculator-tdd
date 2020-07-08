package com.anandgautam.tdd;

public class StringCalculator {

    public int Add(String numbers) {

        int sum = 0;
        if (numbers.isEmpty()) {
            return 0;
        }

        if ((numbers.contains(",") && numbers.split(",").length > 0) || (numbers.contains("\n") && numbers.split("\n").length > 0)) {
            for (String n : numbers.split(",")) {
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