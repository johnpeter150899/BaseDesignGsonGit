public class Main
{
	public static void main(String []args){

		ResponseClass successResponse,failureResponse;
		successResponse = new ResponseClass();
		failureResponse = new ResponseClass();

		successResponse.setCode("200");
		successResponse.setMessage("success");
		successResponse.setSuccessResponse(new SuccessResponse());
		successResponse.getSuccessResponse().setName("abc");
		successResponse.getSuccessResponse().setAcc_no("12345");
		successResponse.getSuccessResponse().setRouting_no(34567);

		failureResponse.setCode("10508");
		failureResponse.setMessage("UserNotExist");
		failureResponse.setFailureResponse(new FailureResponse());
		failureResponse.getFailureResponse().setMessage("UserNotExist");

		System.out.println(successResponse);
		System.out.println(failureResponse);

		String successJson,failureJson;
		successJson = GlobalGson.gson.toJson(successResponse);
		failureJson = GlobalGson.gson.toJson(failureResponse);

		System.out.println("Object to Json");
		System.out.println(successJson);
		System.out.println(failureJson);

		ResponseClass r1,r2;
		r1 = GlobalGson.gson.fromJson(successJson,ResponseClass.class);
		r2 = GlobalGson.gson.fromJson(failureJson,ResponseClass.class);

		System.out.println("Json to Object");
		System.out.println(r1);
		System.out.println(r2);
	}
}
