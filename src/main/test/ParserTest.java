import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by rahmirford on 5/31/17.
 */
public class ParserTest {

    Parser parser;
    @Before
    public void setup(){
        parser = new Parser();
    }

    @Test
    public void testOutputSplitter(){
        String givenString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##\n" +
                "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##\n" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##\n" +
                "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
        int expectedArrLength = 4;
        //: When
        int actualArrLength = parser.outputSplitter(givenString).length;
        //: Then
        Assert.assertEquals(expectedArrLength,actualArrLength);
    }

    @Test
    public void testNameParser(){
        //: Given
        String givenString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String expectedString = "Milk";
        //: When
        String actualString = parser.nameParser(givenString);
        //: Then
        Assert.assertEquals("the expected string output should be Milk", expectedString,actualString);
    }

    @Test
    public void testPriceParser(){
        //: Given
        String givenString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String expectedString = "3.23";
        //: When
        String actualString = parser.priceParser(givenString);
        //: Then
        Assert.assertEquals("the expected string output should be 3.23", expectedString,actualString);
    }

    @Test
    public void testExpirationParser(){
        //: Given
        String givenString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String expectedString = "1/25/2016";
        //: When
        String actualString = parser.expirationParser(givenString);
        //: Then
        Assert.assertEquals("the expected string output should be 1/25/2016", expectedString,actualString);
    }

    @Test
    public void testNullPriceParser(){
        //: Given
        String givenString = "naMe:Milk;price:;type:Food;expiration:1/25/2016##";
        int expectedErrorCounter = 1;
        //: When
        parser.priceParser(givenString);
        int actualErrorCounter = parser.getErrorCounter();
        //: Then
        Assert.assertEquals("the expected error counter should be 1", expectedErrorCounter,actualErrorCounter);
    }

    @Test
    public void testNullNameParser(){
        //: Given
        String givenString = "naMe:;price:3.23;type:Food;expiration:1/25/2016##";
        int expectedErrorCounter = 1;
        //: When
        parser.nameParser(givenString);
        int actualErrorCounter = parser.getErrorCounter();
        //: Then
        Assert.assertEquals("the expected string output should be 1", expectedErrorCounter,actualErrorCounter);
    }



}
