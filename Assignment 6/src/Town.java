import java.util.LinkedList;

public class Town implements Comparable<Town> 
{
	String name;
	LinkedList<Town> adjacent = new LinkedList<>();
	

	public Town(String name) 
	{
		this.name=name;
	}

	public Town(Town debreMarkos) 
	{
		this.name=debreMarkos.name;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	compareTo

	public int compareTo(Town o)
	Compare to method
	Specified by:
		compareTo in interface java.lang.Comparable<Town>
	Returns:
		0 if names are equal, a positive or negative number if the names are not equal
	 */

	public int compareTo(Town o) 
	{
		if(o.getName().equalsIgnoreCase(this.getName())) 
		{
			return 0;
		}
		else
			return -1;
	}
	/*
	toString

	public java.lang.String toString()
	To string method
	Overrides:
		toString in class java.lang.Object
		Returns:
			the town name
	 */

	@Override
	public String toString() {
		return name;
	}
	/*
	hashCode

	public int hashCode()
	Overrides:
		hashCode in class java.lang.Object
		Returns:
			the hashcode for the name of the town
	 */
	@Override
	public int hashCode() 
	{
		return name.hashCode();
	}

	/*	equals

	public boolean equals(java.lang.Object obj)
	Overrides:
	equals in class java.lang.Object
	Returns:
	true if the town names are equal, false if not
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if(obj == null || !(obj instanceof Town)) 
		{
			return false;
		}
		
		else 
		{
			Town comp = (Town)obj;
			
			if(comp.getName().equalsIgnoreCase(name)) 
			{
				return true;
			}
			else 
				return false;
		}
	}
	
	public LinkedList<Town> getAdjacent()
	{
		return adjacent;
	}
	
	//for adding adjacent towns
	public LinkedList<Town> addAdjacentTown(Town t) 
	{
		adjacent.add(t);
		return adjacent;
	}

}
