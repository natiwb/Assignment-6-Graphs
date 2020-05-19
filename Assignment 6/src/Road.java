
public class Road implements Comparable<Road>
{
	int degrees;
	String name;
	Town source,destination;
	/*
	 * Road

public Road(Town source,
            Town destination,
            int degrees,
            java.lang.String name)
Constructor
Parameters:
source - One town on the road
destination - Another town on the road
i - Weight of the edge, i.e., distance from one town to the other
roadName - Name of the road

	 */
	public Road(Town source,Town destination,int degrees, String name) 
	{
		this.degrees=degrees;
		this.source=source;
		this.destination=destination;
		this.name=name;
	}
	/*
	 * Road

public Road(Town source,
            Town destination,
            java.lang.String name)
Constructor with weight preset at 1
Parameters:
source - One town on the road
destination - Another town on the road
name - Name of the road
	 */
	public Road(Town source,Town destination,String name) 
	{
		degrees=1;
		this.source=source;
		this.destination=destination;
		this.name=name;
	}

	/*
	 *contains

public boolean contains(Town town)
Returns true only if the edge contains the given town
Parameters:
town - a vertex of the graph
Returns:
true only if the edge is connected to the given vertex

	 */

	public boolean contains(Town town) 
	{
		if(source.equals(town)||destination.equals(town)) 
		{
			return true;
		}
		else
			return false;
	}
	@Override
	public String toString() {
		return "Road [degrees=" + degrees + ", name=" + name + ", source=" + source + ", destination=" + destination
				+ "]";
	}
	public int getDegrees() {
		return degrees;
	}
	public String getName() {
		return name;
	}
	public Town getSource() {
		return source;
	}
	public Town getDestination() {
		return destination;
	}

	/*
	 * compareTo

public int compareTo(Road o)
Specified by:
compareTo in interface java.lang.Comparable<Road>
Returns:
0 if the road names are the same, a positive or negative number if the road names are not the same

	 */
	public int compareToRoad(Road o) 
	{
		if(o.name.equalsIgnoreCase(this.name)) 
		{
			return 1;
		}
		else
			return 0;
	}

	/*
	 * equals

public boolean equals(java.lang.Object r)
Returns true if each of the ends of the road r is the same as the ends of this road. Remember that a road that goes from point A to point B is the same as a road that goes from point B to point A.
Overrides:
equals in class java.lang.Object
Parameters:
r - road object to compare it to

	 */
	public boolean equals(Object r) 
	{
		Road temp;
		if(r == null || !(r instanceof Road)) 
		{
			return false;
		}
		else 
		{
			temp=(Road) r;
			if((temp.getSource().equals(this.getSource())&&(temp.getDestination().equals(this.getDestination()))))
				{
				 return true;
			
				}
			else
				return false;
		}
	}
	@Override
	public int compareTo(Road o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
