package com.woorea.openstack.heat;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.heat.model.Metadata;
import com.woorea.openstack.heat.model.Resource;
import com.woorea.openstack.heat.model.Resources;


/**
 * v1/​{tenant_id}​/stacks/​{stack_name}​/resources
 */
public class ResourcesResource {
    private final OpenStackClient client;

    public ResourcesResource(OpenStackClient client) {
        this.client = client;
    }

    public ListResources listResources(String name) {
        return new ListResources(name);
    }

    public getResources getResources(String stackName, String stackId, String resourceId) {
        return new getResources(stackName, stackId, resourceId);
    }

    public ListResourcesWithMetaData listResourcesMetadata(String name,String id,String resourceName) {
        return new ListResourcesWithMetaData(name,id,resourceName);
    }

    /**
     * v1/​{tenant_id}​/stacks/​{stack_name}​/resources
     */
    public class ListResources extends OpenStackRequest<Resources> {
        public ListResources(String name) {
            super(client, HttpMethod.GET, "/stacks/" + name + "/resources", null, Resources.class);
        }
    }

    public class ListResourcesWithMetaData extends OpenStackRequest<Metadata> {
        public ListResourcesWithMetaData(String name,String id,String resourceName) {
            super(client, HttpMethod.GET, "/stacks/" +name+"/"+ id + "/resources/"+ resourceName+"/metadata",null, Metadata.class);
        }
    }

    public class getResources extends OpenStackRequest<Resource> {
        public getResources(String stackName, String stackId, String resourceName) {
            super(client, HttpMethod.GET, "/stacks/" + stackName +"/"+stackId+"/"+"resources/"+resourceName, null, Resource.class);
        }
    }
}
