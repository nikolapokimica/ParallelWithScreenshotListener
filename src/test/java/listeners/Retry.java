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
                //result.setStatus(ITestResult.SKIP);  //zasto se ova promena ovde ne cuva nego mora u TestListeneru da se setuje?
                return false;
            }
            if (count < maxTry) {
                System.out.println("Neuspesan " + count);
                count++;
                result.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
                return false;
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);
            return false;
        }
    }

}