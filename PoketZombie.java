import java.util.Comparator;

/**	A Poket Zombie keeps track of its hit points (hp), and when it can next
	attack another zombie. It attacks other zombies and ignores the living.

	@author Dilmanpreet N @ Langara for CPSC 1181-003 
	@version 2018-01-19
*/
public class PoketZombie {

    // TODO : declare your instance variables
    int atk=0, def=0, spd=0, hp=0, nextAtk=0;

    /**	Create a new poket zombie. Zombie can first attack at spd time.
    	
    	 
    	@param atk Attack stat. Higher is better. >=0
    	@param def Defense stat. Higher is better. >=1
    	@param spd Speed stat. Determines when and how often this zombie can attack. Lower is better. >=0.
    	@param hp initial HP.
    */
    public PoketZombie(int atk, int def, int spd, int hp) {
        // TODO
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.hp = hp;
        this.nextAtk = spd;

    }

    /** Gets the current HP.
    	@return the current HP
    */
    public int getHP() {
        return hp;
    }

    /** Determines if this zombie still has positive HP.
    	@return true iff this zombie still has positive HP
    */
    public boolean isUnDead() {
        if (hp > 0) //undead if hp greater than  0
            return true;
        else
            return false; //other possible case is less than zero

        // TODO
    }

    /** This zombie attacks the given zombie.
    	The other zombie has its HP reduced by:
    		this zombie's Attack Stat * 10 / other zombie's defense stat
    		(rounded towards zero).
    	eg:
    		Z(a:9), V(d:7,hp:100) -> V:hp:88
    	This zombie can attack again in it's Speed Stat amount of time.
    	eg:
    		Z(s:10) -> Z:n:20 -> Z:n:30 -> Z:n:40 -> Z:n:50...
    	@param o the other zombie to attack.
    */
    public void attack(PoketZombie o) {

    	if(o.def>0)
        o.hp = Math.round(o.hp - ((atk * 10) / o.def));
    	else
    		o.hp = Math.round(o.hp - ((atk * 10)));
        nextAtk = nextAtk + spd; //next attack in speed stat amount of time

    }

    /**	Determine which zombie can move next.
    	One zombie can move before the other if its next attack happens before the other zombie's next attack.
    	Next attack is determined by its Speed Stat.
    	EG: A(s:2),B(s:5).
    		A attacks B (2<5) -> A:n:4,B:n:5
    		A attacks B (4<5) -> A:n:6,B:n:5
    		B attacks A (5<6) -> A:n:6,B:n:10
    		... etc
    	@param a a zombie to evaluate for moving next
    	@param b a zombie to evaluate for moving next
    	@return which zombie moves next. null if there is a tie
    */
    public static PoketZombie whoNext(PoketZombie a, PoketZombie b) {
    	

        if (a.nextAtk > b.nextAtk) {
            a.nextAtk = a.nextAtk + a.spd;
            return a;

        } else if (a.nextAtk < b.nextAtk) {
            b.nextAtk = b.nextAtk + b.spd;
            return b;

        }
        return null;	//return null if same speed
    }
}