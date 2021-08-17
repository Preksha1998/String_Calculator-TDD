package Calculator;
import java.util.regex.Pattern;

public class StringCalculator {
    public int Add(String numbers) throws Exception {
        String[] Arrnum;
        int result;
        numbers = numbers.replaceAll(" ","");
        //for empty String
        if(numbers.equals("")) {
            return 0;
        }
        // support multiple delimiters
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

            Arrnum = delimiterstr.split(Pattern.quote(delimiter1));
            result = Sum(Arrnum);
            return result;
        }
//        //supports unknown amount of numbers
        else{
            Arrnum = numbers.split(",|\n");
            result = Sum(Arrnum);
            return result;
        }
    }
    //convert string to an integer
    private static int convertToInt(String no){
             int num = Integer.parseInt(no);
             return  num;
    }
    //Add numbers less than 1000 and negative numbers will throw exception
    private  static  int Sum(String[] numbers) throws Exception{
        int sum = 0;
        String negStr = "";
        for (String num : numbers) {
            if (convertToInt(num) < 0) {
                negStr = negStr.concat(convertToInt(num) + ",");
            }
            if (convertToInt(num) < 1000) {
                sum += convertToInt(num);
            }
        }
        if (!negStr.isEmpty()) {
            negStr = negStr.substring(0, negStr.length() - 1);
            throw new Exception("Negative Numbers not Allowed " + negStr);
        }
        return sum;
    }
}
