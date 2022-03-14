package lib.util.enums;

public enum DataKind {
	Topography(0x5054),
	Error(0x5245),
	Phase(0x4850),
	None(0x0000);

	private final int number;
	DataKind(int number) {
		this.number = number;
	}

	private int getNumber() {
		return number;
	}

	public static DataKind valueFrom(int number) {
		for (DataKind value : DataKind.values()) {
			if (value.getNumber() == number) return value;
		}
		return null;
	}
}
