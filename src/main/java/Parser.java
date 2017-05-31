import org.apache.commons.io.IOUtils;

/**
 * Created by rahmirford on 5/31/17.
 */
public class Parser {
    private String[] dataOutputArr;
    private String result;


    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public String[] outputSplitter(String rawData){
        dataOutputArr = result.split("##");
        return dataOutputArr;
    }

    public String[] getDataOutputArr() {
        return dataOutputArr;
    }
}
