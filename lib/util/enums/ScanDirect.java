package lib.util.enums;

public enum ScanDirect {
	Xfwd(1),
	Xbwd(2),
	Yfwd(3),
	Ybwd(4);

	private final int number;
	ScanDirect(int number) {
		this.number = number;
	}

	private int getNumber() {
		return number;
	}

	public static ScanDirect valueFrom(int number) {
		for (ScanDirect value : ScanDirect.values()) {
			if (value.getNumber() == number) return value;
		}
		return null;
	}
}

