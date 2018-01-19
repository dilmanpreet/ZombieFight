import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
javac -cp ".;junit.jar" *.java && java -cp ".;junit.jar" AllTests
*/

@RunWith(Suite.class)
@Suite.SuiteClasses({
	PoketZombieTest.class,
	ZombieFightTest.class
})

public class AllTests {
	// the class remains empty,
	// used only as a holder for the above annotations

	// COMMENT OUT THIS MAIN METHOD IF YOU USE AN IDE
	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main(AllTests.class.getName());
	}
}
