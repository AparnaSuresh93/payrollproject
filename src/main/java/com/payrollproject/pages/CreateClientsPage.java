package com.payrollproject.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.payrollproject.utilities.PageUtility;

public class CreateClientsPage {
	WebDriver driver;
	
	/*** PageConstructor ***/
	public CreateClientsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
/***   Web Elements   ***/
	@FindBy(xpath="//div[@class='col-sm-6 page-title']//h1")
	private WebElement profileDisplay;
	
	@FindBy(id="client-branch_id")
	private WebElement branchDropdwn;
	
	
	@FindBy(name="Client[your_ref]")
	private WebElement yourRefTxt;
	
	@FindBy(id="client-invoice_order")
	private WebElement clientInvoiceOrderDropdwn;
	
	@FindBy(id="client-division_id")
	private WebElement clientDivisionDropdwn;
	
	@FindBy(id="client-invoice_contact")
	private WebElement clientInvoiceContactTxt;
	
	@FindBy(id="client-invoice_delivery_method")
	private WebElement invoiceDeliveryMethodDropdwn;
	
	@FindBy(id="client-client_name")
    private WebElement clientNameTxt;
	
	@FindBy(id="client-phone")
	private WebElement clientPhonetxt;
	
	@FindBy(id="client-client_address")
	private WebElement clientAddrTxt;
	
	@FindBy(id="client-fax")
	private WebElement clientFaxTxt;
	
	@FindBy(id="client-postcode")
	private WebElement clientPostCodeTxt;
	
	@FindBy(id="client-country")
	private WebElement clientCountryTxt;	
	
	@FindBy(id="client-company_reg")
	private WebElement clientCmpnyRegTxt;
	
	@FindBy(id="client-email")
	private WebElement clientEmailTxt;
	
	@FindBy(xpath="//select[@id='client-master_document']")
	private WebElement clientMasterdocDropdwn;
	
	@FindBy(id="client-settilement_days")
	private WebElement clientSettlementDaysTxt;
	
	@FindBy(id="client-vat_rate")
	private WebElement clientVatRateDropdwn;
	
	@FindBy(xpath="//input[@id='client-require_po']")
	private WebElement clientReqProCheckbx;
	
	@FindBy(xpath="//input[@name='Client[direct_client]']")
	private WebElement directClientCheckbx;
	
	@FindBy(xpath="//input[@name='Client[uk_public_sector_client]']")
	private WebElement ukPublicSectorClientCheckbx;
	
	@FindBy(xpath="//input[@name='Client[subject_to_payee]']")
	private WebElement clientSubjToPayeeCheckbx;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement saVeBtn;
	
	@FindBy(xpath="//div[text()='Branch cannot be blank.']")
	private WebElement reqfieldErrorMsg;
	
	/*** UserActionMethods  ***/
	public String getErrorMsg() {
		// TODO Auto-generated method stub
		return PageUtility.getElementText(reqfieldErrorMsg);
	}
	public  void selectBranchDropDown() {
	     PageUtility.selectDropdownbyText(branchDropdwn,"Alpha_new");
	}
	public  void selectInvoiceOrderDropDown() {
	     PageUtility.selectDropdownbyText(clientInvoiceOrderDropdwn, "Invoice per week");
	}
	public  void selectDivisionDropdwn() {
	     PageUtility.selectDropdownbyText(clientDivisionDropdwn,"NewAlpha");
	}
	public  void selectInvoiceDelvMethDropdwn() {
	     PageUtility.selectDropdownbyText(invoiceDeliveryMethodDropdwn, "Paper");
	}
	public  void selectMasterDocumentDropdwn() {
	     PageUtility.selectDropdownbyText(clientMasterdocDropdwn, "Print");
	}
	public  void selectVATRate() {
	     PageUtility.selectDropdownbyText(clientVatRateDropdwn, "VAT 5.00%");
	}
//	public void selectDropdwn()
//	{
//	 	Select select = new Select(branchDropdwn);
//	 	List<WebElement> branch = PageUtility.getDropdownOptions(select);
//	 	List<String> actualbranch = new ArrayList<String>();	
//	 	for (int i=0;i<branch.size();i++)
//	 	{
//	 		actualbranch.add(branch.get(i).getText());
//	 	}
//		PageUtility.selectDropdownbyText(branchDropdwn, "New_Alpha");
//	 	 //return actualbranch;
//	}
	public void enterYouRef(String text)
	{
		PageUtility.enterText(yourRefTxt, text);
	}
	public void selectInvoiceOrderDropdwn(String text)
	{
	 	PageUtility.selectDropdownbyText(clientInvoiceOrderDropdwn,text);
	}
	
	public void selectDivisionDropdwn(String text)
	{
	 	PageUtility.selectDropdownbyText(clientDivisionDropdwn,text);
	}
	public void enterInvoiceContactTxt(double d)
	{
	 	PageUtility.enterNumericText(clientInvoiceContactTxt, d);
	}
	public void selectInvoiceDelvMethDropdwn(String text)
	{
	 	PageUtility.selectDropdownbyText(invoiceDeliveryMethodDropdwn,text);
	}
	public void enterClientNameTxt(String text)
	{
	 	PageUtility.enterText(clientNameTxt, text);
	}
	public void enterPhoneTxt(double d)
	{
		PageUtility.enterNumericText(clientPhonetxt, d);
	}
	public void selectMasterDocumentDropdwn(String text)
	{
		PageUtility.selectDropdownbyText(clientMasterdocDropdwn, text);
	}
	public void enterClientAddress(String text)
	{
		PageUtility.enterText(clientAddrTxt, text);
	}
	public void enterFaxTxt(double d)
	{
		PageUtility.enterNumericText(clientFaxTxt, d);
	}
	public void enterSettlementDaysTxt(int n)
	{
		PageUtility.enterNumericText(clientSettlementDaysTxt, n);
	}
	public void enterPostCodeTxt(double d)
	{
		PageUtility.enterNumericText(clientPostCodeTxt, d);
	}
	public void enterEmailTxt(String text)
	{
		PageUtility.enterText(clientEmailTxt, text);
	}
	public void enterVatRateTxt(double d)
	{
		PageUtility.enterNumericText(clientReqProCheckbx, d);
	}
	public void enterCmpnyRegTxt(String text)
	{
		PageUtility.enterText(clientCmpnyRegTxt, text);
	}
	public void enterCountryTxt(String text)
	{
		PageUtility.enterText(clientCountryTxt, text);
	}
	public void checkboxReqproclk()
	{
		PageUtility.clickOnelement(clientReqProCheckbx);
	}
	public void checkboxdirectClientclk()
	{
		PageUtility.clickOnelement(directClientCheckbx);
	}
	public void checkboxUkPublicSectorClientclk()
	{
		PageUtility.clickOnelement(ukPublicSectorClientCheckbx);
	}
	public void clksaveBtn()
	{
		PageUtility.clickOnelement(saVeBtn);
	}
	public boolean isDisplayedProfileName()
	{
		return PageUtility.isElementDisplayed(profileDisplay);
		}
	public void scrollPage()
	{
		PageUtility.Scroll(driver);
	}
	
	
	

}
