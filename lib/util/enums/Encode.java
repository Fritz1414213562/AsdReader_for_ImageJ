package lib.util.enums;

public enum Encode {
	Shift_JIS(932),
	UTF_16(1200),
	EUC_JP(20932),
	UTF_8(65001),
	JP_MAC(10001),
	ASCII(20127);

	private final int number;
	Encode(int number) {
		this.number = number;
	}

	private int getNumber() {
		return number;
	}

	public static Encode valueFrom(int number) {
		for (Encode value : Encode.values()) {
			if (value.getNumber() == number) return value;
		}
		return null;
	}
}
