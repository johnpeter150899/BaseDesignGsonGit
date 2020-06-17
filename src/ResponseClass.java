import com.google.gson.annotations.Expose;

public class ResponseClass
{
	private String code;
	private String message;
	private SuccessResponse successResponse;
	private FailureResponse failureResponse;

	ResponseClass(){}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SuccessResponse getSuccessResponse()
	{
		return successResponse;
	}

	public void setSuccessResponse(SuccessResponse successResponse)
	{
		this.successResponse = successResponse;
	}

	public FailureResponse getFailureResponse()
	{
		return failureResponse;
	}

	public void setFailureResponse(FailureResponse failureResponse)
	{
		this.failureResponse = failureResponse;
	}

	public String toString(){
		return " [ code = "+code+" message = "+message+" Success Response = "+successResponse+" Failure Response = "+failureResponse+" ] ";
	}
}

class SuccessResponse {
	private String name;
	private String acc_no;
	private int routing_no;

	SuccessResponse(){}

	public String getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRouting_no() {
		return routing_no;
	}

	public void setRouting_no(int routing_no) {
		this.routing_no = routing_no;
	}

	public String toString(){
		return "[ name = "+name+" acc_no = "+acc_no+" routing_no = "+routing_no+" ]";
	}
}

class FailureResponse {

	private String message;
	FailureResponse(){}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString(){ return "[ message = "+getMessage()+" ]"; }
}