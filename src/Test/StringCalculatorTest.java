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
    @Test
    public void oneArgString()throws Exception{
        assertEquals(1,sc.Add("  1"));
    }
    @Test
    public void twoArgString()throws Exception{
        assertEquals(100,sc.Add("  50,50"));
    }
    @Test
    public void multipleArgString()throws Exception{
        assertEquals(150,sc.Add("10,100,40"));
    }
    @Test
    public void handleNewLine()throws Exception{
        assertEquals(6,sc.Add("1\n2,3"));
    }
    @Test
    public void WithDifferentDelimiters()throws Exception{
        assertEquals(3,sc.Add("//;\n1;2"));
        assertEquals(3,sc.Add("//*\n1*2"));
    }
}
