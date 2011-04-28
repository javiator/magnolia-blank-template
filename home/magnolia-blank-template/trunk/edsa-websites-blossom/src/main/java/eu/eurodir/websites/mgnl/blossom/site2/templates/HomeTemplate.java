package eu.eurodir.websites.mgnl.blossom.site2.templates;

import info.magnolia.module.blossom.annotation.DialogFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.dialog.DialogBuilder;
import info.magnolia.module.blossom.dialog.TabBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * @author amit.gautam@firstclarity.com
 */
@Controller
@Template("Site2-Home")
public class HomeTemplate {

    @RequestMapping("/site2/home")
    public String render(ModelMap model) {
        return "/site2/home.jsp";
    }

    @DialogFactory("main-properties")
    public void propertiesDialog(DialogBuilder builder) {
        TabBuilder settings = builder.addTab("Content");
        settings.addEdit("title", "Title", "");
    }
    
}
