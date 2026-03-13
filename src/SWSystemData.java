import java.util.ArrayList;
import java.util.HashMap;
 
public class SWSystemData {
 
	public static HashMap<String, ArrayList<SWSystem>> getAllSystems() {
		HashMap<String, ArrayList<SWSystem>> map = new HashMap<>();
 
		ArrayList<SWSystem> webList = new ArrayList<>();
		webList.add(createECommercePlatform());
		webList.add(createBankingPortal());
		map.put("Web", webList);
 
		ArrayList<SWSystem> mobileList = new ArrayList<>();
		mobileList.add(createHealthApp());
		map.put("Mobile", mobileList);
 
		return map;
	}
 
	private static SWSystem createECommercePlatform() {
		SWSystem s = new SWSystem("ShopSphere", "Web", "3.2.1");
 
		QualityDimension funcSuit = new QualityDimension("Functional Suitability", "QC.FS", 25);
		funcSuit.addCriterion(new Criterion("Functional Completeness Ratio", 50, "higher", 0, 112, "%"));
		funcSuit.addCriterion(new Criterion("Functional Correctness Ratio", 50, "higher", 0, 100, "%"));
		s.addDimension(funcSuit);
 
		QualityDimension reliability = new QualityDimension("Reliability", "QC.RE", 25);
		reliability.addCriterion(new Criterion("Availability Ratio", 50, "higher", 95, 100, "%"));
		reliability.addCriterion(new Criterion("Defect Density", 50, "lower", 0, 20, "defect/KLOC"));
		s.addDimension(reliability);
 
		QualityDimension performance = new QualityDimension("Performance Efficiency", "QC.PE", 25);
		performance.addCriterion(new Criterion("Response Time", 50, "lower", 100, 660, "ms"));
		performance.addCriterion(new Criterion("CPU Utilisation", 50, "lower", 0, 152, "%"));
		s.addDimension(performance);
 
		QualityDimension maintainability = new QualityDimension("Maintainability", "QC.MA", 25);
		maintainability.addCriterion(new Criterion("Test Coverage Ratio", 50, "higher", 0, 115, "%"));
		maintainability.addCriterion(new Criterion("Cyclomatic Complexity", 50, "lower", 1, 21, "score"));
		s.addDimension(maintainability);
 
		return s;
	}
 
	private static SWSystem createBankingPortal() {
		SWSystem s = new SWSystem("SecureBank", "Web", "2.0.4");
 
		QualityDimension security = new QualityDimension("Security", "QC.SE", 40);
		security.addCriterion(new Criterion("Security Test Coverage", 60, "higher", 0, 100, "%"));
		security.addCriterion(new Criterion("Vulnerability Count", 40, "lower", 0, 50, "count"));
		s.addDimension(security);
 
		QualityDimension reliability = new QualityDimension("Reliability", "QC.RE", 30);
		reliability.addCriterion(new Criterion("Availability Ratio", 50, "higher", 95, 100, "%"));
		reliability.addCriterion(new Criterion("MTBF", 50, "higher", 0, 10000, "hours"));
		s.addDimension(reliability);
 
		QualityDimension performance = new QualityDimension("Performance Efficiency", "QC.PE", 30);
		performance.addCriterion(new Criterion("Response Time", 50, "lower", 100, 2000, "ms"));
		performance.addCriterion(new Criterion("Throughput", 50, "higher", 0, 5000, "req/s"));
		s.addDimension(performance);
 
		return s;
	}
 
	private static SWSystem createHealthApp() {
		SWSystem s = new SWSystem("HealthTrack", "Mobile", "1.5.0");
 
		QualityDimension usability = new QualityDimension("Usability", "QC.US", 35);
		usability.addCriterion(new Criterion("Task Completion Rate", 50, "higher", 0, 100, "%"));
		usability.addCriterion(new Criterion("User Error Rate", 50, "lower", 0, 100, "%"));
		s.addDimension(usability);
 
		QualityDimension reliability = new QualityDimension("Reliability", "QC.RE", 35);
		reliability.addCriterion(new Criterion("Availability Ratio", 50, "higher", 95, 100, "%"));
		reliability.addCriterion(new Criterion("Defect Density", 50, "lower", 0, 20, "defect/KLOC"));
		s.addDimension(reliability);
 
		QualityDimension funcSuit = new QualityDimension("Functional Suitability", "QC.FS", 30);
		funcSuit.addCriterion(new Criterion("Functional Completeness Ratio", 50, "higher", 0, 100, "%"));
		funcSuit.addCriterion(new Criterion("Functional Correctness Ratio", 50, "higher", 0, 100, "%"));
		s.addDimension(funcSuit);
 
		return s;
	}
}