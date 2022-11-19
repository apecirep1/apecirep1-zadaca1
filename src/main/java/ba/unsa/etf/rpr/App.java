package ba.unsa.etf.rpr;

import java.util.Scanner;

public class App {

    public static void main( String[] args )throws RuntimeException{
        try{
            String str = "";
            for(int i = 0; i < args.length; i++)str+=args[i];

            str += " ";

            ExpressionEvaluator.check(str);
            double res;
            res = ExpressionEvaluator.evaluate(str);
            System.out.println("Result is: " + res);

        }catch(RuntimeException exception){
            System.out.println("Error: wrong input");
        }


    }
}
