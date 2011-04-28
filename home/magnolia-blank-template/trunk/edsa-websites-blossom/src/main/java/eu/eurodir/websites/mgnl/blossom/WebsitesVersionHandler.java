package eu.eurodir.websites.mgnl.blossom;

import info.magnolia.module.DefaultModuleVersionHandler;
import info.magnolia.module.InstallContext;
import info.magnolia.module.delta.ModuleFilesExtraction;
import info.magnolia.module.delta.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * VersionHandler for the module.
 * 
 * @author amit.gautam@firstclarity.com
 */
public class WebsitesVersionHandler extends DefaultModuleVersionHandler  {
	
    public WebsitesVersionHandler() {
        /*
    	final Delta updateDelta = DeltaBuilder.update("1.1.5-SNAPSHOT", "This delta will be applied if your module is asked to be updated to version 1.1.5-SNAPSHOT")
            .addTask(new BootstrapSingleResource(
                    "Install section page",
                    "",
                    "/mgnl-bootstrap/blossomSample/website.checkout.xml"));
        
        register(updateDelta);
        */
    }
    
	
    /**
     * Forces extraction of the module's files, like template JSPs, from
     * <code>classes/mgnl-files</code> into the web application's root. This
     * does not yield a "Magnolia needs to be updated" screen. To avoid
     * destroying changes, Magnolia will not override files which have been
     * modified in the web application.
     * 
     * (In Magnolia, see also Tools, Development tools, to reload at request.)
     */
    @Override
    protected List<Task> getStartupTasks(InstallContext installContext) {
        final List<Task> tasks = new ArrayList<Task>();
        if ("SNAPSHOT".equalsIgnoreCase(installContext
                .getCurrentModuleDefinition().getVersion().getClassifier())) {

            log.warn("Starting SNAPSHOT release; forcing reload of module files.");
            tasks.add(new ModuleFilesExtraction());

        }
        return tasks;
    }

	
    @Override
    protected List<Task> getExtraInstallTasks(InstallContext installContext) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        
        /*
        tasks.add(new BootstrapSingleResource(
                "Install Comments Data Node",
                "",
                "/mgnl-bootstrap/naturalMedBlossom/config.modules.data.config.types.Comments.xml"));

         */
        return tasks;
    }

    
}
