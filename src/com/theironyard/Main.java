package com.theironyard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

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
//        System.out.println(lambdaFunction.apply("1234567890"));
        //returns only even numbers and zero

        //challenge 5 - call the method with the lambdaFunction we created
        //and the string "1234567890" print the result returned
        String result = everySecondCharacter(lambdaFunction, "1234567890");
        System.out.println(result);

        //challenge 4 - write a method called everySecondCharacter that
        // accepts the function as a parameter and executes it with the argument
        //"1234567890"

        //challenge 6 - write a lambda expression that maps to the java.util.Supplier interface
        //this lambda should return the string "I love Java!"
        //assign it to a variable called iLoveJava
        Supplier<String> iLoveJava = () -> "I love Java!";
        //a supplier produces strings, no return keyword needed

        //challenge 7 - use this supplier to assign the string "I love Java!"
        //to a variable called supplierResult, then print to the console
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        //challenge 9 - write code to print the items in the list in sorted order, and with the first letter
        //in each name upper-cased. The name "harry" should be printed as "Harry" and should be printed after
        //"Emily" and before "Isla". Use lambda expressions where possible
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames2015.forEach(name ->
//                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
////        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
//        firstUpperCaseList.forEach(s -> System.out.println(s));
//        firstUpperCaseList.sort(String::compareTo);
//        firstUpperCaseList.forEach(System.out::println);


       //challenge 11 - using streams
        topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        //challenge 10 - change the code so that it uses method references.
        //Remember that a method reference looks like Class::MethodName





        }
        public static String everySecondCharacter(Function<String, String> func, String source) {
            return func.apply(source);
        }

    }

