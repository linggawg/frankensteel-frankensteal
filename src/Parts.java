import java.util.ArrayList;
import java.util.List;

public enum Parts {
	HEAD, BODY, LEFT_ARM, RIGHT_ARM, LEFT_LEG, RIGHT_LEG, CPU, RAM, HARD_DRIVE;

	static final List<Parts> getAllParts = new ArrayList<>();

	static {
		getAllParts.add(HEAD);
		getAllParts.add(BODY);
		getAllParts.add(LEFT_ARM);
		getAllParts.add(RIGHT_ARM);
		getAllParts.add(LEFT_LEG);
		getAllParts.add(RIGHT_LEG);
		getAllParts.add(CPU);
		getAllParts.add(RAM);
		getAllParts.add(HARD_DRIVE);
	}
}
