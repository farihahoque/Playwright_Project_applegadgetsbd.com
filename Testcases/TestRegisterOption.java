package Testcases;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRegisterOption {
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
        Thread.sleep(10000);
    }

    @Test
    public void RegisterTestWithValidCredentials() throws InterruptedException {

        page.navigate(url);

        ElementHandle RegisterOption= page.querySelector("//p[normalize-space()='Account']");
        RegisterOption.click();
        Thread.sleep(10000);
        ElementHandle registerbutton=page.waitForSelector(" //button[normalize-space()='Register']");
        registerbutton.hover();
        registerbutton.click();
        ElementHandle Registerefirstname= page.querySelector("//input[@id='signupFirstName']");
        Registerefirstname.fill("fariha");
        Thread.sleep(5000);
        ElementHandle Registerelastname= page.querySelector("//input[@id='signupLastName']");
        Registerelastname.fill("hq");

        ElementHandle Registerphn= page.querySelector("//input[@id='signupPhone']");
        Registerphn.fill("017981*****");

        ElementHandle Registeremail= page.querySelector("//input[@id='signupEmail']");
        Registeremail.fill("farihahoque1610@gmail.com");

        ElementHandle Registerpass= page.querySelector("//input[@id='signupPassword']");
        Registerpass.scrollIntoViewIfNeeded();
        Registerpass.fill("farahq123");

        ElementHandle Registerconfirmpass= page.querySelector("//input[@id='signupConfPassword']");
        Registerconfirmpass.scrollIntoViewIfNeeded();
        Registerconfirmpass.fill("farahq123");

        ElementHandle regsubmit= page.querySelector("//button[normalize-space()='Create account']");
        regsubmit.scrollIntoViewIfNeeded();
        regsubmit.isVisible();
        Thread.sleep(5000);

    }


    @AfterMethod
    public void closeBrowser() {
        page.close();
        browser.close();
        playwright.close();
    }
}
