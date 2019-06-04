package test;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import codingfactory.rpgconsole.hero.Hero;
import codingfactory.rpgconsole.enemy.Enemy;

public class HeroTest {

	Hero hero;
	Enemy enemy;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Avant le démarrage");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Après tous les tests");
	}

	@Before
	public void setUp() throws Exception {
		hero = new Hero("Jaina Portvaillant");
		System.out.println("Avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Après un test");
	}

	@Test
	public void testTakeDamage() throws Exception {
		int currentHp = hero.getHp();
		hero.takeDamage(5);
		int newHp = hero.getHp();
		assertThat(currentHp, greaterThan(newHp));
	}

	@Test
	public void testAttack() throws Exception {
		enemy = new Enemy("Méchant", 15);
		int currentHpEnemy = enemy.getHp();
		hero.attack(enemy);
		assertThat(currentHpEnemy, greaterThan(enemy.getHp()));
	}

	@Test
	public void testHeroLevelUp() throws Exception {
		int currentLevel = hero.getLevel();
		hero.levelUp();
		int newLevel = hero.getLevel();
		assertThat(newLevel, greaterThan(currentLevel));
	}

	@Test
	public void testHeroProperties() throws Exception {
		assertThat(hero, hasProperty("name"));
        assertThat(hero, hasProperty("name", is("Jaina Portvaillant")));
	}

}
