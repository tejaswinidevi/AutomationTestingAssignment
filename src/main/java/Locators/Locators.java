package Locators;

public class Locators {
	//Create Account Locators
	public static String CREATEACCOUNT_FIRSTNAME = "//input[@name='firstname']";
	public static String CREATEACCOUNT_LASTNAME = "//input[@name='lastname']";
	public static String CREATEACCOUNT_EMAIL = "//input[@name='email']";
	public static String CREATEACCOUNT_PASSWORD = "//input[@name='password']";
	public static String CREATEACCOUNT_CONFIRMPASSWORD = "//input[@name='password_confirmation']";
	public static String CREATEACCOUNT_CREATEANACCOUNTBUTTON = "//button[@title='Create an Account']";
	public static String CREATEACCOUNT_FIRSTNAME_ERRORMSG = "//div[@id='firstname-error']";
	public static String CREATEACCOUNT_LASTNAME_ERRORMSG = "//div[@id='lastname-error']";
	public static String CREATEACCOUNT_EMAIL_ERRORMSG = "//div[@id='email_address-error']";
	public static String CREATEACCOUNT_PASSWORD_ERRORMSG = "//div[@id='password-error']";
	public static String CREATEACCOUNT_CONFIRMPASSWORD_ERRORMSG = "//div[@id='password-confirmation-error']";
	public static String CREATEACCOUNT_PASSWORD_STRENGTHMETER = "//div[@id='password-strength-meter-container']";
	//Forgot Password Locators
	public static String FORGOTPASSWORD_TITLE = "//span[text()='Forgot Your Password?']";
	public static String FORGOTPASSWORD_EMAIL = "//input[@id='email_address']";
	public static String FORGOTPASSWORD_RESETPASSWORD = "//button/span[text()='Reset My Password']";
	public static String FORGOTPASSWORD_EMAIL_ERRORMSG = "//div[@id='email_address-error']";
	//Home Page Locators
	public static String HOMEPAGE_URL = "https://magento.softwaretestingboard.com/";
	public static String HOMEPAGE_CREATEACCOUNT = "//a[contains(text(),'Create an Account')]";
	public static String HOMEPAGE_SIGNIN = "//a[contains(text(),'Sign In')]";
	//My Account Locators
	public static String MYACCOUNT_ALERT = "//div[@role='alert']";
	public static String MYACCOUNT_BOXCONTENT = "//div[@class='box-content']";
	public static String MYACCOUNT_TITLE = "//h1[@class='page-title']";
	public static String MYACCOUNT_CUSTOMER_WELCOME_DROPDOWN = "//button[@data-action='customer-menu-toggle'] [@class='action switch']";
	public static String MYACCOUNT_SIGNOUT = "//li[@class=\"authorization-link\"]//a[contains(text(), 'Sign Out')]";
	//Sign In Page Locators
	public static String SIGNIN_EMAIL = "//input[@name='login[username]']";
	public static String SIGNIN_PASSWORD = "//input[@name='login[password]']";
	public static String SIGNIN_CREATE_AN_ACCOUNT_BUTTON = "//button[@name='send']";
	public static String SIGNIN_EMAIL_ERRORMSG = "//div[@id='email-error']";
	public static String SIGNIN_PASSWORD_ERRORMSG = "//div[@id='pass-error']";
	public static String SIGNIN_FORGOT_PASSWORD = "//a/span[text()='Forgot Your Password?']";
}
