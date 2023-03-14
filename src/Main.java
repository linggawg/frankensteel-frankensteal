import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		List<Parts> dump = new ArrayList<>();
		Factory factory = new Factory(dump);
		while (dump.size() < 20) {
			factory.dump.add(getRandomPart());
		}

		Frankensteel frankensteel = new Frankensteel(factory.dump);
		Frankensteal frankensteal = new Frankensteal(factory.dump);

		int index = 1;
		boolean firstNight = true;
		int stopTime = 0;
		while (stopTime < 10000) {
			System.out.println("=========NIGHT " + index + "=========");
			stopTime += 100;

			Thread.sleep(100);

			System.out.println("DUMP SIZE: " + factory.dump.size());
			if (!firstNight) {
				factory.run();
			}
			firstNight = false;

			frankensteel.run();

			frankensteal.run();

			System.out.println("=========================");
			index++;
		}

		System.out.println("COLLECTION FSTEEL: " + frankensteel.collection.size());
		assembleParts(frankensteel);
		System.out.println("ROBOTS FSTEEL: " + frankensteel.robotAssembled);

		System.out.println("COLLECTION FSTEAL: " + frankensteal.collection.size());
		assembleParts(frankensteal);
		System.out.println("ROBOTS FSTEAL: " + frankensteal.robotAssembled);
	}

	public static Parts getRandomPart() {
		Random random = new Random();

		return Parts.getAllParts.get(random.nextInt(9));
	}

	public static void assembleParts(Frankensteel frankensteel) {
		frankensteel.collection.sort((x, y) -> x.name().compareToIgnoreCase(y.name()));

		List<HashSet<Parts>> robots = new ArrayList<>();
		while (!frankensteel.collection.isEmpty()) {
			HashSet<Parts> robot = new HashSet<>();
			for (int i = 0; i < frankensteel.collection.size(); i++) {
				if (!robot.contains(frankensteel.collection.get(i))) {
					robot.add(frankensteel.collection.get(i));
					frankensteel.collection.remove(i);
				}
			}

			if (robot.size() == 9) {
				robots.add(robot);
			}
			robot.clear();
		}

		frankensteel.robotAssembled = robots.size();
	}

	public static void assembleParts(Frankensteal frankensteal) {
		frankensteal.collection.sort((x, y) -> x.name().compareToIgnoreCase(y.name()));

		List<HashSet<Parts>> robots = new ArrayList<>();
		while (!frankensteal.collection.isEmpty()) {
			HashSet<Parts> robot = new HashSet<>();
			for (int i = 0; i < frankensteal.collection.size(); i++) {
				if (!robot.contains(frankensteal.collection.get(i))) {
					robot.add(frankensteal.collection.get(i));
					frankensteal.collection.remove(i);
				}
			}

			if (robot.size() == 9) {
				robots.add(robot);
			}
			robot.clear();
		}

		frankensteal.robotAssembled = robots.size();
	}
}