package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Implementaicjom IRetyAnalyzer definisimo uslove za ponovno pokretanje fail-ovanih testova
public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 2;   //promeniti maxTry za zeljeni broj ponovljanja palih testova

    @Override
    public boolean retry(ITestResult iTestResult) {

        //Ako je test pao, obavesti listener da pokrene test ponovo dokle god je count<maxTry
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

}