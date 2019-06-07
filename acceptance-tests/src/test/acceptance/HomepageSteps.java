package test.acceptance;

import java.util.concurrent.TimeUnit;

import java.lang.*;

import org.junit.Test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class HomepageSteps {

	public static WebDriver driver;

	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("^je suis sur la homepage$")
	public void je_suis_sur_la_homepage() throws Throwable {
		driver.get("https://www.meetup.com/fr-FR/");
	}

	@Then("^le titre doit être \"([^\"]*)\"$")
	public void le_titre_doit_être(String arg1) throws Throwable {
	    assertEquals(driver.getTitle(), arg1);
	}

	@Then("^la description contient \"([^\"]*)\"$")
	public void la_description_contient(String arg1) throws Throwable {
		// By CSS Selector
		assertTrue(driver.findElement(By.cssSelector("meta[name='description']")).getAttribute("content").contains(arg1));
		// By XPATH, si vous préférez...
	    // assertEquals(driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content"), arg1);
	}

	@Then("^la punchline doit être \"([^\"]*)\"$")
	public void la_punchline_doit_être(String arg1) throws Throwable {
		assertEquals(driver.findElement(By.cssSelector("h1[class='exploreHome-hero-mainTitle text--display align--center']")).findElement(By.cssSelector("span")).getText(), arg1);
	}

	@Then("^La sous punchline doit être \"([^\"]*)\"$")
	public void la_sous_punchline_doit_être(String arg1) throws Throwable {
		assertEquals(driver.findElement(By.cssSelector("p[class='exploreHome-hero-subTitle text--bold align--center']")).findElement(By.cssSelector("span")).getText(), arg1);
	}

	@Given("^le bloc des \"([^\"]*)\" est présent$")
	public void le_bloc_des_est_présent(String arg1) throws Throwable {
		assertEquals(driver.findElement(By.cssSelector("section[class='section e2e-guest-home-page-groups-near-you']")).findElement(By.cssSelector("h2[class='text--sectionTitle']")).getText(), arg1);
	}

	@When("^je clic sur le bouton \"([^\"]*)\"$")
	public void je_clic_sur_le_bouton(String arg1) throws Throwable {
		assertEquals(driver.findElement(By.cssSelector("a[href='https://www.meetup.com/fr-FR/find/']")).getText(), arg1);
		driver.findElement(By.cssSelector("a[href='https://www.meetup.com/fr-FR/find/']")).click();
	}

	@Then("^je suis sur la page \"([^\"]*)\"$")
	public void je_suis_sur_la_page(String arg1) throws Throwable {
		assertEquals(driver.getCurrentUrl(), arg1);
	}

	@Then("^la recherche est initialisé sur un rayon de \"([^\"]*)\" autour de \"([^\"]*)\", FR$")
	public void la_recherche_est_initialisé_sur_un_rayon_de_autour_de_FR(String arg1, String arg2) throws Throwable {
		assertEquals(driver.findElement(By.cssSelector("div[class='dropdown callout center'] a[class='dropdown-toggle']")).getText(), arg1);
		assertEquals(driver.findElement(By.cssSelector("div[class='dropdown callout center location-display'] a[class='dropdown-toggle']")).getText(), arg2);
	}

	@Given("^le bouton inscription contient \"([^\"]*)\"$")
	public void le_bouton_inscription_contient(String arg1) throws Throwable {
		assertEquals(driver.findElement(By.cssSelector("a[href='https://www.meetup.com/fr-FR/register/']")).getText(), arg1);
	}

	@When("^je clic sur le bouton d'inscription \"([^\"]*)\"$")
	public void je_clic_sur_le_bouton_d_inscription(String arg1) throws Throwable {
		driver.findElement(By.cssSelector("a[href='https://www.meetup.com/fr-FR/register/']")).click();
	}


	@After
	public void afterScenario() {
		driver.quit();
	}




}
