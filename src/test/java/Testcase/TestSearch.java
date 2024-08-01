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

public class TestSearch {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("pre-condition");
        System.setProperty("Webdriver.chrome.driver", Utilities.getProjectPath()
                + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test
    public void TC_Search_04 () throws InterruptedException {
        System.out.println("TC_Search_04 - Không hiển thị sản phẩm nếu giá trị nhập vào textbox Search Store không tồn tại trong hệ thống");
        HomePage homePage=new HomePage();
        homePage.open();
        SearchPage searchPage = new SearchPage();
        searchPage.search("abc");
        String actualErrorMsg = searchPage.getlblSearchnoresult().getText();
        String expectedErrorMsg = "No products were found that matched your criteria.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Error message is not displayed as expected");
        Thread.sleep(3000);
    }
    @Test
    public void TC_Search_05 () throws InterruptedException {
        System.out.println("TC_Search_05 - Hiển thị sản phẩm nếu nhập vào giá trị chứa giá trị đó trong hệ thống không phân biệt hoa thường");
        HomePage homePage=new HomePage();
        homePage.open();
        SearchPage searchPage = new SearchPage();
        searchPage.search("Nike");
        searchPage.getBtnViewProduct().isDisplayed();

    }
    @Test
    public void TC_Search_06 () throws InterruptedException {
        System.out.println("TC_Search_06 - Hiển thị sản phẩm nếu nhập vào giá trị hoàn toàn trùng khớp trên hệ thống");
        HomePage homePage=new HomePage();
        homePage.open();
        SearchPage searchPage = new SearchPage();
        searchPage.search("Nike Floral Roshe Customized Running Shoes");
        String actualErrorMsg = searchPage.getlblSearchnoresult().getText();
    }

}
