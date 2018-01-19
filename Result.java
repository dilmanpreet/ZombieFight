import java.util.Objects;

public class Result {

	public static enum Outcome { KO, DRAW }

	public final Outcome out;
	public final int rounds;
	public final PoketZombie winner;

	public Result(int rounds) {
		this.out = Outcome.DRAW;
		this.rounds = rounds;
		this.winner = null;
	}

	public Result(int rounds, PoketZombie winner) {
		this.out = Outcome.KO;
		this.rounds = rounds;
		this.winner = winner;
	}

	public Outcome getOutcome() {
		return out;
	}

	public int getRounds() {
		return rounds;
	}

	public PoketZombie getWinner() {
		return winner;
	}

	@Override
	public String toString() {
		return "{ " + out + ", r:" + rounds + ", w:" + winner + " }";
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Result && equals((Result) o);
	}

	private boolean equals(Result o) {
		return this.out == o.out
			&& this.rounds == o.rounds
			&& Objects.equals(this.winner, o.winner);
	}

	public int hashCode() {
		return Objects.hash(out, rounds, winner);
	}
}
