package com.example.backend.common.response;

import lombok.Getter;

@Getter
public class CommonResponse extends BasicResponse{
    private Object data;
    private int code;

    public void changeCode(int code){
        this.code = code;
    }

        public void setData(Object obj) {
        this.data = obj;
    }

        public CommonResponse() {
        this.code = 200;
    }
}
