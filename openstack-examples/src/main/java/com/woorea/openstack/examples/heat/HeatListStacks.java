package com.woorea.openstack.examples.heat;

import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.heat.Heat;
import com.woorea.openstack.heat.model.CreateStackParam;
import com.woorea.openstack.heat.model.Stack;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.utils.KeystoneTokenProvider;
import com.woorea.openstack.keystone.utils.KeystoneUtils;

import java.util.Collections;

public class HeatListStacks {

    private static String TEMPLATE = "heat_template_version: 2013-05-23\n" +
            "\n" +
            "description: >\n" +
            "  HOT template to deploy two servers into an existing neutron tenant network and\n" +
            "  assign floating IP addresses to each server so they are routable from the\n" +
            "  public network.\n" +
            "\n" +
            "resources:\n" +
            "  server1:\n" +
            "    type: OS::Nova::Server\n" +
            "    properties:\n" +
            "      name: Server1\n" +
            "      image: GOLDIMAGE\n" +
            "      flavor: Dual\n" +
            "\n" +
            "outputs:\n" +
            "  server1_private_ip:\n" +
            "    description: IP address of server1 in private network\n";

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        KeystoneTokenProvider keystone = new KeystoneTokenProvider(
                ExamplesConfiguration.KEYSTONE_ENDPOINT,
                ExamplesConfiguration.KEYSTONE_USERNAME,
                ExamplesConfiguration.KEYSTONE_PASSWORD
        );

        Access access = keystone.getAccessByTenant(ExamplesConfiguration.TENANT_NAME);

        String endpointURL = KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "orchestration", null, "public");


        Heat heat = new Heat(endpointURL);
        heat.setTokenProvider(keystone
                .getProviderByTenant(ExamplesConfiguration.TENANT_NAME));

        CreateStackParam param = new CreateStackParam();
        param.setStackName("helloWorld");
        param.setTimeoutMinutes(1);
        param.setParameters(Collections.<String, String>emptyMap());
        param.setTemplate(TEMPLATE);

        System.out.printf("Create: " + heat.getStacks().create(param).execute());
        Thread.sleep(3000);

        for (Stack s : heat.getStacks().list().execute()) {
            System.out.println(s.getDescription());
            System.out.println(s.getId());
            System.out.println(s.getStackName());
            System.out.println(s.getStackStatus());
            System.out.println(s.getCreationTime());
            System.out.println(s.getUpdatedTime());
            System.out.println(s.getLinks());

            System.out.println(heat.getStacks().byName(s.getStackName()).execute());


        }
    }
}
