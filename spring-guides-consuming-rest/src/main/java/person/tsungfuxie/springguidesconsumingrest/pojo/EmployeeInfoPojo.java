package person.tsungfuxie.springguidesconsumingrest.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeInfoPojo  {

	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("role")
	private String role;

	@JsonProperty("isExternal")
	private Integer isExternal;

	@Override
	public String toString() {
		return "EmployeeInfoPojo [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", isExternal="
				+ isExternal + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getIsExternal() {
		return isExternal;
	}

	public void setIsExternal(Integer isExternal) {
		this.isExternal = isExternal;
	}
	
	
}
