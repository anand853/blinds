package com.pack.build;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Automate {

	static WebDriver driver;
	static Actions action;
	static WebElement element;
	static String url = "https://www.blinds.com";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Anand\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();

		Actions action = new Actions(driver);

		WebElement mainMenu = driver.findElement(By.xpath("/html/body/header/div[3]/div/nav/ul/li[1]/a"));
		action.moveToElement(mainMenu)
				.moveToElement(
						driver.findElement(By.xpath("/html/body/header/div[3]/div/nav/ul/li[1]/ul/li[1]/ul/li[2]/a")))
				.click().build().perform();

		// count

		List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='bdc-product-search-result']"));

		for (WebElement element : allElements) {
			System.out.println("the size is =>" + element.getSize());
		}

		// select width


		Select width = new Select(driver.findElement(By.id("SelectedWidth")));

		width.selectByValue("38");

		Thread.sleep(5000);

		Select height = new Select(driver.findElement(By.id("SelectedHeight")));

		height.selectByValue("46");

		Thread.sleep(5000);

		driver.findElement(By.className("bdc-searchfilter-priceupdate-button")).click();
		
		for (WebElement element : allElements) {
			System.out.println("the size is =>" + element.getSize());
		}

	}

}
