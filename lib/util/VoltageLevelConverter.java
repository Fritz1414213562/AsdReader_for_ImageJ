package lib.util;

public abstract class VoltageLevelConverter {
	public abstract short voltageToLevel(float voltage);
	public abstract float levelToVoltage(short level);
	public abstract boolean isUnipolar();
}
