import org.apache.commons.io.IOUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rahmirford on 5/31/17.
 */
public class Parser {
    private String[] dataOutputArr;
    private String result;
    private String fullRegexString = "(\\w{4}:)((\\w*)?)(;)(\\w{5}:)((\\d\\.\\d{2})?)(;)(type:Food)([;^%*!@])(expiration:)(\\d\\/\\d{2}\\/2016)";
    private String name = "(^\\w{4}:)";
    private String item = "";
    private String price;
    private int errorCounter;


//
//    public String readRawDataToString() throws Exception{
//        ClassLoader classLoader = getClass().getClassLoader();
//        result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
//        return result;
//    }

    Pattern pattern = Pattern.compile("##");


    public String[] outputSplitter(String rawData) {
        dataOutputArr = pattern.split(rawData);
        return dataOutputArr;
    }

    public String[] getDataOutputArr() {
        return dataOutputArr;
    }

    public String nameParser(String stringToParse, String regex) throws NullPointerException {
        String itemName= "";
        Pattern nameRegex = Pattern.compile(regex);
        Matcher nameMatcher = nameRegex.matcher(stringToParse);
        try {
            if (nameMatcher.find()) {
                itemName = nameMatcher.group(2);
                return itemName;
            }
        } catch (NullPointerException npe) {
            errorCounter++;
        }
        return itemName;
    }

    public String priceParser(String stringToParse, String regex) throws NullPointerException {
        String itemPrice= "";
        Pattern priceRegex = Pattern.compile(regex);
        Matcher priceMatcher = priceRegex.matcher(stringToParse);
        try {
            if (priceMatcher.find()) {
                itemPrice = priceMatcher.group(2);
                return itemPrice;
            }
        } catch (NullPointerException npe) {
            errorCounter++;
        }
        return itemPrice;
    }
}

