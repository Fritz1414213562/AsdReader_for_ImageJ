package lib;

import lib.util.VoltageLevelConverter;


public class UnipolarConverter extends VoltageLevelConverter {

	public UnipolarConverter(float rg) {
		this.range = rg;
		this.resolution = 4096;
	}

	public UnipolarConverter(float rg, long resol) {
		this.range = rg;
		this.resolution = resol;
	}

	public short voltageToLevel(float voltage) {
		return (short) Math.floor(voltage * (float) resolution);
	}

	public float levelToVoltage(short level) {
		return (float) (range * (float) level / (float) resolution);
	}

	public boolean isUnipolar() { return true; }

	private float range;
	private long resolution;
}
