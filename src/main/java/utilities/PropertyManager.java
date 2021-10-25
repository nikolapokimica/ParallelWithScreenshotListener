package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

//Property Manager je implementiran kao singleton klasa. U svakom trenutku ce postajati samo jedna instanca.
public class PropertyManager {

    private static PropertyManager instance = null;
    private static Properties properties = null;
    private static String driverPath, homePageUrl, loginPageUrl, firstName,
                          lastName, loginPassword, loginEmail;


    private PropertyManager() {}

    public static PropertyManager getInstance() {

        //Ako ne postoji instanca, kreiraj PropertyManager. Ovo ce se desiti prvi put kada se pozove getInstance()
        // i kada se pozove getInstance nakon setConfiguration()
        if (instance == null) {
            instance = new PropertyManager();

            //cita configuration.properties i cuva u objekat properties kao mapu
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

            //cita entry-e iz properties
            driverPath = properties.getProperty("driverPath");
            homePageUrl = properties.getProperty("url");
            firstName = properties.getProperty("first_name");
            lastName = properties.getProperty("last_name");
            loginPassword = properties.getProperty("loginPassword");
            loginEmail = properties.getProperty("loginEmail");
            loginPageUrl = properties.getProperty("login_url");
        }

        return instance;
    }

    //radi smanjenja broja pristupa configuration.properties upis novih podataka je podeljen u dve metode
    //dodaje novi entry u properties, koji cemo kasnije ceo upisati u configuration.properties sa metodom setConfiguration()
    public synchronized PropertyManager readyConfiguration(String key, String value) {
        properties.setProperty(key, value);
        return this;
    }

    //Zamenjuje citav sadrzaj configuration.properties sa celokupnim sadrzajem iz properties i setuje instance na null
    //tako pri sledecem pozivu getInstance() pravi se novi objekat PropertyManager-a i dobijamo validne nove podatke
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

    public String getHomePageUrl()  {
        return homePageUrl;
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

    public String getLoginPageUrl() { return loginPageUrl; }
}
