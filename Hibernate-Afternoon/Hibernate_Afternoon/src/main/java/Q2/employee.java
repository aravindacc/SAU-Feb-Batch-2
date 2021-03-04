package Q2;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Entity
public class employee {
    @Id
    @Column(name = "employeeid")
    private int EmployeeId;
    
    @Column(name = "employeename", length = 10)
    private String EmployeeName;
    
    @ManyToMany(targetEntity = empid.class, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_ids",
            joinColumns = @JoinColumn(referencedColumnName = "employeeid"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "EmpId"))
    private Set<Item> ids;

    public int getEmployeeId() 
    {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) 
    {
        this.EmployeeId = EmployeeId;
    }

    public Set<Item> getIds() 
    {
        return ids;
    }

    public void setIds(Set<Item> ids) 
    {
        this.ids = ids;
    }

    public String getEmployeeName() 
    {
        return EmployeeName;
    }

    public void setEmployeeName(String employeename) 
    {
        this.EmployeeName = employeename;
    }

}