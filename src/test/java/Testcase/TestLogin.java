package Testcase;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.nopCommerce.*;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("pre-condition");
        System.setProperty("Webdriver.chrome.driver", Utilities.getProjectPath()
                + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test
    public void TC_Login_12() throws InterruptedException{
        System.out.println("TC_Login_13 - Trường hợp đăng nhập thành công với tài khoản đã tồn tại trong hệ thống");
        HomePage homePage=new HomePage();
        homePage.open();
        LoginPage loginPage=homePage.gotoLoginPage();
        loginPage.login("huethitran123@gmail.com","@Test_register123");
    }
    @Test
    public void TC_Login_13() throws InterruptedException {
        System.out.println("TC_login_13 - Trường hợp đăng nhập thất bại với Email đúng,Password sai");
        HomePage homePage=new HomePage();
        homePage.open();
        LoginPage loginPage=homePage.gotoLoginPage();
        loginPage.login("huethitran123@gmail.com","12345678");
        String actualErrorMsg = loginPage.getLblMessageError().getText();
        String expectedErrorMsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
        Thread.sleep(8000);
    }

    @Test
    public void TC_Login_14() throws InterruptedException {
        System.out.println("TC_Login_14 - Trường hợp đăng nhập thất bại với Email không tồn tại, Password đúng");
        HomePage homePage=new HomePage();
        homePage.open();
        LoginPage loginPage=homePage.gotoLoginPage();
        loginPage.login("huethitran12345@gmail.com","@Test_register123");
        String actualErrorMsg = loginPage.getLblMessageError().getText();
        String expectedErrorMsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
    @Test
    public void TC_Login_15() throws InterruptedException {
        System.out.println("TC_Login_15 - Trường hợp đăng nhập thất bại với Email trống, Password đúng");
        HomePage homePage=new HomePage();
        homePage.open();
        LoginPage loginPage=homePage.gotoLoginPage();
        loginPage.login("","@Test_register123");
        String actualErrorMsg = loginPage.getLblMessageErrorEmail().getText();
        String expectedErrorMsg = "Please enter your email";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
    @Test
    public void TC_Login_16() throws InterruptedException{
        System.out.println("TC_Login_16 - Trường hợp đăng nhập thất bại với Email tồn tại trong hệ thống, Password để trống");
        HomePage homePage=new HomePage();
        homePage.open();
        LoginPage loginPage=homePage.gotoLoginPage();
        loginPage.login("huethitran123@gmail.com","");
        String actualErrorMsg = loginPage.getLblMessageError().getText();
        String expectedErrorMsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Error message is not displayed as expected");
    }
}
