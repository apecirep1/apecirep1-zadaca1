package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {


    private static Stack<String> ops = new Stack<> ();
    private static Stack<Double> vals = new Stack<> ();

    public static String[] parsedString(String str){

        return str.split(" ");
    }

    public static double val(String op, double x1, double x2){
        double res = 0;
        if(op.equals("+")){
            res=x1+x2;
        } else if(op.equals("-")){
            res=x1-x2;
        } else if(op.equals("*") ){
            res=x1*x2;
        } else if(op.equals("/")){
            res=x1/x2;
        }else if(op.equals("sqrt")) {
            res=Math.sqrt(x2);
        }

        return res;
    }


}
