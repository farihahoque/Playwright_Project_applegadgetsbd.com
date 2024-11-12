package Testcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCart {
    Playwright playwright;
    BrowserType browserType;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected String url="https://www.applegadgetsbd.com/";
    @BeforeMethod
    public void startChromoBrowser() throws InterruptedException {
        playwright=Playwright.create();
        browserType=playwright.chromium();
        browser=browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        context=browser.newContext(new Browser.NewContextOptions());

        page=browser.newPage();
        Thread.sleep(3000);
        page.navigate(url);

    }

    @Test
    public void TestCartOption() throws InterruptedException {
        ElementHandle Cart=page.waitForSelector("//p[normalize-space()='Cart(0)']");
        Cart.click();
        Thread.sleep(5000);
    }



    @Test
    public void TestCartMessageWhenNoProductIsAdded() throws InterruptedException {
        ElementHandle Cart=page.waitForSelector("//p[normalize-space()='Cart(0)']");
        Cart.click();
        String PageTitle=page.title();
        System.out.println("Title: "+PageTitle);
        ElementHandle NoProductMsg= page.querySelector(".font-SFProDisplaySemibold.text-3xl");
        NoProductMsg.isVisible();
        ElementHandle BuyProductToCheckout=page.querySelector("//p[@class='text-base']");
        BuyProductToCheckout.isVisible();
        Thread.sleep(5000);
        ElementHandle ReturnHomeOption=page.querySelector("//a[normalize-space()='Return Home']");
        ReturnHomeOption.dblclick();
        Thread.sleep(5000);

    }
    @AfterMethod
    public void closeBrowser() {
        page.close();
        browser.close();
        playwright.close();
    }

}
