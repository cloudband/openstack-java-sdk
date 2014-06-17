package com.woorea.openstack.base.client;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by iheralla on 5/26/14.
 */
public class Explanation {
    @JsonProperty("explanation")
    public String explanation;

    @JsonProperty("code")
    public int code;

    public Error error;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
