package com.testvagrant;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageobject.IMDBPageObject;
import com.pageobject.WikipediaPageObject;

public class QaTask extends IMDBPageObject {
	@BeforeClass(groups= {"browser"})
	public void launchIMDBPage() {
		browserlaunch();
		maximizeBrowser();

	}

	@Parameters({ "IMDB Url", "Movie Search Name", "Movie Name" })
	@Test(priority = 1, groups = { "IMDB" })
	public void searchMovieInIMDB(String imdbUrl, String searchMovieName, String movieName) {
		// open IMDB page
		openWebPage(imdbUrl);
		IMDBPageObject ip = new IMDBPageObject();
		timeImplicity5Seconds();
		// search for the movie in the search box
		enterText(ip.getSearchBoxIMDB(), searchMovieName);
		// click on the movie of your choice from suggestion list
		movieSearchSugesstion(ip.getSearchOptions(), movieName);

	}

	@Parameters({ "Release Date" })
	@Test(priority = 2, groups = { "IMDB" })
	public void getReleaseDateIMDB(String releaseDate) {
		IMDBPageObject ip = new IMDBPageObject();
		timeImplicity5Seconds();
		// extract the release date value
		String rd = getText(ip.getReleaseDateTextIMDB());
		// verify whether the values are matching
		assertValue(rd, releaseDate);

	}

	@Parameters({ "Country Origin" })
	@Test(priority = 3, groups = { "IMDB" })

	public void getCountryOfOriginIMDB(String countryOriginName) {
		IMDBPageObject ip = new IMDBPageObject();
		// extract the Country of Origin value
		String countryOrigin = getText(ip.getCountryOriginIMDB());
		// verify whether the values are matching
		assertValue(countryOrigin, countryOriginName);

	}

	@Parameters({ "Wikipedia Url", "Movie Search Name", "Movie Name" })
	@Test(priority = 4, groups = { "Wikipedia" })
	public void searchMovieInWikipedia(String wikipediaUrl, String searchMovieName, String movieName) {
		// change to Wikipedia page
		openWebPage(wikipediaUrl);
		WikipediaPageObject wp = new WikipediaPageObject();
		timeImplicity5Seconds();
		// search for the movie in the search box
		enterText(wp.getSearchBoxWikipedia(), searchMovieName);
		// click on the movie of your choice from suggestion list
		movieSearchSugesstion(wp.getSearchSuggestions(), movieName);
	}

	@Parameters({ "Release Date" })
	@Test(priority = 5, groups = { "Wikipedia" })
	public void getReleaseInfoWikipedia(String releaseDate) {
		WikipediaPageObject wp = new WikipediaPageObject();
		timeImplicity5Seconds();
		// extract the release date value
		String rd = wp.getReleaseDateWikipedia().getText();
		// verify whether the values are matching
		assertValue(rd, releaseDate);

	}

	@Parameters({ "Country Origin" })
	@Test(priority = 6, groups = { "Wikipedia" })
	public void getCountryOriginWikipedia(String countryOriginName) {
		WikipediaPageObject wp = new WikipediaPageObject();
		// extract the Country of Origin value
		String countryOrigin = getText(wp.getCountryOriginWikipedia());
		// verify whether the values are matching
		assertValue(countryOrigin, countryOriginName);

	}

	@AfterClass(groups= {"browser"})
	public void browserClose() {
		closeBrowser();

	}
}
