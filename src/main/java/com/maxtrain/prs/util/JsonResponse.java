package com.maxtrain.prs.util;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

public class JsonResponse {
	
	private static final String successMessage = "Success!";
	private static final String failureMessage = "Failure!";
	
	public static final int successCode = 0;
	public static final int pkNotFoundCode = -1;
	public static final int dataIntegrityViolationCode = -2;
	public static final int generalExceptionCode = -999;


	private int code;
	private String message;
	private Object data;
	private Object error;
	
	
	
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	public Object getError() {
		return error;
	}
	/* Static methods used for return messages */
	public static JsonResponse Ok() {
		return new JsonResponse(successCode, successMessage, null, null);
	}
	public static JsonResponse readSuccess(Object data) {
		return new JsonResponse(successCode, successMessage, data, null);
	}
	public static JsonResponse readByPkFailure(String entityName, int id) {
		String msg = String.format("Pk %d of %s - Not found!", id, entityName);
		return new JsonResponse(pkNotFoundCode, msg, null, null);
	}
	public static JsonResponse maintAddChangeSuccess(Object entityInstance) {
		String msg = String.format("%s Added/Changed!", entityInstance.getClass().getSimpleName());
		return new JsonResponse(successCode, msg, entityInstance, null);
	}
	public static JsonResponse maintDeleteSuccess(Object entityInstance) {
		String msg = String.format("%s Deleted!", entityInstance.getClass().getSimpleName());
		return new JsonResponse(successCode, msg, entityInstance, null);
	}
	public static JsonResponse dataIntegrityViolationError(DataIntegrityViolationException ex) {
		String msg = String.format("Data Integrity Error; Root cause: %s", ex.getRootCause().toString());
		return new JsonResponse(dataIntegrityViolationCode, msg, null, ex);
	}
	public static JsonResponse generalExceptionError(Exception ex) {
		String msg = String.format("Exception: %s", ex.getMessage());
		return new JsonResponse(generalExceptionCode, msg, null, ex);
	}
		
	public JsonResponse(int code, String message, Object data, Object error) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.error = error;
	}

}
