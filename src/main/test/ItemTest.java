import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rahmirford on 6/1/17.
 */
public class ItemTest {

    Item item;

    @Before
    public void setup (){
        item = new Item("milk","3.25","Food","1/12/2016");
    }

    @Test
    public void TestMilkNameReplace(){
        Item item = new Item("milk","3.25","Food","1/12/2016");
        String expectedName = "Milk";
        String actualName = item.getName();
        Assert.assertEquals("The expected item name is Milk", expectedName,actualName);
    }

}
