package ca.jrvs.apps.twitter.example;

public class Calculator {

    public int evaluate(String expression)
    {
        int sum =0;
        for(String s: expression.split("\\n"));
        sum += Integer.valueOf(s);
        return sum;
    }
}
