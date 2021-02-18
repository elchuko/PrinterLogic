package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHelper {
    private String result = "";
    private InputStream inputStream;

    public String getBroserFromPropValues() throws IOException{

        try{
            Properties prop = new Properties();
            String profFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(profFileName);

            if(inputStream!= null){
                prop.load(inputStream);
            }else{
                throw new FileNotFoundException("file not found");
            }

            result = prop.getProperty("Browser");
        }
        catch(Exception e){
            result = "Chrome";
        }finally {
            inputStream.close();
        }
        return result;
    }
}
