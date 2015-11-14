package com.quickauto.tests;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests {

	private static AndroidDriver androidDriver;

	@BeforeTest(alwaysRun = true)
	public void begin() throws MalformedURLException, InterruptedException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("automationName", "Appium");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceType", "phone");
		desiredCapabilities.setCapability("deviceName", "Android Emulator");
		desiredCapabilities.setCapability(CapabilityType.PLATFORM, "Mac");
		// desiredCapabilities.setCapability(CapabilityType.PLATFORM,
		// "WINDOWS");
		desiredCapabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,
				true);
		desiredCapabilities.setCapability(CapabilityType.HAS_TOUCHSCREEN, true);
		desiredCapabilities.setCapability("app", System.getProperty("user.dir")
				+ "/Myntra-Android-release153.apk");
		desiredCapabilities.setCapability("appPackage", "com.myntra.android");
		desiredCapabilities.setCapability("appActivity",
				"com.myntra.android.activities.LoginRegisterActivity");
		desiredCapabilities.setCapability("appWaitActivity",
				"com.myntra.android.activities.LoginRegisterActivity");
		androidDriver = new AndroidDriver<>(new URL(
				"http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		Thread.sleep(5000);
	}

	@Test
	public void testLogin() throws InterruptedException {
		WebElement loginButton = androidDriver
				.findElement(By
						.xpath("//*[@resource-id='com.myntra.android:id/btn_loginregister_continue_signin']"));
		loginButton.click();
		WebElement userNameTextbox = androidDriver
				.findElement(By
						.xpath("//*[@resource-id='com.myntra.android:id/et_email_address']"));
		userNameTextbox.sendKeys("abc@myntra.com");
		WebElement passwordTextbox = androidDriver
				.findElement(By
						.xpath("//*[@resource-id='com.myntra.android:id/et_loginregister_password']"));
		passwordTextbox.sendKeys("abcdefg");
		Assert.assertTrue(
				"",
				androidDriver.findElement(
						By.xpath("//android.widget.ImageView[1]"))
						.isDisplayed());
		WebElement signInButton = androidDriver
				.findElement(By
						.xpath("//*[@resource-id='com.myntra.android:id/btn_loginregister_continue_signin']"));
		signInButton.click();
		Thread.sleep(10000);
		androidDriver.quit();
	}
}
