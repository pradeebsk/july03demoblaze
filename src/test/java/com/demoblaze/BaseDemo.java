package com.demoblaze;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDemo {
		public static WebDriver driver;
		public static JavascriptExecutor js = (JavascriptExecutor) driver;
        
		public void getDriver() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		}

		public void getUrl(String url) {
			driver.get(url);
		}
		public void windowsMax() {
			driver.manage().window().maximize();
		}

		public void refreshWindows() {
			driver.navigate().refresh();
		}
		public void sendText(WebElement element,String keysToSend){
			element.sendKeys(keysToSend);
		}
		public void textSendByJs(WebElement element, String keysToSend) {
			js.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);
		}

		public void screenCapture(String name) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File Target = new File("C:\\Users\\Admin\\Pictures\\screenshots\\" + name + "adact.png");
			FileUtils.copyFile(source, Target);
		}
		
		public void frameSwitch(WebElement element) {
			driver.switchTo().frame(element);
		
		}
		public void selectByValue(WebElement element ,String value) {
			Select s =new Select(element);
			s.selectByValue(value);
		}
		public void switchingWindows(int index) {
			Set<String>allWindowsId=driver.getWindowHandles();
			List<String> list = new LinkedList<String>();
			list.addAll(allWindowsId);
			String childWindowsId=list.get(index);
			driver.switchTo().window(childWindowsId);		

		}
		public String getWindowsId(int index) {
			Set<String>allWindowsId=driver.getWindowHandles();
			List<String> list = new LinkedList<String>();
			list.addAll(allWindowsId);
			String childWindowsId= list.get(index);
			return childWindowsId;

		}
		public void switchToWindows(String childWindowsId) {
			driver.switchTo().window(childWindowsId);
		}
		
	}

