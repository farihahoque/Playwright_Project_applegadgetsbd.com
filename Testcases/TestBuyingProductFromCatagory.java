package Testcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBuyingProductFromCatagory {
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
    public void TestBuyProductFromFeaturedProduct() throws InterruptedException {
        page.navigate(url);
        Locator coverAndGlass = page.locator("//a[contains(text(),'Cover & Glass')]");
        coverAndGlass.click();

        ElementHandle ProductOption=page.waitForSelector("//p[normalize-space()='Spigen Optik Lens Protector for iPhone 13 Series']");
        ProductOption.scrollIntoViewIfNeeded();
        ProductOption.click();

        ElementHandle AddToCartOption=page.waitForSelector("button[class='rounded text-xs md:text-tiny font-SFProDisplay md:font-SFProDisplayBold tracking-wider duration-300 border border-primary text-primary h-8 lg:h-[42px] w-[106px] lg:w-[117px]']");
        AddToCartOption.scrollIntoViewIfNeeded();
        AddToCartOption.click();
        Thread.sleep(5000);
       ElementHandle Cart=page.waitForSelector("//p[normalize-space()='Cart(1)']");
       Cart.click();
        ElementHandle Checkout=page.waitForSelector("//button[normalize-space()='Check Out']");
        Checkout.scrollIntoViewIfNeeded();
        Checkout.click();
        Thread.sleep(5000);
    }

    @Test
    public void BuySameProductMultipleTimes() throws InterruptedException {
        page.navigate(url);
        Locator coverAndGlass = page.locator("//a[contains(text(),'Cover & Glass')]");
        coverAndGlass.click();

        ElementHandle ProductOption=page.waitForSelector("//p[normalize-space()='Spigen Optik Lens Protector for iPhone 13 Series']");
        ProductOption.scrollIntoViewIfNeeded();
        ProductOption.click();
        ElementHandle AddToCartOption=page.waitForSelector("button[class='rounded text-xs md:text-tiny font-SFProDisplay md:font-SFProDisplayBold tracking-wider duration-300 border border-primary text-primary h-8 lg:h-[42px] w-[106px] lg:w-[117px]']");
        AddToCartOption.scrollIntoViewIfNeeded();
        ElementHandle AddProduct=page.querySelector("//button[normalize-space()='+']");
        AddProduct.click();
        AddToCartOption.click();
        Thread.sleep(5000);
        ElementHandle Cart=page.waitForSelector("//p[normalize-space()='Cart(1)']");
        Cart.click();
        ElementHandle Checkout=page.waitForSelector("//button[normalize-space()='Check Out']");
        Checkout.scrollIntoViewIfNeeded();
        Checkout.click();
        Thread.sleep(5000);
    }

    @Test
    public void RemoveSameProductMultipleTimes() throws InterruptedException {
        page.navigate(url);
        Locator coverAndGlass = page.locator("//a[contains(text(),'Cover & Glass')]");
        coverAndGlass.click();

        ElementHandle ProductOption=page.waitForSelector("//p[normalize-space()='Spigen Optik Lens Protector for iPhone 13 Series']");
        ProductOption.scrollIntoViewIfNeeded();
        ProductOption.click();
        ElementHandle AddToCartOption=page.waitForSelector("button[class='rounded text-xs md:text-tiny font-SFProDisplay md:font-SFProDisplayBold tracking-wider duration-300 border border-primary text-primary h-8 lg:h-[42px] w-[106px] lg:w-[117px]']");
        AddToCartOption.scrollIntoViewIfNeeded();
        ElementHandle AddProduct=page.querySelector("//button[normalize-space()='+']");
        AddProduct.dblclick();
        ElementHandle RemoveProduct=page.querySelector("//button[normalize-space()='-']");
        RemoveProduct.click();

        AddToCartOption.click();
        Thread.sleep(5000);
        ElementHandle Cart=page.waitForSelector("//p[normalize-space()='Cart(1)']");
        Cart.click();
        ElementHandle Checkout=page.waitForSelector("//button[normalize-space()='Check Out']");
        Checkout.scrollIntoViewIfNeeded();
        Checkout.click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeBrowser() {
        page.close();
        browser.close();
        playwright.close();
    }

}
