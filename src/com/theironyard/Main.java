package com.theironyard;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        //challenge 1
        //convert this class into a lambda
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        //lambda version
        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };


        //challenge 2 - convert to lambda
        //what's wrong with this statement?
//        (String s) -> {
//            StringBuilder returnVal = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                if(i % 2 == 1) {
//                    returnVal.append(s.charAt(i));
//                }
//            }
//
//            return returnVal.toString();
//        };

        //lambda version
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };

        //challenge 3 - write the code that will execute the function
        // with an arguement of "1234567890"
        System.out.println(lambdaFunction.apply("1234567890"));
        //returns only even numbers and zero

        //challenge 5 - call the method with the lambdaFunction we created
        //and the string "1234567890" print the result returned
        String result = everySecondCharacter(lambdaFunction, "1234567890");
        System.out.println(result);

        //challenge 4 - write a method called everySecondCharacter that
        // accepts the function as a parameter and executes it with the arguement
        //"1234567890"
        }
        public static String everySecondCharacter(Function<String, String> func, String source) {
            return func.apply(source);
        }

    }

