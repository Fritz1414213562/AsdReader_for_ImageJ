package lib;

import lib.util.VoltageLevelConverter;


public class BipolarConverter extends VoltageLevelConverter {

	public BipolarConverter(float rg) {
		this.range = rg;
		this.resolution = 4096;
	}
	public BipolarConverter(float rg, long resol) {
		this.range = rg;
		this.resolution = resol;
	}

	public short voltageToLevel(float voltage) {
		return (short) Math.floor(((voltage + range) / (2 * range)) * (float) resolution);
	}

	public float levelToVoltage(short level) {
		return range - 2 * (float) level * range / (float) resolution;
	}

	public boolean isUnipolar() { return false; }

	private float range;
	private long resolution;
}
