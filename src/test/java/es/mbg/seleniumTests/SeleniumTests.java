package es.mbg.seleniumTests;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class SeleniumTests extends TestCase {
	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
//		System.setProperty("phantomjs.binary.path", "F:\\firefoxWebDriver\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//		driver = new PhantomJSDriver();--> Para ejecutar los tests sin abrir el navegador
		System.setProperty("webdriver.gecko.driver", "f:\\firefoxWebDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		driver.get("https://www.marca.com/");
		driver.findElement(By.linkText("El Barça se regula en exceso")).click();
		driver.findElement(By.id("video-5c685a1d268e3e68558b4587_0_d4npgllc5c688520b257c_playBtn")).click();
		driver.findElement(By.linkText("Comenta")).click();
	}
	
	  @Test
	  public void testUntitledTestCase2() throws Exception {
	    driver.get("https://worldcupfifa18.herokuapp.com/");
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("test@gmail.com");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("test1234");
	    driver.findElement(By.name("Submit")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Grupo-C'])[1]/following::label[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Logout'])[1]/following::button[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Manuel Beltrán (test@gmail.com)'])[1]/preceding::button[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Grupo-G'])[1]/following::label[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Grupo-F'])[1]/following::label[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Grupo-C'])[1]/following::label[1]")).click();
	    driver.findElement(By.name("registration")).click();
	  }
	
	  @Test
	  public void testHoras() throws Exception {
	    driver.get("https://iaweb.atmira.com/IA/login.do");
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("XXXX");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("XXXX");
	    driver.findElement(By.xpath("//input[@value='Entrar']")).click();
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("XXX");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("XXX");
	    driver.findElement(By.xpath("//input[@value='Entrar']")).click();
	    driver.findElement(By.id("imgDespPrjI0085")).click();
	    driver.findElement(By.id("cuerpo")).click();
	    driver.findElement(By.linkText("Dietas")).click();
	    driver.findElement(By.linkText("Histórico D.")).click();
	    driver.findElement(By.linkText("Guardias")).click();
	    driver.findElement(By.linkText("Histórico G.")).click();
	    driver.findElement(By.linkText("Salir")).click();
	  }
	  

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
