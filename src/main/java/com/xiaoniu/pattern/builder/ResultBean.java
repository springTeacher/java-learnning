package com.xiaoniu.pattern.builder;

import java.io.Serializable;

/**
 * @author lihoujing
 * @date 2019/9/16 9:49
 */
public class ResultBean implements Serializable {

    private static final long serialVersionUID = -3875682513253480947L;

    private String code = "200";

    private String message = "成功";

    private Object data;


    private ResultBean(){

    }


    public static ResultBean format(){
        return new ResultBean();
    }


    public static ResultBean format(String code, String message){
        return new Builder().code(code).message(message).build();
    }


    public static ResultBean format(Object data){
        return new ResultBean();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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


    private static class Builder{

        private ResultBean resultBean;

        public Builder(){
            this.resultBean = new ResultBean();
        }


        private Builder code(String code){
            this.resultBean.setCode(code);
            return this;
        }

        private Builder message(String message){
            this.resultBean.setMessage(message);
            return this;
        }

        private Builder data(Object data){
            this.resultBean.setData(data);
            return this;
        }

        public ResultBean build(){
            return resultBean;
        }
    }




    @Override
    public String toString() {
        return "ResultBean{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
