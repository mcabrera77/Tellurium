package TelluriumProj.Tellurium.src.main.java.Tellurium.Tellurium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;

import Tellurium.Tellurium.TestConfig;

public class UploadBOM extends TestCase
{
    public static Boolean UploadBOM(TestConfig config, WebDriver driver, Element test) {
    	try {
    		driver.findElement(By.linkText("Projects")).click();
    		driver.findElement(By.className("project-list-button")).click();
    		WebElement myDynamicElement1 = (new WebDriverWait(driver, 10))
    				  .until(new ExpectedCondition<WebElement>(){
    					@Override
    					public WebElement apply(WebDriver d) {
    						return d.findElement(By.id("edit-name"));
    					}});
    		driver.findElement(By.id("edit-name")).sendKeys(getStringValue(test, "project_name"));
    		driver.findElement(By.id("edit-submit")).click();
    		driver.findElement(By.className("right")).click();
    		driver.findElement(By.id("edit-concept")).click();
    		driver.findElement(By.id("edit-title")).sendKeys(getStringValue(test, "concept_name"));
    		driver.findElement(By.id("edit-lifetimefuncunits")).sendKeys(getStringValue(test, "lifetimefuncunits"));
    		driver.findElement(By.id("edit-editsbom")).click();
    		driver.findElement(By.cssSelector("img[src*='sm_import_bom']")).click();
    		driver.findElement(By.id("edit-upload")).sendKeys(getStringValue(test, "file_location"));
    		driver.findElement(By.id("edit-editsbom")).click();
    		WebElement myDynamicElement2 = (new WebDriverWait(driver, 10))
  				  .until(new ExpectedCondition<WebElement>(){
  					@Override
  					public WebElement apply(WebDriver d) {
  						return d.findElement(By.cssSelector("img[src*='sm_edit']"));
  					}});
    		driver.findElement(By.id("edit-editsbom")).click();
    		driver.findElement(By.linkText("Results")).click();
    	} catch (org.openqa.selenium.NoSuchElementException e) {
        	e.printStackTrace();
    	}
        return Boolean.TRUE;
    }
}
