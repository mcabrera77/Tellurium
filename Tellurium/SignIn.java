package TelluriumProj.Tellurium.src.main.java.Tellurium.Tellurium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;

import Tellurium.Tellurium.TestConfig;

public class SignIn extends TestCase
{
    public static Boolean login(TestConfig config, WebDriver driver, Element test) {

        driver.get(config.login_url);

        // Find the text input element by its name
        driver.findElement(By.name("name")).sendKeys(getStringValue(test, "login_id"));
        driver.findElement(By.name("pass")).sendKeys(getStringValue(test, "password"));
        driver.findElement(By.name("pass")).submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
//            	System.out.println("Page source is: \n" + d.getPageSource());
                return d.getPageSource().toLowerCase().indexOf("</html>") >= 0;
            }
        });
        
        if (driver.getPageSource().toLowerCase().indexOf("unrecognized username or password") < 0) {
        	System.out.println("Login Success \n" + getStringValue(test, "login_id") + " | " + getStringValue(test, "password"));
        	return Boolean.TRUE;
        } else {
        	System.out.println("Login Failure \n" + getStringValue(test, "login_id") + " | " + getStringValue(test, "password"));
        	return Boolean.FALSE;
        }
        
    }
    public static Boolean logout(TestConfig config, WebDriver driver, Element test) {
    	try {
    		driver.findElement(By.linkText("Logout")).click();
    	} catch (org.openqa.selenium.NoSuchElementException e) {
        	e.printStackTrace();
    	}
        return Boolean.TRUE;
    }
}
