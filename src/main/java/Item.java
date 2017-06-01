/**
 * Created by rahmirford on 5/31/17.
 */
public class Item {
    private String itemname;
    private String itemprice;
    private String itemtype;
    private String itemexpiration;

    public Item(String name,String price, String type, String expiration){
        this.itemname = name;
        this.itemprice = price;
        this.itemtype = type;
        this.itemexpiration = expiration;
    }

    public String getName() {
        return itemname;
    }

    public String getPrice() {
        return itemprice;
    }

    public String getType() {
        return itemtype;
    }

    public String getExpiration() {
        return itemexpiration;
    }
}

