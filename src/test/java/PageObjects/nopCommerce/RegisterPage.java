package PageObjects.nopCommerce;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends GeneralPage{
    private final By _radioGenderMale=By.xpath("//input[@id='gender-male']");
    private final By _radioGenderFemale=By.xpath("//input[@id='gender-female']");
    private final By _txtFirstName = By.xpath("//input[@id='FirstName']");
    private final By _txtLastName=By.xpath("//input[@id='LastName']");
    private final By _selectDay=By.xpath("//select[@name='DateOfBirthDay']");
    private final By _selectMonth=By.xpath("//select[@name='DateOfBirthMonth']");
    private final By _selectYear=By.xpath("//select[@name='DateOfBirthYear']");
    private final By _txtEmail=By.xpath("//input[@id='Email']");
    private final By _txtCompanyName=By.xpath("//input[@id='Company']");
    private final By _txtPassword=By.xpath("//input[@id='Password']");
    private final By _txtConfirmPW=By.xpath("//input[@id='ConfirmPassword']");
    private final By _btnRegister=By.xpath("//button[@id='register-button']");
    private final By _lblMessageError=By.xpath("//div[@class='message-error validation-summary-errors']");
    private final By _lblMessageErrorFN=By.xpath("//span[@id='FirstName-error']");
    private final By _lblMessageErrorLN=By.xpath("//span[@id='LastName-error']");
    private final By _lblMessageErrorEmail=By.xpath("//span[@id='Email-error']");
    private final By _lblMessageErrorPW=By.xpath("//span[@id='ConfirmPassword-error']");

    public WebElement getRadioGenderMale(){
        return Constant.WEBDRIVER.findElement(_radioGenderMale);
    }
    public WebElement getRadioGenderFeMale(){
        return Constant.WEBDRIVER.findElement(_radioGenderFemale);
    }
    public WebElement getTxtFirstName(){
        return Constant.WEBDRIVER.findElement(_txtFirstName);
    }
    public WebElement getTxtLastName(){
        return Constant.WEBDRIVER.findElement(_txtLastName);
    }
    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getSelectDay(){
        return Constant.WEBDRIVER.findElement(_selectDay);
    }
    public WebElement getSelectMonth(){
        return Constant.WEBDRIVER.findElement(_selectMonth);
    }
    public WebElement getSelectYear(){
        return Constant.WEBDRIVER.findElement(_selectYear);
    }
    public WebElement getTxtCompanyName(){
        return Constant.WEBDRIVER.findElement(_txtCompanyName);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirmPW(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPW);
    }
    public WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }
    public WebElement getLblMessageError(){
        return Constant.WEBDRIVER.findElement(_lblMessageError);
    }
    public WebElement getLblMessageErrorFN(){
        return Constant.WEBDRIVER.findElement(_lblMessageErrorFN);
    }
    public WebElement getLblMessageErrorLN(){
        return Constant.WEBDRIVER.findElement(_lblMessageErrorLN);
    }
    public WebElement getLblMessageErrorEmail(){
        return Constant.WEBDRIVER.findElement(_lblMessageErrorEmail);
    }
    public WebElement getLblMessageErrorPW(){
        return Constant.WEBDRIVER.findElement(_lblMessageErrorPW);
    }
    public HomePage register (String gender,String firstname, String lastname,String day, String month, String year, String email, String companyname, String password, String confirmPW){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        if (gender.equalsIgnoreCase("male")) {
            this.getRadioGenderMale().click();
        } else if (gender.equalsIgnoreCase("female")) {
            this.getRadioGenderFeMale().click();
        }
        this.getTxtFirstName().sendKeys(firstname);
        this.getTxtLastName().sendKeys(lastname);
        if (day != null && !day.isEmpty()) {
            new Select(this.getSelectDay()).selectByValue(day);
        }
        if (month != null && !month.isEmpty()) {
            new Select(this.getSelectMonth()).selectByValue(month);
        }
        if (year != null && !year.isEmpty()) {
            new Select(this.getSelectYear()).selectByValue(year);
        }
        this.getTxtEmail().sendKeys(email);
        this.getTxtCompanyName().sendKeys(companyname);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPW().sendKeys(confirmPW);
        this.getBtnRegister().click();
        return new HomePage();
    }
}
