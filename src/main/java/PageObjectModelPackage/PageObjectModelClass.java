package PageObjectModelPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModelClass {
	WebDriver driver;

	public PageObjectModelClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='location']")
	private WebElement enterLocation;

	@FindBy(xpath = "//button[text()='Clear']")
	private WebElement clearButton;

	@FindBy(xpath = "//span[text()='Anna Nagar, Chennai, Tamil Nadu, India']")
	private WebElement desiredLocation;

	@FindBy(xpath = "//span[text()='FIND FOOD']//parent::a")
	private WebElement findFood;

	@FindBy(xpath = "//span[text()='Search']//parent::a")
	private WebElement search;

	@FindBy(xpath = "//div[@class='_1QBzC']/div/input")
	private WebElement food;

	@FindBy(xpath = "(//div[text()='By SS Hyderabad Briyani' and @class='styles_restaurantName__5VIQZ styles_restaurantNameBold__2OmFY'])[1]")
	private WebElement hotel;

	@FindBy(xpath = "//img[@src='https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_112,h_112,c_fill/vnxvrwgkahdoglr2ypah']")
	private WebElement foodItem;

	@FindBy(xpath = "//div[@class='styles_itemName__hLfgz']/h3")
	private List<WebElement> item;

	@FindBy(xpath = "//button[@class='MenuTopHeader_rightNavItem__3dysE']//parent::div")
	private WebElement searchBtn;
	@FindBy(xpath = "//button[@class='styles_itemImage__3CsDL' and @aria-label='See more information about Grill Chicken']")
	private WebElement image;
	@FindBy(xpath = "//span[text()='Full']")
	private WebElement click;

	@FindBy(xpath = "//div[text()='ADD']/parent::div[@class='_3L1X9 _211P0 main_buttonInner__z6Jz0 main_button__3gpqi styles_addBtnDwebReset__3-z94']")
	private WebElement addBtn;
	@FindBy(xpath = "//span[text()='Add Item']")
	private WebElement addItem;
	@FindBy(xpath = "//div[text()='ADD']")
	private WebElement add;
	@FindBy(xpath = "//span[text()='Cart']")
	private WebElement cart;

	public WebElement clickCart() {
		return cart;

	}

	public WebElement clickAddItem() {
		return addItem;

	}

	public WebElement clickFull() {
		return click;

	}

	public WebElement clickAddBtn() {
		return addBtn;

	}

	public WebElement clickImage() {
		return image;

	}

	public WebElement clickAddButton() {
		return add;

	}

	public WebElement SelectFoodItem() {
		return foodItem;

	}

	public WebElement clickHotelSearchButton() {
		return searchBtn;

	}

	public List<WebElement> SelectItem() {
		return item;

	}

	public WebElement enterFood() {
		return food;

	}

	public WebElement selectHotel() {
		return hotel;

	}

	public WebElement clickSearchButton() {
		return search;

	}

	public WebElement getEnterLocation() {
		return enterLocation;

	}

	public WebElement clickClearButton() {
		return clearButton;

	}

	public WebElement selectDesiredLocation() {

		return desiredLocation;
	}

}
