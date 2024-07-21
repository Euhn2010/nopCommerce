package PageObjects.nopCommerce;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
public class LoginPage extends GeneralPage {
    //locators

    private final By _txtUsername = By.xpath("//input[@class='email']");
    private final By _txtPassword = By.xpath("//input[@class='password']");
    private final By _btnLogin = By.xpath("//button[text()='Log in']");
    private final By _lblMessageError = By.xpath("//div[@class='message-error validation-summary-errors']");
    private final By _lblMessageErrorEmail= By.xpath("//span[@id='Email-error']");
    //element
    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getLblMessageError(){
        return Constant.WEBDRIVER.findElement(_lblMessageError);
    }
    public WebElement getLblMessageErrorEmail(){
        return Constant.WEBDRIVER.findElement(_lblMessageErrorEmail);
    }

    public WebElement getBtnLogin(){
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }
    public HomePage login(String username,String password){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        return new HomePage();

    }
}
