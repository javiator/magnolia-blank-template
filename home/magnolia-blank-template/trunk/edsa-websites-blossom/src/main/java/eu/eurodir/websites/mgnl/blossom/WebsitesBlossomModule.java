package eu.eurodir.websites.mgnl.blossom;

import info.magnolia.module.ModuleLifecycle;
import info.magnolia.module.ModuleLifecycleContext;
import info.magnolia.module.blossom.module.BlossomModuleSupport;

/**
 * Module class that starts and stops Spring when called by Magnolia.
 * 
 * @author amit.gautam@firstclarity.com
 */
public class WebsitesBlossomModule  extends BlossomModuleSupport implements ModuleLifecycle {

    public void start(ModuleLifecycleContext moduleLifecycleContext) {
        initRootWebApplicationContext("classpath:/applicationContext.xml");
        initBlossomDispatcherServlet("blossom", "classpath:/blossom-servlet.xml");
    }

    public void stop(ModuleLifecycleContext moduleLifecycleContext) {
        destroyDispatcherServlets();
        closeRootWebApplicationContext();
    }
    
}
