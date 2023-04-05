package BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	public static WebDriver driver;

	public static void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		}
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void getTitle() {
		System.out.println(driver.getTitle());
	}

	public static void getCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void navigateTo(String navigateURl) {
		driver.navigate().to(navigateURl);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public static boolean isSelected(WebElement element) {
		return element.isSelected();
	}

	public static boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public static void takesSreenShot(String imageName, String projectName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("F:\\Selenium\\" + projectName + "\\Screenshot" + imageName + ".png");
		FileUtils.copyFile(sourceFile, destinationFile);
	}

	public static void alertMethod(String choice) {
		if (choice.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (choice.equalsIgnoreCase("Dismiss")) {
			driver.switchTo().alert().dismiss();
		} else if (choice.equalsIgnoreCase("getText")) {
			System.out.println(driver.switchTo().alert().getText());
		} else if (choice.equalsIgnoreCase(choice)) {
			driver.switchTo().alert().sendKeys(choice);
			driver.switchTo().alert().accept();
		}
	}

	public static void actionsMthod(WebDriver driver, String choice, WebElement element) {
		Actions action = new Actions(driver);

		if (choice.equalsIgnoreCase("click")) {

			action.click(element).build().perform();
		} else if (choice.equalsIgnoreCase("Move")) {

			action.moveToElement(element).build().perform();
		} else if (choice.equalsIgnoreCase("double click")) {

			action.doubleClick(element).build().perform();
		} else if (choice.equalsIgnoreCase("right click")) {

			action.contextClick(element).build().perform();
		}
	}

	public static void frames(String framename, Object name) {
		if (framename.equalsIgnoreCase("WebElement")) {
			driver.switchTo().frame((WebElement) name);
		} else if (framename.equalsIgnoreCase("name")) {
			driver.switchTo().frame((String) name);
		} else if (framename.equalsIgnoreCase("id")) {

			driver.switchTo().frame(Integer.parseInt((String) name));
		}
	}

	public static void dropDown(String value, WebElement element, String input) {
		Select select = new Select(element);
		if (value.equalsIgnoreCase("value")) {
			select.selectByValue(input);
		} else if (value.equalsIgnoreCase("visibleText")) {
			select.selectByVisibleText(input);
		} else if (value.equalsIgnoreCase("index")) {

			select.selectByIndex(Integer.parseInt(input));
		}
	}

	public static void multipledropDown(WebElement element, String value) {
		Select select = new Select(element);
		if (value.equalsIgnoreCase("multiple")) {

			System.out.println(select.isMultiple());
		} else if (value.equalsIgnoreCase("firstSelectedoptions")) {

			System.out.println(select.getFirstSelectedOption());
		} else if (value.equalsIgnoreCase("allSelectedoptions")) {

			System.out.println(select.getAllSelectedOptions());
		}
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void sendKeys(WebElement element, String name) {
		element.sendKeys(name);
	}

	public static void implicitWait(long time) {

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void explicitWait(long time, String condition, By element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		if (condition.equalsIgnoreCase("ElementLocated")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
		} else if (condition.equalsIgnoreCase("clickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} else if (condition.equalsIgnoreCase("selected")) {
			wait.until(ExpectedConditions.elementToBeSelected(element));
		}
	}

	public static void getText(WebElement element) {
		System.out.println(element.getText());
	}

	public static void scrollingMethod(String name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (name.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollBy(0,2000)");

		} else if (name.equalsIgnoreCase("up")) {
			js.executeScript("window.scrollBy(0,-2000)");

		}
	}

	public static void getAttribute(String name, WebElement element) {

		element.getAttribute(name);
	}

	public static void findElementsMethod(List<WebElement> list, String givenData, WebElement element) {

		for (WebElement getList : list) {
			getText(getList);
			if (getList.getText().contains(givenData)) {
				click(element);
			}
		}
	}

	public static void windowHandling() {
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> it = allwindow.iterator();
		while (it.hasNext()) {
			String next = it.next();
			driver.switchTo().window(next);
		}

	}

	public static void getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> optionElement = select.getOptions();
		for (WebElement newOptionsList : optionElement) {
			System.out.println(newOptionsList.getText());

		}

	}

	public static void robot(String value) throws AWTException {
		Robot robot = new Robot();
		if (value.equalsIgnoreCase("down")) {
			robot.keyPress(KeyEvent.VK_DOWN);
		}
		if (value.equalsIgnoreCase("enter")) {
			robot.keyPress(KeyEvent.VK_ENTER);
		}
	}
}