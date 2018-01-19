
/** A battle between two PoketZombies.
	Two zombies enter; One zombie leaves; unless they draw.
	
	@author Dilmanpreet N @ Langara for CPSC 1181
	@version 2018-01-19
*/
public class ZombieFight {

	private final static int MAX_ROUNDS = 100;
	
	private final PoketZombie a;
	private final PoketZombie b;

	public ZombieFight(PoketZombie a, PoketZombie b) {
		this.a = a;
		this.b = b;
	}

	/** The zombies battle.
		The battle consists of up to 100 rounds.
		Each round: one zombie attacks the other.
		The zombie to attack is determined by which zombie can move first.
		If there is a movement tie, the zombie who did not move last shall move first.
		If there is a movement tie in the first round, zombie "a" shall move first.
		The battle contininues until one zombie is no longer unDead,
			in which case the surviving zombie wins.
		If all 100 rounds finish and both zombies survive,
			then the battle is a draw and the zombies become friends.
	*/
	public Result battle() {
		int battleRound;//ROUND NUMBER for the battle
		 int turn = 0;	// To keep track who attacked last battle 

				for( battleRound = 0 ; battleRound <MAX_ROUNDS && a.isUnDead() && b.isUnDead(); battleRound++){
					
					if(a.nextAtk == b.nextAtk){	// for tied attack round / movement tie		
						if (turn == 0){	
								a.attack(b);	//zombie a attacks moves first on first round
								turn = 1;
							}
						else if(turn == 1){
								b.attack(a);
								turn = 0;
							}
						
					}
					else{
						if (PoketZombie.whoNext(a,b) == a ){
							a.attack(b);
							turn = 0;
						}
						else if(PoketZombie.whoNext(a,b) == b){
							b.attack(a);
							turn = 1;
						}

					}
				}
			
			if(a.getHP() == b.getHP())			// if battle finished and same hp it is a tie
				return new Result(battleRound);
			
			
			else if((b.getHP() <= 0) && (a.getHP() > 0))	// a win

				return new Result(battleRound , a);		
				
			else if((a.getHP() <= 0) && (b.getHP() > 0))	// b win

				return new Result(battleRound , b);
					
			else 
				return new Result(battleRound);	// battle finish they became friends
				
			}
	}
	