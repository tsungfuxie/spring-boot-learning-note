package person.tsungfuxie.springguidesconsumingrest.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FindEmployeeInfoResponsePojo extends RestResponseBasePojo {
	
	@JsonProperty("result")
	private EmployeeInfoPojo employeeInfoPojo;

	@Override
	public String toString() {
		return "FindEmployeeInfoResponsePojo [employeeInfoPojo=" + employeeInfoPojo + "]";
	}

	public EmployeeInfoPojo getEmployeeInfoPojo() {
		return employeeInfoPojo;
	}

	public void setEmployeeInfoPojo(EmployeeInfoPojo employeeInfoPojo) {
		this.employeeInfoPojo = employeeInfoPojo;
	}
	
	

}
