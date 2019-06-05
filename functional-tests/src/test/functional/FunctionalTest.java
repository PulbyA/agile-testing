package test.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTest {

	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }

    // Test de la Story #1-homepage (https://trello.com/c/WKTneu9o/1-homepage)
	@Test
    public void testHomepage() throws Exception {
        driver.get("https://www.meetup.com/fr-FR/");
		assertEquals(driver.getTitle(), "Partagez vos passions | Meetup");
        //String description =  driver.findElement(By.cssSelector("meta[name='description']")).getAttribute("content");
        //assertEquals(description, "Partagez vos passions et faites bouger votre ville ! Meetup vous aide à rencontrer des personnes près de chez vous, autour de vos centres d'intérêt.");
        String punchline = driver.findElement(By.cssSelector("h1")).getText();
        assertEquals(punchline, "Le monde vous tend les bras");
        String sousPunchline = driver.findElement(By.cssSelector("p[class='exploreHome-hero-subTitle text--bold align--center']")).getText();
        assertEquals(sousPunchline, "Rejoignez un groupe local pour rencontrer du monde, tester une nouvelle activité ou partager vos passions.");
        String inscriptionButton = driver.findElement(By.cssSelector("a[class='button button--primary text--bold']")).getText();
        assertEquals(inscriptionButton, "Rejoindre Meetup");
        String inscriptionLink = driver.findElement(By.cssSelector("a[class='button button--primary text--bold']")).getAttribute("href");
        assertEquals(inscriptionLink, "https://www.meetup.com/fr-FR/register/");

    }

    // Test de la Story n ...
    // TODO
    // To Be Completed By Coders From Coding Factory

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}