package Testcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSearchBarInHomepage {
    Playwright playwright;
    BrowserType browserType;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected String url="https://www.applegadgetsbd.com/";
    @BeforeMethod
    public void startChromoBrowser() throws InterruptedException {
        playwright = Playwright.create();
        browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions());

        page = browser.newPage();
        Thread.sleep(3000);
        page.navigate(url);

    }

    @Test
    public void TestSearchBar() throws InterruptedException {
        page.navigate(url);
        ElementHandle searchbar=page.querySelector("//input[@id='search']");
        searchbar.click();
        searchbar.fill("Mobile");
        ElementHandle searchicon=page.waitForSelector(("//i[@class='bi bi-search']"));
        searchicon.click();
        Thread.sleep(3000);
    }


    @Test
    public void TestPutBlankText() throws InterruptedException {
        page.navigate(url);
        ElementHandle searchbar=page.querySelector("//input[@id='search']");
        searchbar.click();
        searchbar.fill(" ");
        ElementHandle searchicon=page.waitForSelector(("//i[@class='bi bi-search']"));
        searchicon.click();
        Thread.sleep(3000);
        //No Error Msg is Displayed
    }


    @AfterMethod
    public void closeBrowser() {
        page.close();
        browser.close();
        playwright.close();
    }
}
