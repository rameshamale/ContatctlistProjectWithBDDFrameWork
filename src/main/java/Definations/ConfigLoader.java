package Definations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties = new Properties();

    public ConfigLoader(String filePath) throws IOException {
        try (InputStream input=new FileInputStream(filePath)){
            properties.load(input);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }

}
