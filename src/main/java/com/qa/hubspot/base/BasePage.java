package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;	
	public WebDriver init_driver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			ChromeOptions opt=new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			System.setProperty("webdriver.chrome.driver",System.getProperty("D:\\TESTING\\drivers\\chromedriver_win32\\chromedriver.exe"));
			driver=new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("safari")) {

		} else {
			System.out.println(browserName + " Browser value is wrong, please pass the correct browser name....");
		}

		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		//driver.get("https://app.hubspot.com/login");
		

		return driver;
	}

	public Properties init_properties() {
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\hp\\workspace\\HubSpotHomeWork\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("config file is missing, please check it...");
		} catch (IOException e) {
			System.out.println("properties could not be loaded...");
			e.printStackTrace();
		}

		return prop;

	}


	
	
}
