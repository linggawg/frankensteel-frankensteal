import java.util.List;
import java.util.Random;

public class Factory implements Runnable {

	public List<Parts> dump;

	public Factory(List<Parts> dump) {
		this.dump = dump;
	}

	@Override
	public void run() {
		generateParts();
	}

	public void generateParts() {
		Random random = new Random();

		int bound = 0;
		for (int i = 0; i < random.nextInt(4) + 1; i++) {
			Parts part = Main.getRandomPart();

			dump.add(part);
			bound++;
		}
		System.out.println("FACTORY GENERATED PARTS: " + bound);
	}
}