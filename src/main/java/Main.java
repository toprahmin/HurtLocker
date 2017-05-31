import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws Exception{
        String output = (new Parser()).readRawDataToString();
        System.out.println(output);




    }
}
