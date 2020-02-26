package com.trelloiii.simplereapitinglib.web.httpcodes;

public class NotFound implements HttpCode{
    private final int CODE=404;
    private Object body;
    public NotFound(Object body) {
        this.body=body;
        System.out.println("page not found");//TODO make normal 404
    }

    @Override
    public int getCODE() {
        return CODE;
    }
    @Override
    public Object getBody() {
        return body;
    }
}
