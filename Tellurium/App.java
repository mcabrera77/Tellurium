package TelluriumProj.Tellurium.src.main.java.Tellurium.Tellurium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class App 
{
    public static void main(String[] args) {
    	// Download the necessary executables
    	// and set up the required system properties...
    	
    	// Download chromedriver.exe from http://code.google.com/p/chromedriver/downloads/list
		// and change the following path accordingly
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohini Sharma\\Desktop\\chromedriver.exe");
		
		// Download IEDriverServer.exe from http://code.google.com/p/selenium/downloads/list
		// and change the following path accordingly
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Mohini Sharma\\Desktop\\IEDriverServer.exe");
		
		

        TestConfig config = new TestConfig("config.xml");
		
		for (String b : config.browserNames) {
			if (b.equalsIgnoreCase("Firefox")) {
				WebDriver driver = new FirefoxDriver();
				TestPlan testplan = new TestPlan(config, driver, "testplan.xml");
				driver.quit();
			}
			else if (b.equalsIgnoreCase("Chrome")) {
				WebDriver driver = new ChromeDriver();
				TestPlan testplan = new TestPlan(config, driver, "testplan.xml");
				driver.quit();
			}
			else if (b.equalsIgnoreCase("InternetExplorer")) {
				WebDriver driver = new InternetExplorerDriver();
				TestPlan testplan = new TestPlan(config, driver, "testplan.xml");
				driver.quit();
			}
			else {
				System.out.println("ERROR: Unsupported Browser ..." + b);
			}
		}
    }
}
