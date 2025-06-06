package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",//raporlarin daha ikunakli olmasi icin
                "html:ExtentReports/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failed_scenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,//raporlarin consoleda okunakli sekilde cikmasi icin
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@smoke",
        dryRun = false
)
public class Runner {

// RAPORLARIN OLUSMASI ICIN RUNNERDAN CALISTIRMAK GEREKIYOR.
// FAIL SENARYOLARIN RESIMLERİ RAPORLARA EKLENMEKTEDIR.

}
