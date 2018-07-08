package com.bupt.miaoshao.response;

public class TResponse<T> {
    private int code;
    private String msg;
    private T data;

    @Override
    public String toString() {
        return "TResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static<T> TResponse<T> successTResponse(T data) {
        return new TResponse<T>(CodeMsg.successCode(), data);

    }


    public static TResponse errorTResponse(CodeMsg codeMsg) {

        return new TResponse(codeMsg, null);

    }

    private TResponse(CodeMsg codeMsg, T data) {
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
