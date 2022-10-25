package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {
    private static final String PROPERTIES_FILE = "app.properties";
    private Properties properties;
    private static Props instance;

    public Props() {loadProperties(PROPERTIES_FILE);}

    public static Props getInstance(){
        if(instance==null) instance = new Props();
        return instance;
    }
    private void loadProperties(String file){
        properties = new Properties();
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream in = loader.getResourceAsStream(file);
        if(in==null) return;
        try{
            properties.load(in);
        }catch(IOException e){ }

        try{
            in.close();
        }catch(IOException e){}
    }
    public String getProperty(String file){return properties.getProperty(file);}
}
