import org.junit.Test;
import static org.junit.Assert.*;

// javac -cp ".;junit.jar" *.java && java -cp ".;junit.jar" org.junit.runner.JUnitCore ZombieFightTest

public class ZombieFightTest {
	
	@Test public void draw_cantHurtEachOther() {
		// neither can hurt the other
		//                            ATK,DEF,SPD,HP
		PoketZombie a = new PoketZombie(0,1,0,100);
		PoketZombie b = new PoketZombie(0,1,0,100);

		ZombieFight zf = new ZombieFight(a, b);
		assertEquals(new Result(100), zf.battle());
	}
	
	@Test public void battleWin100Rounds() {
		// neither can hurt the other
		//                            ATK,DEF,SPD,HP
		PoketZombie a = new PoketZombie(0,1,0,100);
		PoketZombie b = new PoketZombie(0,1,0,100);

		ZombieFight zf = new ZombieFight(a, b);
		assertEquals(new Result(100), zf.battle());
	}
	@Test public void battle_0Rounds_special_oneDead() {
		// neither can hurt the other
		//                            ATK,DEF,SPD,HP
		PoketZombie a = new PoketZombie(0,1,0,0);
		PoketZombie b = new PoketZombie(0,1,0,100);

		ZombieFight zf = new ZombieFight(a, b);
		assertEquals(new Result(0), zf.battle());
	}
	@Test public void battle_0Rounds_special_BothDead() {
		// neither can hurt the other
		//                            ATK,DEF,SPD,HP
		PoketZombie a = new PoketZombie(0,1,0,0);
		PoketZombie b = new PoketZombie(0,1,0,0);

		ZombieFight zf = new ZombieFight(a, b);
		assertEquals(new Result(0), zf.battle());
	}


	@Test public void aZombieWins() {
		// aWins
		//                            ATK,DEF,SPD,HP
		PoketZombie a = new PoketZombie(1,0,0,100);
		PoketZombie b = new PoketZombie(0,0,0,100);

		ZombieFight zf = new ZombieFight(a, b);
		assertEquals(new Result(19,a), zf.battle());
	}

	@Test public void BZombieWins() {
		
		//                            ATK,DEF,SPD,HP
		PoketZombie a = new PoketZombie(0,0,0,100);
		PoketZombie b = new PoketZombie(1,0,0,100);

		ZombieFight zf = new ZombieFight(a, b);
		assertEquals(new Result(20,b), zf.battle());
	}
	
	@Test public void zombieKillAtFirstAttack() {
		
		//                            ATK,DEF,SPD,HP
		PoketZombie a = new PoketZombie(100,1,0,100);
		PoketZombie b = new PoketZombie(0,0,0,100);

		ZombieFight zf = new ZombieFight(a, b);
		assertEquals(new Result(1,a), zf.battle());
	}
	@Test public void SpeedTestZombieFightBattackFirst() {
		
		//                            ATK,DEF,SPD,HP
		PoketZombie a = new PoketZombie(100,0,4,100);
		PoketZombie b = new PoketZombie(100,0,10,100);

		ZombieFight zf = new ZombieFight(a, b);
		assertEquals(new Result(1,b), zf.battle());
	}
	
	@Test public void SpeedTestZombieFightAattackFirst() {
		
		//                            ATK,DEF,SPD,HP
		PoketZombie a = new PoketZombie(100,0,10,100);
		PoketZombie b = new PoketZombie(100,0,4,100);

		ZombieFight zf = new ZombieFight(a, b);
		assertEquals(new Result(1,a), zf.battle());
	}
@Test public void ZombieWithSameAttackAndDefenceAndSameHP() {
		
		//                            ATK,DEF,SPD,HP
		PoketZombie a = new PoketZombie(100,0,0,100);
		PoketZombie b = new PoketZombie(0,100,0,100);

		ZombieFight zf = new ZombieFight(a, b);
		assertEquals(new Result(19,a), zf.battle());
	}
	



	// TODO : add your own tests
}
