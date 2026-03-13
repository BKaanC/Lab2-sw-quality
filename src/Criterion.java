public class Criterion {

	private String name;
	private double weight;
	private String direction;
	private double minValue;
	private double maxValue;
	private String unit;
	private double measuredValue;
	private boolean valueSet;

	public Criterion(String name, double weight, String direction, double minValue, double maxValue, String unit) {
		this.name = name;
		this.weight = weight;
		this.direction = direction;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.unit = unit;
		this.valueSet = false;
	}

	public void setMeasuredValue(double measuredValue) {
		this.measuredValue = measuredValue;
		this.valueSet = true;
	}

	public double getMeasuredValue() {
		return measuredValue;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public String getDirection() {
		return direction;
	}

	public String getUnit() {
		return unit;
	}

	public double calculateScore() {
		if (!valueSet) {
			return 1.0;
		}

		double raw;
		if (direction.equals("higher")) {
			raw = 1 + (measuredValue - minValue) / (maxValue - minValue) * 4;
		} else {
			raw = 5 - (measuredValue - minValue) / (maxValue - minValue) * 4;
		}

		if (raw < 1.0) raw = 1.0;
		if (raw > 5.0) raw = 5.0;

		double rounded = Math.round(raw * 2.0) / 2.0;
		return rounded;
	}

	@Override
	public String toString() {
		String dirLabel = direction.equals("higher") ? "Higher is better" : "Lower is better";
		return name + ": " + measuredValue + " " + unit + " -> Score: " + calculateScore() + " (" + dirLabel + ")";
	}
}
