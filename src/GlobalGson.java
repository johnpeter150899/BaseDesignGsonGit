import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

class ResponseSerializer implements JsonSerializer<ResponseClass>
{
	@Override
	public JsonElement serialize(ResponseClass src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("code",src.getCode());
		if(src.getMessage().equals("success")){
			jsonObject.addProperty("message",src.getMessage());
			jsonObject.add("data",context.serialize(src.getSuccessResponse(),SuccessResponse.class));
		}
		else{
			jsonObject.addProperty("message",src.getFailureResponse().getMessage());
		}
		return jsonObject;
	}
}

class ResponseDeserializer implements JsonDeserializer<ResponseClass>
{
	@Override
	public ResponseClass deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
	{
		JsonObject jsonObject = json.getAsJsonObject();
		JsonElement message = jsonObject.get("message");
		ResponseClass result=new ResponseClass();
		if (message != null) {
			if (message.getAsString().equals("success")) {
				result.setSuccessResponse(context.deserialize(jsonObject.get("data"),SuccessResponse.class));
				result.setMessage("success");
			}
			else{
				result.setFailureResponse(context.deserialize(jsonObject,FailureResponse.class));
				result.setMessage(message.getAsString());
			}
			result.setCode(jsonObject.get("code").getAsString());
		}
		return result;
	}
}


public class GlobalGson
{
	public static final Gson gson = new GsonBuilder()
		.registerTypeAdapter(ResponseClass.class,new ResponseSerializer())
		.registerTypeAdapter(ResponseClass.class,new ResponseDeserializer())
		.setPrettyPrinting()
		.create();
}
