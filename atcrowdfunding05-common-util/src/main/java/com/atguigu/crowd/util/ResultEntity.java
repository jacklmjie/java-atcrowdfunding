package com.atguigu.crowd.util;

/**
 * ͳһ������Ŀ��Ajax���󷵻صĽ����δ��Ҳ�������ڷֲ�ʽ�ܹ�����ģ������ʱ����ͳһ���ͣ�
 * 
 * @author Lenovo
 *
 * @param <T>
 */
public class ResultEntity<T> {

	public static final String SUCCESS = "SUCCESS";
	public static final String FAILED = "FAILED";

	// ������װ��ǰ������Ľ���ǳɹ�����ʧ��
	private String result;

	// ������ʧ��ʱ���صĴ�����Ϣ
	private String message;

	// Ҫ���ص�����
	private T data;

	/**
	 * ������ɹ��Ҳ���Ҫ��������ʱʹ�õĹ��߷���
	 * 
	 * @return
	 */
	public static <Type> ResultEntity<Type> successWithoutData() {
		return new ResultEntity<Type>(SUCCESS, null, null);
	}

	/**
	 * ������ɹ�����Ҫ��������ʱʹ�õĹ��߷���
	 * 
	 * @param data Ҫ���ص�����
	 * @return
	 */
	public static <Type> ResultEntity<Type> successWithData(Type data) {
		return new ResultEntity<Type>(SUCCESS, null, data);
	}

	/**
	 * ������ʧ�ܺ�ʹ�õĹ��߷���
	 * 
	 * @param message ʧ�ܵĴ�����Ϣ
	 * @return
	 */
	public static <Type> ResultEntity<Type> failed(String message) {
		return new ResultEntity<Type>(FAILED, message, null);
	}

	public ResultEntity() {

	}

	public ResultEntity(String result, String message, T data) {
		super();
		this.result = result;
		this.message = message;
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultEntity [result=" + result + ", message=" + message + ", data=" + data + "]";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}