package Testcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest {

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
public void LoginWithValidCredentials() throws InterruptedException {

        page.navigate(url);

      ElementHandle LoginOption= page.querySelector("//p[normalize-space()='Account']");
      LoginOption.click();
      Thread.sleep(10000);
      ElementHandle LoginEmail= page.querySelector("//input[@id='loginEmail']");
      LoginEmail.fill("farihahoque1610@gmail.com");

      ElementHandle Loginpassword= page.querySelector("//input[@id='loginPassword']");
      Loginpassword.fill("farahq123");

      ElementHandle Loginsubmit= page.querySelector("//button[@type='submit'][normalize-space()='Log in']");
      Loginsubmit.click();
    Thread.sleep(10000);

}

    @Test
    public void RememeberMeFunctionalityNotPresent() throws InterruptedException {
        page.navigate(url);
        ElementHandle LoginOption= page.querySelector("//p[normalize-space()='Account']");
        LoginOption.click();
        Thread.sleep(10000);
        ElementHandle LoginEmail= page.querySelector("//input[@id='loginEmail']");
        LoginEmail.fill("farihahoque1610@gmail.com");
        Thread.sleep(4000);
    }

    @Test
    public void ForgetPasswordFunctionality() throws InterruptedException {
        page.navigate(url);
        ElementHandle LoginOption= page.querySelector("//p[normalize-space()='Account']");
        LoginOption.click();
        Thread.sleep(10000);
        ElementHandle LoginEmail= page.querySelector("//input[@id='loginEmail']");
        LoginEmail.fill("farihahoque1610@gmail.com");

        ElementHandle ForgetPassword= page.querySelector("p[class='mt-1 cursor-pointer w-fit hover:text-primary duration-300']");
        ForgetPassword.click();

        ElementHandle PasswordRecoveryMobile= page.querySelector("//input[@placeholder='Mobile Number']");
        PasswordRecoveryMobile.isVisible();
        Thread.sleep(4000);
    }

    @AfterMethod
    public void closeBrowser() {
        page.close();
        browser.close();
        playwright.close();
    }


}
