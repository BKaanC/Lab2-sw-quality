import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		HashMap<String, ArrayList<SWSystem>> allSystems = SWSystemData.getAllSystems();
       ArrayList<SWSystem> webSystems = allSystems.get("Web");

		SWSystem shopSphere = null;
		for (SWSystem sys : webSystems) {
			if (sys.getName().equals("ShopSphere")) {
				shopSphere = sys;
			}
		}

		if (shopSphere == null) {
			System.out.println("System not found.");
			return;
		}

		QualityDimension funcSuit = shopSphere.getDimensions().get(0);
		funcSuit.getCriteria().get(0).setMeasuredValue(94);
		funcSuit.getCriteria().get(1).setMeasuredValue(91);

		QualityDimension reliability = shopSphere.getDimensions().get(1);
		reliability.getCriteria().get(0).setMeasuredValue(99.2);
		reliability.getCriteria().get(1).setMeasuredValue(2.1);

		QualityDimension performance = shopSphere.getDimensions().get(2);
		performance.getCriteria().get(0).setMeasuredValue(220);
		performance.getCriteria().get(1).setMeasuredValue(38);

		QualityDimension maintainability = shopSphere.getDimensions().get(3);
		maintainability.getCriteria().get(0).setMeasuredValue(72);
		maintainability.getCriteria().get(1).setMeasuredValue(8.5);

		shopSphere.printReport();
	}
}
