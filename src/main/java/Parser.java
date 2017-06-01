import org.apache.commons.io.IOUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rahmirford on 5/31/17.
 */
public class Parser {
    private String[] dataOutputArr;
    private String result;
    private String fullRegexString = "(\\w{4}:)(\\w+)(;)(\\w{5}:)((\\d\\.\\d{2})?)(;)(type:Food)([;^%*!@])(expiration:)(\\d\\/\\d{2}\\/2016)";
    private String namePattern = "(^\\w{4}:)(\\w+)";
    private String pricePattern = "(\\w{4}:)((\\w*)?)(;)(\\w{5}:)(\\d\\.\\d{2})";
    private int errorCounter;


//
//    public String readRawDataToString() throws Exception{
//        ClassLoader classLoader = getClass().getClassLoader();
//        result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
//        return result;
//    }




    public String[] outputSplitter(String rawData) {
        Pattern pattern = Pattern.compile("##");
        dataOutputArr = pattern.split(rawData);
        return dataOutputArr;
    }

    public String[] getDataOutputArr() {
        return dataOutputArr;
    }

    public String nameParser(String stringToParse) throws NullPointerException {
        String itemName= "";
        Pattern nameRegex = Pattern.compile(this.namePattern);
        Matcher nameMatcher = nameRegex.matcher(stringToParse);
        try {
            if (nameMatcher.find()) {
                itemName = nameMatcher.group(2);
                return itemName;
            } else {
                throw new NullPointerException();
            }
        }catch (NullPointerException npe) {
             errorCounter++;
        }
        return itemName;
    }

    public String priceParser(String stringToParse) throws NullPointerException {
        String itemPrice = "";
        Pattern priceRegex = Pattern.compile(this.pricePattern);
        Matcher priceMatcher = priceRegex.matcher(stringToParse);
        try {
            if (priceMatcher.find()) {
                itemPrice = priceMatcher.group(6);
                return itemPrice;
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException npe) {
            errorCounter++;
        }
        return itemPrice;
    }

    public String expirationParser(String stringToParse) throws NullPointerException {
        String itemExpiration= "";
        Pattern ExpirationRegex = Pattern.compile(fullRegexString);
        Matcher ExpirationMatcher = ExpirationRegex.matcher(stringToParse);
        try {
            if (ExpirationMatcher.find()) {
                itemExpiration = ExpirationMatcher.group(11);
                return itemExpiration;
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException npe) {
            errorCounter++;
        }
        return itemExpiration;
    }



    public int getErrorCounter() {
        return errorCounter;
    }
}

