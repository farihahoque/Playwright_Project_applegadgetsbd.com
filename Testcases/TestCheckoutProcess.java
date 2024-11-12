package Testcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCheckoutProcess {
    Playwright playwright;
    BrowserType browserType;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected String url = "https://www.applegadgetsbd.com/";

    @BeforeMethod
    public void startChromoBrowser() throws InterruptedException {
        playwright = Playwright.create();
        browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));//headless mode =browser visible(headless mode true means browser open hobena)
        context = browser.newContext(new Browser.NewContextOptions());

        page = browser.newPage();
        Thread.sleep(3000);
        page.navigate(url);
        Thread.sleep(10000);

        Locator coverAndGlass = page.locator("//a[contains(text(),'Cover & Glass')]");
        coverAndGlass.click();

        ElementHandle ProductOption=page.waitForSelector("//p[normalize-space()='Spigen Optik Lens Protector for iPhone 13 Series']");
        ProductOption.scrollIntoViewIfNeeded();
        ProductOption.click();

        ElementHandle AddToCartOption=page.waitForSelector("button[class='rounded text-xs md:text-tiny font-SFProDisplay md:font-SFProDisplayBold tracking-wider duration-300 border border-primary text-primary h-8 lg:h-[42px] w-[106px] lg:w-[117px]']");
        AddToCartOption.scrollIntoViewIfNeeded();
        AddToCartOption.click();

        ElementHandle Cart=page.waitForSelector("//p[normalize-space()='Cart(1)']");
        Cart.click();
        ElementHandle Checkout=page.waitForSelector("//button[normalize-space()='Check Out']");
        Checkout.scrollIntoViewIfNeeded();
        Checkout.click();
        Thread.sleep(5000);
    }

    @Test
    public void TestCODWithRightCredentials() throws InterruptedException {

        ElementHandle firstname = page.waitForSelector("//input[@id='first_name']");
        firstname.fill("farahq");
        ElementHandle phnnum = page.waitForSelector("//input[@id='phone']");
        phnnum.fill("01798178034");

        ElementHandle fullAddress = page.querySelector("//textarea[@id='address']");
        fullAddress.scrollIntoViewIfNeeded();
        fullAddress.fill("dhanmondi 12/A");

        ElementHandle SubmitOption = page.querySelector("div[class='justify-end max-w-[210px] flex'] button[type='submit']");
        SubmitOption.scrollIntoViewIfNeeded();
        SubmitOption.isVisible();
        Thread.sleep(5000);
    }

    @Test
    public void TestOnlinePayment() throws InterruptedException {
        ElementHandle OnlinePayment=page.waitForSelector("//button[normalize-space()='Online Payment']");
        OnlinePayment.dblclick();
        ElementHandle firstname = page.waitForSelector("//input[@id='first_name']");
        firstname.fill("farahq");
        ElementHandle email = page.waitForSelector("//input[@id='email']");
        email.fill("farihahoque12@gmail.com");
        ElementHandle phnnum = page.waitForSelector("//input[@id='phone']");
        phnnum.fill("01798178036");
        ElementHandle fullAddress = page.querySelector("//textarea[@id='address']");
        fullAddress.scrollIntoViewIfNeeded();
        fullAddress.fill("dhanmondi 12/A");
        Thread.sleep(5000);
    }


    @AfterMethod
    public void closeBrowser() {
        page.close();
        browser.close();
        playwright.close();
    }
    }

