package testScripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

public class ExampleReports {

    @Test
    public void test(){
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./report.html");
        extentReports.attachReporter(sparkReporter);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Arvind");
        sparkReporter.config().setTheme(Theme.STANDARD);

       ExtentTest log =  extentReports.createTest("test 1");

       log.pass("Logon test started successfully");
       log.fail("Logon test failed");
       log.info("Logon test Information");
       log.warning("Logon test warning");
        log.skip("Logon test skip");

        ExtentTest log2 =  extentReports.createTest("test 2");

        log2.pass("Logon test started successfully");
        log2.fail("Logon test failed");
        log2.info("Logon test Information");
        log2.warning("Logon test warning");
        log2.skip("Logon test skip");

        extentReports.flush();


    }

}
