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

public class GameTest {

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
        enemy = new Enemy("Skeleton", 5);
        System.out.println("Avant un test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Après un test");
    }

    @Test
    public void testTakeDamage() throws Exception {
        int currentHp = enemy.getHp();
        hero.takeDamage(5);
        int newHp = enemy.getHp();
        assertThat(currentHp, greaterThan(newHp));
    }

    @Test
    public void testAttack() throws Exception {
        hero = new Hero("Thrall");
        int currentHpHero = hero.getHp();
        enemy.attack(hero);
        assertThat(currentHpHero, greaterThan(hero.getHp()));
    }

    @Test
    public void testEnemyProperties() throws Exception {
        assertThat(enemy, hasProperty("name"));
        assertThat(enemy, hasProperty("name", is("Skeleton")));
        assertThat(enemy, hasProperty("level"));
        //assertThat(enemy, hasProperty("level", is(5)));
    }

}
