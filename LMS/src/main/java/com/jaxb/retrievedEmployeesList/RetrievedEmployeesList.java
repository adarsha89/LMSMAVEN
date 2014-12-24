

package com.jaxb.retrievedEmployeesList;



import java.util.List;

import javax.xml.bind.annotation.*;

import com.jaxb.retrievedEmployee.*;

@XmlRootElement(name = "retrievedEmployeesList")
@XmlAccessorType (XmlAccessType.FIELD)
public class RetrievedEmployeesList {

	@XmlElement(name = "retrievedEmployee")
    private List<RetrievedEmployee> retrievedEmployeesList = null;
 
    public List<RetrievedEmployee> getRetrievedEmployees() {
        return retrievedEmployeesList;
    }
 
    public void setRetrievedEmployees(List<RetrievedEmployee> employees) {
        this.retrievedEmployeesList = employees;
    }
}
