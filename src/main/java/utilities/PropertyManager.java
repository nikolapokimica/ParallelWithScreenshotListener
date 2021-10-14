package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance = null;
    private static Properties properties = null;
    private static String driverPath, url, firstName,
                          lastName, loginPassword, loginEmail;


    private PropertyManager() {}

    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
            properties = new Properties();
            try {
                FileInputStream fis = new FileInputStream("src/main/resources/configuration.properties");
                properties.load(fis);
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            driverPath = properties.getProperty("driverPath");
            url = properties.getProperty("url");
            firstName = properties.getProperty("first_name");
            lastName = properties.getProperty("last_name");
            loginPassword = properties.getProperty("loginPassword");
            loginEmail = properties.getProperty("loginEmail");
        }

        return instance;
    }

    //radi smanjenja broja pristupa configuration.properties upis novih podataka je podeljen u dve metode
    public PropertyManager readyConfiguration(String key, String value) {
        properties.setProperty(key, value);
        return this;
    }

    public void setConfiguration() {
        try {
            PrintWriter pw = new PrintWriter("src/main/resources/configuration.properties");
            properties.store(pw, "Updated Configuration");
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        instance = null;
    }

    public String getDriverPath()  {
        return driverPath;
    }

    public String getUrl()  {
        return url;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getLoginEmail() {
        return loginEmail;
    }
}
