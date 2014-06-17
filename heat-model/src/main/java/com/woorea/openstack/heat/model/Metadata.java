package com.woorea.openstack.heat.model;

import java.util.Map;

/**
 * Created by iheralla on 5/22/14.
 */
public class Metadata {

    private Map<String, Object> metadata;

    /**
     * @return the metadata
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * Set the metadata
     * @param metadata
     */
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }



}
