import java.util.ArrayList;

public class SWSystem {

	private String name;
	private String category;
	private String version;
	private ArrayList<QualityDimension> dimensions;

	public SWSystem(String name, String category, String version) {
		this.name = name;
		this.category = category;
		this.version = version;
		this.dimensions = new ArrayList<>();
	}

	public void addDimension(QualityDimension d) {
		dimensions.add(d);
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getVersion() {
		return version;
	}

	public ArrayList<QualityDimension> getDimensions() {
		return dimensions;
	}

	public double calculateOverallScore() {
		if (dimensions.isEmpty()) {
			return 1.0;
		}

		double totalWeighted = 0;
		double totalWeight = 0;

		for (QualityDimension d : dimensions) {
			totalWeighted += d.calculateDimensionScore() * d.getWeight();
			totalWeight += d.getWeight();
		}

		return Math.round((totalWeighted / totalWeight) * 10.0) / 10.0;
	}

	public QualityDimension findWeakestDimension() {
		QualityDimension weakest = null;
		double lowestScore = Double.MAX_VALUE;

		for (QualityDimension d : dimensions) {
			double score = d.calculateDimensionScore();
			if (score < lowestScore) {
				lowestScore = score;
				weakest = d;
			}
		}

		return weakest;
	}

	public String getOverallLabel() {
		double score = calculateOverallScore();
		if (score >= 4.5) {
			return "Excellent Quality";
		} else if (score >= 3.5) {
			return "Good Quality";
		} else if (score >= 2.5) {
			return "Needs Improvement";
		} else {
			return "Poor Quality";
		}
	}

	public void printReport() {
		System.out.println("========================================");
		System.out.println("SOFTWARE QUALITY EVALUATION REPORT (ISO/IEC 25010)");
		System.out.println("System: " + name + " v" + version + " (" + category + ")");
		System.out.println("========================================");

		for (QualityDimension d : dimensions) {
			System.out.println("--- " + d.getName() + " [" + d.getIsoCode() + "] (Weight: " + (int) d.getWeight() + ") ---");
			for (Criterion c : d.getCriteria()) {
				System.out.println(c.toString());
			}
			System.out.println(">> Dimension Score: " + d.calculateDimensionScore() + "/5 [" + d.getQualityLabel() + "]");
			System.out.println();
		}

		System.out.println("========================================");
		System.out.println("OVERALL QUALITY SCORE: " + calculateOverallScore() + "/5 [" + getOverallLabel() + "]");
		System.out.println("========================================");
		System.out.println("GAP ANALYSIS (ISO/IEC 25010)");
		System.out.println("========================================");

		QualityDimension weakest = findWeakestDimension();
		if (weakest != null) {
			double gap = Math.round(weakest.getQualityGap() * 10.0) / 10.0;
			System.out.println("Weakest Characteristic : " + weakest.getName() + " [" + weakest.getIsoCode() + "]");
			System.out.println("Score: " + weakest.calculateDimensionScore() + "/5 | Gap: " + gap);
			System.out.println("Level: " + weakest.getQualityLabel());
			System.out.println(">> This characteristic requires the most improvement.");
		}

		System.out.println("========================================");
	}
}
