package TelluriumProj;
import static org.junit.Assert.*;

import org.openqa.jetty.html.Element;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import TelluriumProj.Tellurium.src.main.java.Tellurium.Tellurium.TestCase;


public class SMBomTest extends TestCase
{

@SuppressWarnings("unused")
public static Boolean SMBomTest(TestInterface config , WebDriver driver, Element test) {
	try {
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.className("project-list-button")).click();
		WebElement myDynamicElement1 = (new WebDriverWait(driver, 10))
		.until(new ExpectedCondition<WebElement>(){
		@Override
		public WebElement apply(WebDriver d) {
		return d.findElement(By.id("edit-name"));
		}});
		driver.findElement(By.id("edit-submit")).click();
		driver.findElement(By.id("edit-name")).sendKeys("Small_BOM");
		driver.findElement(By.id("edit-submit")).click();
		driver.findElement(By.id("edit-submit")).click();
		driver.findElement(By.id("edit-submit")).click();
		driver.findElement(By.id("main-content")).click();
		driver.findElement(By.id("edit-concept")).click();
		driver.findElement(By.id("edit-title")).clear();
		driver.findElement(By.id("edit-title")).sendKeys("Tiny");
		driver.findElement(By.id("edit-lifetimefuncunits")).sendKeys("3650");
		driver.findElement(By.id("edit-editsbom")).click();
		driver.findElement(By.cssSelector("img[alt=\"Import Bom\"]")).click();
		driver.findElement(By.id("edit-upload")).clear();
		driver.findElement(By.id("edit-upload")).sendKeys("/Users/mercedesnunez/Desktop/SM_BOMTiny.txt");
		driver.findElement(By.id("edit-editsbom")).click();
		driver.findElement(By.id("edit-editsbom")).click();
		assertEquals("Items successfully imported: 4 of 4", driver.findElement(By.cssSelector("p")).getText());
		driver.findElement(By.linkText("Results")).click();
	    assertEquals("0.48\nmPts per\n1 hour of use", driver.findElement(By.cssSelector("div.gl-emphesis.big-score-wrapper")).getText());
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.linkText("Delete")).click();
		assertEquals("Project was deleted.", driver.findElement(By.cssSelector("div.gl-emphesis.big-score-wrapper")).getText());
		
		driver.findElement(By.id("edit-editsbom")).click();
 		driver.findElement(By.linkText("Results")).click();
 	} 
	catch (org.openqa.selenium.NoSuchElementException e) {
     	e.printStackTrace();
 	}
     return Boolean.TRUE;
 }
}
