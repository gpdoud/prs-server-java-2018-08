package com.maxtrain.prs.util;

public class JsonResponse {
	
	private static final String successMessage = "Success!";
	private static final String failureMessage = "Failure!";

	private int code;
	private String message;
	private Object data;
	private Object error;
	
	public static JsonResponse Ok() {
		return new JsonResponse();
	}
	public static JsonResponse ReadSuccess(Object data) {
		return new JsonResponse(0, successMessage, data, null);
	}
	public static JsonResponse ReadByPkFailure(String entityName, int id) {
		String msg = String.format("Pk %d of %s - Not found!", id, entityName);
		return new JsonResponse(-1, msg, null, null);
	}
	
	public JsonResponse() {
		this(0);
	}
	public JsonResponse(int code) {
		this(code, code == 0 ? "Success!" : "Failure.");
	}
	public JsonResponse(Object data) {
		this(0, "Success!", data, null);
	}
	public JsonResponse(int code, String message) {
		this(code, message, null, null);
	}
	public JsonResponse(int code, String message, Object data, Object error) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}
	
	

}
