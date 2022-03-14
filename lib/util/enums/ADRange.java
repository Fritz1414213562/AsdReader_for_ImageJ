package lib.util.enums;

public enum ADRange {
	unipolar_1_0V((int) 0x00000001),
	unipolar_2_5V((int) 0x00000002),
	unipolar_5_0V((int) 0x00000004),
	bipolar_1_0V ((int) 0x00010000),
	bipolar_2_5V ((int) 0x00020000),
	bipolar_5_0V ((int) 0x00040000),
	dummy_value  ((int) 0x00000000);

	private final int number;
	ADRange(int number) {
		this.number = number;
	}

	private int getNumber() {
		return number;
	}

	public static ADRange valueFrom(int number) {
		for (ADRange value : ADRange.values()) {
			if (value.getNumber() == number) return value;
		}
		return null;
	}
}

