import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphInterface<Town,Road>
{
	Map<Town, Set<Road>> roads=new HashMap<>();


	/**
	 * Returns an edge connecting source vertex to target vertex if such
	 * vertices and such edge exist in this graph. Otherwise returns
	 * null. If any of the specified vertices is null
	 * returns null
	 *
	 * In undirected graphs, the returned edge may have its source and target
	 * vertices in the opposite order.
	 *
	 * @param sourceVertex source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 *
	 * @return an edge connecting source vertex to target vertex.
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex)
	{
		if(sourceVertex == null||destinationVertex == null)
		{

			return null;
		}
		else 
		{
			Road temp=new Road(sourceVertex,destinationVertex,"");
			//Will use equals method in run class for the comparison as it doesnt compare the names

			for (Town t : roads.keySet())
			{
				//keySet() method in Java is used to create a set out of the key elements contained 
				//in the hash map. It basically returns a set view of the keys or we can create a new set and store 
				//the key elements in them.
				Set<Road> r = roads.get(t);

				for (Road edge : r)
				{
					if(edge.compareTo(temp)==0) 
					{
						return temp;
					}
				}
			}	

		}
		return null;
	}


	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
	{
		if(sourceVertex == null || destinationVertex == null)
			throw  new NullPointerException("Cannot be Null");

		else {


			Road temp = new Road(sourceVertex,  destinationVertex,  weight,  description);

			
			destinationVertex = this.update(destinationVertex);
            sourceVertex = this.update(sourceVertex);
			
			roads.get(sourceVertex).add(temp);
			roads.get(destinationVertex).add(temp);

			return temp;
		}

	}

	private Town update(Town vertex) 
	{

		for (Town e : roads.keySet()) 
		{
			if(e.compareTo(vertex)==0)
			{	
				return e;
			}
		}
		return null;
	}

	/**
	 * Returns true if and only if this graph contains an edge going
	 * from the source vertex to the target vertex. In undirected graphs the
	 * same result is obtained when source and target are inverted. If any of
	 * the specified vertices does not exist in the graph, or if is
	 * null, returns false.
	 *
	 * @param sourceVertex source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 *
	 * @return true if this graph contains the specified edge.
	 */
	@Override
	public boolean addVertex(Town v) 
	{
		if(!roads.containsKey(v)) {
			roads.put(v,new HashSet<Road>());
			return true;
		}
		return false;
	}
	/*
	 * /**
	 * Returns true if this graph contains the specified vertex. More
	 * formally, returns true if and only if this graph contains a
	 * vertex u such that u.equals(v). If the
	 * specified vertex is null returns false.
	 *
	 * @param v vertex whose presence in this graph is to be tested.
	 *
	 * @return true if this graph contains the specified vertex.
	 */

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) 
	{
		Road n=new Road(sourceVertex,destinationVertex,"");	
		Set<Road> rd = roads.get(sourceVertex);


		if(rd.contains(n)) 
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v)
	{
		if(roads.keySet().contains(v)) 
		{
			return true;
		}
		return false;
	}
	/**
	 * Returns a set of all edges touching the specified vertex (also
	 * referred to as adjacent vertices). If no edges are
	 * touching the specified vertex returns an empty set.
	 *
	 * @param vertex the vertex for which a set of touching edges is to be
	 * returned.
	 *
	 * @return a set of all edges touching the specified vertex.
	 *
	 * @throws IllegalArgumentException if vertex is not found in the graph.
	 * @throws NullPointerException if vertex is null.
	 */
	@Override
	public Set<Road> edgesOf(Town vertex)
	{
		Set<Road> rd = roads.get(vertex);
		return rd;
	}

	/*
	 * /**
	 * Removes an edge going from source vertex to target vertex, if such
	 * vertices and such edge exist in this graph. 
	 * 
	 * If weight >- 1 it must be checked
	 * If description != null, it must be checked 
	 * 
	 * Returns the edge if removed
	 * or null otherwise.
	 *
	 * @param sourceVertex source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 * @param weight weight of the edge
	 * @param description description of the edge
	 *
	 * @return The removed edge, or null if no edge removed.
	 */

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) 
	{
		if(weight < 0 || description == null) {
			return null;
		}
		Road r = new Road(sourceVertex,destinationVertex,weight,description);

		if(!roads.get(sourceVertex).contains(r)) 
		{
			return null;
		}
		else if(!roads.containsKey(destinationVertex)|| !roads.containsKey(sourceVertex)) 
		{
			return null;
		}

		else 
		{	
			roads.get(destinationVertex).remove(r);		
			roads.get(sourceVertex).remove(r);
			return r;
		}

	}

	@Override
	public boolean removeVertex(Town v)
	{

		return false;
	}

	/**
	 * Find the shortest path from the sourceVertex to the destinationVertex
	 * call the dijkstraShortestPath with the sourceVertex
	 * @param sourceVertex starting vertex
	 * @param destinationVertex ending vertex
	 * @return An arraylist of Strings that describe the path from sourceVertex
	 * to destinationVertex
	 * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
	 */   
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Dijkstra's Shortest Path Method.  Internal structures are built which
	 * hold the ability to retrieve the path, shortest distance from the
	 * sourceVertex to all the other vertices in the graph, etc.
	 * @param sourceVertex the vertex to find shortest path from
	 * 
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) 
	{


	}

	/**
	 * Returns a set of the edges contained in this graph. The set is backed by
	 * the graph, so changes to the graph are reflected in the set. If the graph
	 * is modified while an iteration over the set is in progress, the results
	 * of the iteration are undefined.
	 *
	 *
	 * @return a set of the edges contained in this graph.
	 */

	@Override
	public Set<Road> edgeSet() 
	{
		Set<Road> setOfEdges = new HashSet<Road>();

	
		for (Set<Road> road:roads.values()) 
		{
			setOfEdges.addAll(road);
		}
		
		return setOfEdges;

	}


	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}
}
