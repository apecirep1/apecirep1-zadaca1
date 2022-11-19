package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {


    private static Stack<String> ops = new Stack<> ();
    private static Stack<Double> vals = new Stack<> ();

    public static String[] parsedStr(String str){

        return str.split(" ");
    }

    public static void check(String string){

        String [] parstr = parsedStr(string);
        for(String s: parstr){

            if(!(s.equals("(") || s.equals(")") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")
                    || s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4")
                    || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9")))
                throw new RuntimeException("Error: Wrong operands or operators");
        }

        int leftpar = 0;
        int rightpar = 0;
        for(String s: parstr) {
            if (s.equals("(")){
                leftpar = leftpar + 1;
            }


            if (s.equals(")")){
                rightpar = rightpar + 1;
            }
        }

        if (rightpar != leftpar)  throw new RuntimeException("Error: Invalid parentheses");

    }

    public static double val(String operator, double x1, double x2){
        double res = 0;
        if(operator.equals("+")){
            res=x1+x2;
        } else if(operator.equals("-")){
            res=x1-x2;
        } else if(operator.equals("*") ){
            res=x1*x2;
        } else if(operator.equals("/")){
            res=x1/x2;
        }else if(operator.equals("sqrt")) {
            res=Math.sqrt(x2);
        }

        return res;
    }


}
