package Q1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Supplier 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String SName;
	
	@ManyToMany
	private List<Category> categories=new ArrayList<Category>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Category> getCategories() 
	{
		return categories;
	}

	public void setCategories(List<Category> categories) 
	{
		this.categories = categories;
	}
	
	public String getSname() 
	{
		return SName;
	}

	public void setSname(String SName) 
	{
		this.SName = SName;
	}
}