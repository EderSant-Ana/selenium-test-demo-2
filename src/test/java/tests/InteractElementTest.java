package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractElementTest {

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(); 
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://marcelodebittencourt.com/demopages/demosimplesearch/");
		assertTrue("Título da página difere do esperado", driver.getTitle().contentEquals("Demo Simple Search using JavaScript"));
		WebElement input = driver.findElement(By.id("textbox"));
		
		String search_text = "Selenium";
		
		String[] letters = search_text.split("");
		for (String letter: letters) {
			input.sendKeys(letter);
			Thread.sleep(100);
		}
				
		WebElement button = driver.findElement(By.xpath("//*[@id=\"button1\"]"));
		button.click();
		
		assertTrue("Conteúdo diferente do esperado", driver.findElement(By.id("result")).getText().contentEquals("Selenium"));
		String result = driver.findElement(By.id("result")).getText();
		System.out.println(result);
	}

}
