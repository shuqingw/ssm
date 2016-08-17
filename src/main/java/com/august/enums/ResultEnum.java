package com.august.enums;

/**
 * 异常枚举类
 * @author tian
 */
public enum ResultEnum {

	TEST_EXCEPTION(1, "test_throw_excetion"),
	ROLLBACK_EXCEPTION(2, "rollback_exception");
	
	private int state;
	private String msg;
	
	ResultEnum(int state, String msg){
		this.state = state;
		this.msg = msg;
	}

	public int getState() {
		return state;
	}
	public String getMsg() {
		return msg;
	}

	//从ResultEnum.values()中遍历
	public static ResultEnum stateOf(int index) {
		for (ResultEnum result : values()) {
			if (result.getState() == index) {
				return result;
			}
		}
		return null;
	}
}
