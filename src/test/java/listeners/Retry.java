package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.lang.annotation.Annotation;
import java.util.Arrays;

//Implementaicjom IRetryAnalyzer definisimo uslove za ponovno pokretanje fail-ovanih testova
public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 2;   //promeniti maxTry za zeljeni broj ponovljanja palih testova

    @Override
    public boolean retry(ITestResult result) {
        //Ako je test pao, obavesti listener da pokrene test ponovo dokle god je count<maxTry
        if (!result.isSuccess()) {
            //ako je test pao a pripada grupi InDevelopment, nece se ponovo pokrenuti
            if (Arrays.asList(result.getMethod().getGroups()).contains("InDevelopment")) {
                return false;
            }
            if (count < maxTry) {
                count++;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}