package com.bupt.miaoshao.response;

public class CodeMsg {

    private String msg;
    private int code;


    public static CodeMsg successCode() {

        return new CodeMsg("success", 0);
    }
    public static CodeMsg SERVERERROR = new CodeMsg("server error", 500);
    public static CodeMsg INPUTEROOR = new CodeMsg("input invalid: %s", 400);
    public static CodeMsg LOGINROOR = new CodeMsg("account/password error", 400);


    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(message, code);
    }

    private CodeMsg(String msg, int code) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
