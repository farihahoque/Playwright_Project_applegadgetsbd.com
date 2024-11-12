package Testcases;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestHomePage
{

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
    public void TestWebsiteTitle() throws InterruptedException {
        page.navigate(url);
        String actualTitle=page.title();
        System.out.println("Title: "+actualTitle);
       String expectedTitle= "Smartphones, Gadgets & Premium Accessories | Apple Gadgets";
       Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Success");
        Thread.sleep(5000);
    }

    @Test
    public void TestSearchBar() throws InterruptedException {
        page.navigate(url);
        ElementHandle Searchbar = page.querySelector("//input[@id='search']");
        Searchbar.fill("Mobile");
        ElementHandle SearchButton=page.querySelector("//i[@class='bi bi-search']");
        SearchButton.click();
        Thread.sleep(5000);
    }

    @Test
    public void HomepageHeaderOptions() throws InterruptedException {
        page.navigate(url);
        ElementHandle OfferOption= page.querySelector("//p[normalize-space()='Offers']");
        OfferOption.click();
        Thread.sleep(5000);
        page.goBack();
        Thread.sleep(5000);
        ElementHandle preorder = page.waitForSelector("//p[normalize-space()='Pre-Order']");
        preorder.click();
       Thread.sleep(5000);
    }


    @Test
    public void homePageMenu() throws InterruptedException {
        page.navigate(url);
        ElementHandle PowerBankOption= page.querySelector("//p[normalize-space()='Power Bank']");
        PowerBankOption.click();
        Thread.sleep(5000);
    }
    @Test
    public void Newarrivals() throws InterruptedException {
        page.navigate(url);
        ElementHandle Newarrivals= page.querySelector("//button[normalize-space()='Gadgets']");
        Newarrivals.scrollIntoViewIfNeeded();
        Newarrivals.click();
        Thread.sleep(5000);
    }

    @Test
    public void BuyNowFromHomepage() throws InterruptedException {
        page.navigate(url);
        ElementHandle Buynow= page.querySelector("//body[1]/div[1]/div[2]/section[5]/div[2]/article[10]/div[1]/button[1]");
        Buynow.scrollIntoViewIfNeeded();
        Buynow.click();
        Thread.sleep(5000);
    }

    @Test
    public void CompareFromHomepage() throws InterruptedException {
        page.navigate(url);
        ElementHandle Compare= page.querySelector("a[class='w-14 xl:w-[60px] h-14 xl:h-[60px] border-2 border-primary rounded text-primary hidden lg:flex flex-col gap-1 items-center justify-center hover:bg-primary hover:text-white duration-300']");
        Compare.scrollIntoViewIfNeeded();
        Compare.click();
        Thread.sleep(5000);
    }


    @Test
    public void FindShopOption() throws InterruptedException {
        page.navigate(url);
        ElementHandle FindShopOption= page.querySelector("//p[contains(@class,'text-xl tracking-wider')]");
        FindShopOption.click();
        Thread.sleep(5000);
    }
    @Test
    public void ContactOption() throws InterruptedException {
        page.navigate(url);
        ElementHandle ContactOption= page.querySelector("//a[normalize-space()='Contact Us']");
        ContactOption.scrollIntoViewIfNeeded();
        ContactOption.click();
        Thread.sleep(5000);

    }


    @Test
    public void TestSocialMediaOption() throws InterruptedException {
        page.navigate(url);
        //instagram
        ElementHandle SocialMediaOption1= page.querySelector("//a[contains(@aria-label,'instagram')]");
        SocialMediaOption1.scrollIntoViewIfNeeded();
        SocialMediaOption1.click();
        Thread.sleep(5000);

    }



    @AfterMethod
    public void closeBrowser() {
        page.close();
        browser.close();
        playwright.close();
    }

}



