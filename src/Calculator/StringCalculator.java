package Calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public int Add(String numbers){
        numbers = numbers.replaceAll(" ","");
        //for empty String
        if(numbers.equals("")) {
            return 0;
        }
        else if(numbers.startsWith("//")){
            int sum = 0;
            String delimiter;
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
            numbers = numbers.substring(4); //remove till \n
            String[] arrNum = numbers.split(Pattern.quote(delimiter));
            for(String num:arrNum){
                sum+= Integer.parseInt(num);
            }
            return sum;
        }
        else{
            String Arrnum[] = numbers.split(",|\n");
            int number = 0;
            for(String num : Arrnum) {
                number += Integer.parseInt(num);
            }
            return number;
        }
    }
}
