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
            String delimiter1 = "", delimiterstr = "";
            int start_index = numbers.indexOf("//") + 2;
            int end_index = numbers.indexOf("\n");
            delimiter1 = numbers.substring(start_index,end_index);
            delimiterstr = numbers.substring(end_index + 1);

            if(delimiter1.startsWith("[") && delimiter1.endsWith("]")){
                delimiter1 = numbers.substring(start_index + 1,end_index - 1);
            }

            String[] arrNum = delimiterstr.split(Pattern.quote(delimiter1));
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
