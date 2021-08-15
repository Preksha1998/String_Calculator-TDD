package Test;
import Calculator.StringCalculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    private StringCalculator sc = new StringCalculator();
    @Test
    public void emptyString()throws Exception{
        assertEquals(0,sc.Add(" "));
    }

}
