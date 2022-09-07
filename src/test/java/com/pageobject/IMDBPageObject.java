package com.pageobject;

import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDBPageObject extends BaseClass {

	public IMDBPageObject() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "suggestion-search")
	private WebElement SearchBoxIMDB;
	@FindBy(xpath = ("//a[@data-testid='search-result--const']"))
	private List<WebElement> SearchOptions;
	@FindBy(xpath = ("//a[contains(text(),'Release date')]/parent:: li/div/ul/li/a"))
	private WebElement ReleaseDateTextIMDB;
	@FindBy(xpath = ("//span[contains(text(),'Country of origin')]/parent:: li/div/ul/li/a"))
	private WebElement CountryOriginIMDB;

	public WebElement getCountryOriginIMDB() {
		return CountryOriginIMDB;
	}

	public WebElement getReleaseDateTextIMDB() {
		return ReleaseDateTextIMDB;
	}

	public WebElement getSearchBoxIMDB() {
		return SearchBoxIMDB;
	}

	public List<WebElement> getSearchOptions() {
		return SearchOptions;
	}

}
