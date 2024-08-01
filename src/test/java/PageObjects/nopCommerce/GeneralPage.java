package PageObjects.nopCommerce;
import org.openqa.selenium.*;
import Common.Constant.Constant;
public class GeneralPage {
    //Locators
    private final By tabLogin=By.xpath("//a[@class='ico-login']");
    private final By tabRegister=By.xpath("//a[@class='ico-register']");



    //Element
    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabRegister()
    {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    //Methods

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }
    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }
}
