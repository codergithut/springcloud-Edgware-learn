package tianjian.jax;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * 如果放开会将http服务失效
 */
//@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(Endpoint.class);
    }

}