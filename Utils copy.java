
import java.util.Random;

public class Utils {
	static Random rand = new Random();

	// Generate a random integer between min and max
	public static int randBetween(int min, int max) {
		return rand.nextInt(max - min + 1) + min;
	}

}
