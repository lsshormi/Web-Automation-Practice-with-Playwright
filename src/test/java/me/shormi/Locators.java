package me.shormi;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Locators {
    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    @BeforeSuite
    public void start(){
        playwright = Playwright.create();
        browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browser.newPage();
        System.out.println("Browser version: " + browser.version());
    }

    @Test (priority = 0)
    public void openUrl() throws InterruptedException {
        Thread.sleep(2000);
        page.navigate("https://testing-and-learning-hub.vercel.app/Selenium/pages/registration_form.html");
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void locateByID() throws InterruptedException {
        ElementHandle first_name = page.querySelector("#first-name"); // by ID
        first_name.fill("Lasmin");
        Thread.sleep(3000);

    }

    @Test (priority = 2)
    public void locateByName() throws InterruptedException {
        ElementHandle last_name = page.querySelector("[name='last-name']"); // by Name
        last_name.fill("Shormi");
        Thread.sleep(3000);
    }

    @AfterSuite
    public void stop(){
        page.close();
        browser.close();
        playwright.close();
    }

}
