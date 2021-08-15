package Calculator;

public class StringCalculator {
    public int Add(String numbers){
        numbers = numbers.replaceAll(" ","");
        //for empty String
        if(numbers.equals("")) {
            return 0;
        }
        else{
            int number;
            number = Integer.parseInt(numbers);
            return number;
        }
    }
}
