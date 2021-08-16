package Calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public int Add(String numbers) throws Exception {
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
            numbers = numbers.substring(4);
            String[] arrNum = numbers.split(Pattern.quote(delimiter));
            for(String num:arrNum){
                sum+= Integer.parseInt(num);
            }
            return sum;
        }
        else{
            String Arrnum[] = numbers.split(",|\n");
            int sum = 0, number = 0;
            String negStr = "";
            for(String num : Arrnum) {
                number += Integer.parseInt(num);
                if(number < 0){
                    negStr = negStr.concat(num+",");
                }
                else if (number < 1000) {
                    sum += number;
                } else {
                    number = 0;
                    sum += number;
                }
            }
            if(!negStr.isEmpty()){
                negStr = negStr.substring(0,negStr.length()-1);
                throw new Exception("Negative Numbers not Allowed " + negStr);
            }
            return number;
        }
    }
}
