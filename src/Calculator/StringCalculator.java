package Calculator;

public class StringCalculator {
    public int Add(String numbers){
        numbers = numbers.replaceAll(" ","");
        //for empty String
        if(numbers.equals("")) {
            return 0;
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
