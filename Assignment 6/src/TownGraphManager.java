import java.util.ArrayList;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface
{
	//Your TownGraphManager will hold an object of your Graph. Implement the TownGraphManagerInterface
	 Graph tGraph;

	public TownGraphManager() 
	{
		tGraph=new Graph();
	}
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town a = this.getTown(town1);
		Town b = this.getTown(town2);
		
		Road r = tGraph.addEdge(a, b, weight, roadName);
		return r != null;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Road r = tGraph.getEdge(new Town(town1), new Town(town2));
		if (r == null) {
			return null;
		}
		return r.getName();
	}

	@Override
	public boolean addTown(String v) 
	{
		return tGraph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		if (!(tGraph.containsVertex(new Town(name)))) 
		{
			return null;
		}
		Set<Town> s = tGraph.roads.keySet();

		for (Town town : s) {

			if (town.equals(new Town(name))) {
				return town;
			}
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> allRoads()
	{
		ArrayList<String> combo = new ArrayList<String>();
		
		Set<Road> allR = tGraph.edgeSet();
		
		for (Road newRoad : allR) 
		{
			combo.add(newRoad.getName());
		}
		return combo;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}
}
