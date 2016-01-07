package com.luxoft.commandLineCalculator.Calc;
import java.math.*;
import java.util.*;
import java.util.regex.Matcher;

public class StartCalculations {
    ArrayList<String> contents;
    String item;

    public float calculate (String formula){
        Float result;
        result = Float.valueOf(brackets(formula));
	
        return result;
    }
    public String brackets(String s){             //method which deal with brackets separately
        while(s.contains(Character.toString('('))||s.contains(Character.toString(')'))){
            for(int o=0; o<s.length();o++){
                try{                                                        //i there is not sign
                    if((s.charAt(o)==')' || Character.isDigit(s.charAt(o))) //between separate brackets
                            && s.charAt(o+1)=='('){                         //or number and bracket,
                        s=s.substring(0,o+1)+"*"+(s.substring(o+1));        //it treat it as
                    }                                                       //a multiplication
                }catch (Exception ignored){}                                //ignore out of range ex
                if(s.charAt(o)==')'){                                  //search for a closing bracket
                    for(int i=o; i>=0;i--){
                        if(s.charAt(i)=='('){                          //search for a opening bracket
                            String in = s.substring(i+1,o);
                            in = recognizeStringOnNumbersAndOperators(in);
                            s=s.substring(0,i)+in+s.substring(o+1);
                            i=o=0;
                        }
                    }
                }
            }
            if(s.contains(Character.toString('('))||s.contains(Character.toString(')'))||
                    s.contains(Character.toString('('))||s.contains(Character.toString(')'))){
                System.out.println("Error: incorrect brackets placement");
                return "Error: incorrect brackets placement";
            }
        }
        s= recognizeStringOnNumbersAndOperators(s);
        return s;
    }
    public String recognizeStringOnNumbersAndOperators(String s){              //method divide String on numbers and operators
        DoCalculations doCalculations = new DoCalculations();
        contents = new ArrayList<String>();         //holds numbers and operators
        item = "";
        for(int i=s.length()-1;i>=0;i--){           //is scan String from right to left,
            if(Character.isDigit(s.charAt(i))){     //Strings are added to list, if scan finds
                item=s.charAt(i)+item;              //a operator, or beginning of String
                if(i==0){
                    doCalculations.put();
                }
            }else{
                if(s.charAt(i)=='.'){
                    item=s.charAt(i)+item;
                }else if(s.charAt(i)=='-' && (i==0 || (!Character.isDigit(s.charAt(i-1))))){
                    item=s.charAt(i)+item;          //this part should recognizeStringOnNumbersAndOperators
                    doCalculations.put();                    //negative numbers
                }else{
                    doCalculations.put();                //it add already formed number and
                    item+=s.charAt(i);          //operators to list
                    doCalculations.put();                //as separate Strings
                if(s.charAt(i)=='|'){       //add empty String to list, before "|" sign,
                        item+=" ";          //to avoid removing of any meaningful String
                        doCalculations.put();        //in last part of result method
                    }
                }
            }
        }
        contents = doCalculations.result(contents, "^", "|");    //check Strings
        contents = doCalculations.result(contents, "*", "/");    //for chosen
        contents = doCalculations.result(contents, "+", "-");    //operators
        return contents.get(0);
    }
    public class DoCalculations {
        public void put(){
            if(!item.equals("")){
                contents.add(0,item);
                item="";
            }
        }

public ArrayList<String>result(ArrayList<String> arrayList, String op1, String op2){
    double result = 0;
    for(int c = 0; c<arrayList.size();c++){
        if(arrayList.get(c).equals(op1)|| arrayList.get(c).equals(op2)){
            if(arrayList.get(c).equals("^")){
                result = Math.pow(Float.valueOf(arrayList.get(c-1)), Float.valueOf(arrayList.get(c+1)));
            }else if(arrayList.get(c).equals("|")){

                result = Math.sqrt(Float.valueOf(arrayList.get(c+1)));
            }else if(arrayList.get(c).equals("*")){

                result = Float.valueOf(arrayList.get(c-1)) * Float.valueOf(arrayList.get(c+1));
            }else if(arrayList.get(c).equals("/")){
                try {

                    result = Float.valueOf(arrayList.get(c-1)) / Float.valueOf(arrayList.get(c+1));
                }catch (ArithmeticException e) {
                    System.out.println("Divide by zero prohibited ");
                }
            }else if(arrayList.get(c).equals("+")){
                result = Float.valueOf(arrayList.get(c-1)) + Float.valueOf(arrayList.get(c+1));
            }else if(arrayList.get(c).equals("-")){

                result = Float.valueOf(arrayList.get(c-1)) - Float.valueOf(arrayList.get(c+1));
            }
            try{       //in a case of to "out of range" ex
                arrayList.set(c, String.valueOf(result));
                arrayList.remove(c + 1);            //it replace the operator with result
                arrayList.remove(c-1);              //and remove used numbers from list
            }catch (Exception ignored){}
        }else{
            continue;
        }
        c=0;                     //loop reset, as arrayList changed size
    }
    return arrayList;
}
    }
}
