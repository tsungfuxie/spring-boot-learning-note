package person.tsungfuxie.springguidesconsumingrest.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestResponseBasePojo {
	
	@JsonProperty("isSuccess")
	private Boolean isSuccess;

	@JsonProperty("errorMessage")
	private String errorMessage = "";

	@JsonProperty("errorMessageType")
	private String errorMessageType = "";
	
	

	@Override
	public String toString() {
		return "RestResponseBasePojo [isSuccess=" + isSuccess + ", errorMessage=" + errorMessage + ", errorMessageType="
				+ errorMessageType + "]";
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessageType() {
		return errorMessageType;
	}

	public void setErrorMessageType(String errorMessageType) {
		this.errorMessageType = errorMessageType;
	}
	
	

}
