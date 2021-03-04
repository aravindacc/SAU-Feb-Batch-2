package Q1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String CName;
	public int getCategory_id() 
	{
		return id;
	}
	
	public void setCategory_id(int category_id) 
	{
		this.id = category_id;
	}
	@OneToMany
	private List<Product>products=new ArrayList<Product>();
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	@ManyToMany(mappedBy="categories")
	private List<Supplier> suppliers=new ArrayList<Supplier>();

	public List<Supplier> getSuppliers() 
	{
		return suppliers;
	}
	public void setSuppliers(List<Supplier> suppliers) 
	{
		this.suppliers = suppliers;
	}
	public List<Product> getProducts() 
	{
		return products;
	}
	public void setProducts(List<Product> products) 
	{
		this.products = products;
	}
	
	public String getCname() 
	{
		return CName;
	}
	public void setCname(String CName) 
	{
		this.CName = CName;
	}
}