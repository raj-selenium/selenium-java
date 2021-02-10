package orangehrm.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	
	private WebDriverWait wait;

	@FindBy(id="txtUsername")
	private WebElement userNameTBox;
	

	@FindBy(id="txtPassword")
	private WebElement passwordTBox;
	
	@FindAll({
		@FindBy(id="btnLogin"),
		@FindBy(css="[value='LOGIN']")
	})
	private WebElement loginBtn;
	
	@FindBy(id="spanMessage")
	WebElement errorTxt;
	
	
	@FindBy(xpath="//a")
	private List<WebElement> allLinks;
	
	private String baseUrl = "https://opensource-demo.orangehrmlive.com/";
	
	public LoginPage(WebDriver driver){
		super(driver);
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage load() {
		driver.get(baseUrl);
		return this;
	}
	
	public LoginPage inputUsername(String uName) {
		userNameTBox.sendKeys(uName);
		return this;
	}
	
	public LoginPage inputPassword(String pass) {
		passwordTBox.sendKeys(pass);
		return this;
	}
	
	public LoginPage clickLogin() {
		loginBtn.click();
		return this;
	}
	
	public String getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spanMessage")));
		return errorTxt.getText();
	}

}
