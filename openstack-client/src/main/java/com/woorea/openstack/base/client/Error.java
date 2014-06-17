package com.woorea.openstack.base.client;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Created by iheralla on 5/26/14.
 */
@JsonRootName("error")
public  class Error {
    @JsonProperty("message")
    public String message;

    @JsonProperty("traceback")
    public String traceback;

    @JsonProperty("type")
    public String type;

    @JsonProperty("title")
    public String title;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTraceback() {
        return traceback;
    }

    public void setTraceback(String traceback) {
        this.traceback = traceback;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
