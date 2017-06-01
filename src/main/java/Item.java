import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rahmirford on 5/31/17.
 */
public class Item {
    private String itemName;
    private String itemPrice;
    private String itemType;
    private String itemExpiration;

    public Item(){}
    public Item(String name,String price, String type, String expiration){
        this.itemName = milkNameReplacer(name);
        this.itemPrice = price;
        this.itemType = type;
        this.itemExpiration = expiration;
    }

    // Replace scrambled item name with correct item name

    public String milkNameReplacer(String name){
        Pattern pattern = Pattern.compile("([mM]\\w{3})");
        Matcher match = pattern.matcher(name);
        itemName = match.replaceFirst("Milk");
        return itemName;

    }



    public String getName() {
        return itemName;
    }

    public String getPrice() {
        return itemPrice;
    }

    public String getType() {
        return itemType;
    }

    public String getExpiration() {
        return itemExpiration;
    }
}

