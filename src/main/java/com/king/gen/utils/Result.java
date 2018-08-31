package com.king.gen.utils;

import com.king.gen.common.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 类Result的功能描述:
 * 返回数据实体类
 *
 * @auther king
 * @date 2017-04-28 11:57:50
 */
public class Result extends HashMap<String, Object> {
    public static final String REQUEST_ID = "requestId";

	private static final long serialVersionUID = 1L;
	
	public Result() {
		put("code", "0");
        put(REQUEST_ID, Utils.uuid());
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
	}

	public Result(String code,String msg) {
		put("code", code);
		put("msg", msg);
        put(REQUEST_ID, Utils.uuid());
	}
	
	public static Result error() {
		return new Result(Constant.RESULT.CODE_NO.getValue(),Constant.RESULT.MSG_NO.getValue());
	}
	
	public static Result error(String msg) {
		return error(Constant.RESULT.CODE_NO.getValue(), msg);
	}
	
	public static Result error(String code, String msg) {
		Result r = new Result();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static Result ok(String msg) {
		Result r = new Result();
		r.put("msg", msg);
		return r;
	}
	
	public static Result ok(Map<String, Object> map) {
		Result r = new Result();
		r.putAll(map);
		return r;
	}
	
	public static Result ok() {
		return new Result(Constant.RESULT.CODE_YES.getValue(),Constant.RESULT.MSG_YES.getValue());
	}
}
