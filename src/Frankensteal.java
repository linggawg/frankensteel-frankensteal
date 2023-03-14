import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frankensteal implements Runnable {
	public List<Parts> collection = new ArrayList<>();
	public int robotAssembled;
	public List<Parts> dump;

	public Frankensteal(List<Parts> dump) {
		this.dump = dump;
	}

	@Override
	public void run() {
		collectParts();
	}

	public void collectParts() {
		Random random = new Random();

		int count = 0;
		int bound = random.nextInt(4);
		if ((dump.size()) - 1 > bound) {
			for (int i = 0; i < bound + 1; i++) {
				int index = random.nextInt(dump.size() - 1);
				Parts parts = dump.get(index);

				collection.add(parts);
				dump.remove(index);
				count++;
			}
		}

		System.out.println("Frankensteal takes " + count + " parts");
	}
}
