package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountButton;

    @FindBy(linkText = "Login")
    public WebElement loginButton;





    public void navigateToLoginPage(){
        myAccountButton.click();
        loginButton.click();
    }




}
