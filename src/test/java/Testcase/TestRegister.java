package Testcase;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.nopCommerce.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRegister {
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
    public void TC01() throws InterruptedException {
        System.out.println("TC01 - Đăng ký tài khoản thành công");
        HomePage homePage=new HomePage();
        homePage.open();
        RegisterPage registerPage=homePage.gotoRegisterPage();
        registerPage.register("female","Trần Thị","Huệ","20","10","2002","huethitran123@gmail.com","2handstore","@Test_register123","@Test_register123");
        //Thread.sleep(8000);
    }
    @Test
    public void TC02() throws InterruptedException{
        System.out.println("TC02 - Đăng ký tài khoản thất bại nếu để trống textbox First Name");
        HomePage homePage=new HomePage();
        homePage.open();
        RegisterPage registerPage=homePage.gotoRegisterPage();
        registerPage.register("","","Huệ","","","","huethitran123@gmail.com","","@Test_register123","@Test_register123");
        String actualErrorMsg = registerPage.getLblMessageErrorFN().getText();
        String expectedErrorMsg = "First name is required.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
    @Test
    public void TC03() throws InterruptedException{
        System.out.println("TC03 - Đăng ký tài khoản thất bại nếu để trống textbox Last Name");
        HomePage homePage=new HomePage();
        homePage.open();
        RegisterPage registerPage=homePage.gotoRegisterPage();
        registerPage.register("female","Trần Thị","","20","10","2002","huethitran123@gmail.com","2handstore","@Test_register123","@Test_register123");
        String actualErrorMsg = registerPage.getLblMessageErrorLN().getText();
        String expectedErrorMsg = "Last name is required.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
    @Test
    public void TC04() throws InterruptedException{
        System.out.println("TC04 - Đăng ký tài khoản thất bại nếu để trống textbox Email");
        HomePage homePage=new HomePage();
        homePage.open();
        RegisterPage registerPage=homePage.gotoRegisterPage();
        registerPage.register("female","Trần Thị","Huệ","20","10","2002","","2handstore","@Test_register123","@Test_register123");
        String actualErrorMsg = registerPage.getLblMessageErrorEmail().getText();
        String expectedErrorMsg = "Email is required.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC05() throws InterruptedException {
        System.out.println("TC05 - Đăng ký tài khoản thất bại nếu trường PW và ConfirmPW không giống nhau");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register("female", "Trần Thị", "Huệ", "20", "10", "2002", "huethitran123@gmail.com", "2handstore", "@Test_register123", "@Test_register1234");
        String actualErrorMsg = registerPage.getLblMessageErrorPW().getText();
        String expectedErrorMsg = "The password and confirmation password do not match.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
    @Test
    public void TC06() throws InterruptedException{
        System.out.println("TC06 - Đăng ký tài khoản thất bại nếu để trống trường PW và ConfirmPW - TC_Register_29");
        HomePage homePage=new HomePage();
        homePage.open();
        RegisterPage registerPage=homePage.gotoRegisterPage();
        registerPage.register("","Trần Thị","Huệ","","","","abcd@gmail.com","","","");
        String actualErrorMsg = registerPage.getLblMessageErrorPW().getText();
        String expectedErrorMsg = "Password is required.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
        Thread.sleep(3000);
    }
    @Test
    public void TC_Register_30() throws InterruptedException {
        System.out.println("TC_Register_30 - Đăng ký thất bại với email đã tồn tại trong hệ thống");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage=homePage.gotoRegisterPage();
        registerPage.register("male","Vương Thế","Thái","","","","huethitran123@gmail.com","","12345678","12345678");
        String actualErrorMsg = registerPage.getLblMessageError().getText();
        String expectedErrorMsg = "The specified email already exists";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }












}