package Q1;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String PName;
	private int price;
	
	public int getPid() 
	{
		return id;
	}

	public void setPid(int prodcut_id) 
	{
		this.id = prodcut_id;
	}

	public String getPname() 
	{
		return PName;
	}

	public void setPname(String PName)
	{
		this.PName = PName;
	}

	public int getPrice() 
	{
		return price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}
	
	@Override
	public String toString() 
	{
		return "Product [prodcut_id=" + id + ", PName=" + PName + ", price=" + price;
	}
}