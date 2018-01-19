import org.junit.Test;
import static org.junit.Assert.*;

// javac -cp ".;junit.jar" *.java && java -cp ".;junit.jar" org.junit.runner.JUnitCore PoketZombieTest

public class PoketZombieTest {

	@Test public void init() {			//live zombie
		//                            ATK,DEF,SPD,HP
		PoketZombie z = new PoketZombie(0, 0, 0, 100);
		assertEquals(100, z.getHP());
		assertTrue(z.isUnDead());
	}

	// TODO : add your own tests
	@Test public void zeroHealth() {				//dead zombie
		//                            ATK,DEF,SPD,HP
		PoketZombie z = new PoketZombie(0,0,0,0);
		assertEquals(0, z.getHP());
		assertFalse(z.isUnDead());
	}	
	


@Test public void zeroHealthWih100Atk() {		// dead zombie who can fight
	//                            ATK,DEF,SPD,HP
	PoketZombie z = new PoketZombie(100,0,0,0);
	assertEquals(0, z.getHP());
	assertFalse(z.isUnDead());
}	

@Test public void zeroHealthWih100Def() {		// dead zombie who can defend
	//                            ATK,DEF,SPD,HP
	PoketZombie z = new PoketZombie(0,100,0,0);
	assertEquals(0, z.getHP());
	assertFalse(z.isUnDead());
}	


@Test public void zeroHealthWih100Spd() {		// dead zombie with speed
	//                            ATK,DEF,SPD,HP
	PoketZombie z = new PoketZombie(0,0,100,0);
	assertEquals(0, z.getHP());
	assertFalse(z.isUnDead());
}	
@Test public void healthyZombie() {		// healthy live Zombie
	//                            ATK,DEF,SPD,HP
	PoketZombie z = new PoketZombie(100,100,100,100);
	assertEquals(100, z.getHP());
	assertTrue(z.isUnDead());
}	
}