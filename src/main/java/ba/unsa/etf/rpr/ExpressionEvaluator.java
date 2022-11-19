package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {

    ExpressionEvaluator(){}


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
                leftpar += 1;
            }


            if (s.equals(")")){
                rightpar =+ 1;
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

    public static double evaluate(String s) {
        String[] arrStr = parsedStr(s);
        for (String str : arrStr) {
            double l = 0;
            if(str.equals(")")) {
                while (!(ops.peek()).equals("(")) {
                    String operand = ops.pop();
                    if(operand.equals("sqrt")){
                        double t, res;
                        t = vals.pop();
                        res = val(operand, t, t);
                        vals.push(res);
                    }
                    else {
                        double x1, x2;
                        x2 = vals.pop();
                        x1 = vals.pop();
                        double x;
                        x = val(operand, x1, x2);
                        vals.push(x);
                    }
                }
                ops.pop();
            }else if (!(str.equals(")"))) {
                if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("sqrt") || str.equals("(")){
                    ops.push(str);
                }else {
                    l = Double.parseDouble(str);
                    vals.push(l);
                }
            }

        }
        return vals.pop();
    }




}
