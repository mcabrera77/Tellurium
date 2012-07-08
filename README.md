LoginTest
=========
package SustainableMindsProj.SustainableMindsProj;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



public class LoginTest {
  private WebDriver driver;
	WebElement element;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.sustainableminds.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	@Test
	public void testLogging() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("edit-name")).clear();
		driver.findElement(By.id("edit-name")).sendKeys("username");
		driver.findElement(By.id("edit-pass")).clear();
		driver.findElement(By.id("edit-pass")).sendKeys("password");
		
		try {
		    element = driver.findElement(By.id("edit-pass"));
		    element.click();
		    } catch (Exception e){
		        System.out.println("Error submitting: " + e.toString());
		    }
		
		driver.findElement(By.name("op")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	 public static Boolean logout(WebDriver driver) {
		 driver.findElement(By.linkText("Logout")).click();

	        return Boolean.TRUE;

		}
	}
