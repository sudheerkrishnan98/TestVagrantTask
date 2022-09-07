package com.pageobject;

import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPageObject extends BaseClass {

	public WikipediaPageObject() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "searchInput")
	private WebElement SearchBoxWikipedia;
	@FindBy(xpath = "//a[@class='mw-searchSuggest-link']")
	private List<WebElement> SearchSuggestions;
	@FindBy(xpath = "//div[contains(text(),'Release date')]/parent:: th/following-sibling:: td/div/ul/li")
	private WebElement ReleaseDateWikipedia;
	@FindBy(xpath = "//th[contains(text(),'Country')]/following-sibling:: td")
	private WebElement CountryOriginWikipedia;

	public WebElement getReleaseDateWikipedia() {
		return ReleaseDateWikipedia;
	}

	public WebElement getSearchBoxWikipedia() {
		return SearchBoxWikipedia;
	}

	public WebElement getCountryOriginWikipedia() {
		return CountryOriginWikipedia;
	}

	public List<WebElement> getSearchSuggestions() {
		return SearchSuggestions;
	}

}
