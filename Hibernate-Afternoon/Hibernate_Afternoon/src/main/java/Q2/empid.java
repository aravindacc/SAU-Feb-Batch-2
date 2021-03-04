package Q2;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity

    public class empid 
    {
        @Id
        @Column(name = "EmpId")
        private int empId;
        
        @Column(name = "EmpName", length = 10)
        private String empName;
        
        @ManyToMany(targetEntity = employee.class, mappedBy = "ids")
        private Set<employee> eids;

        public Set<employee> getIds() 
        {
            return eids;
        }

        public void setId(Set<employee> eids) 
        {
            this.eids = eids;
        }

        public int getEmpId()
        {
            return empId;
        }

        public void setEmpId(int empId) 
        {
            this.empId = empId;
        }

        public String getEmpName()
        {
            return empName;
        }

        public void setEmpName(String empName) 
        {
            this.empName = empName;
        }
    }

