package org.wso2.custom.event.output.adapter.email.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.wso2.carbon.event.output.adapter.core.OutputEventAdapterFactory;
import org.wso2.custom.event.output.adapter.email.CustomEmailAdapterFactory;

/**
 * @scr.component component.name="custom.output.Email.AdapterService.component" immediate="true"
 */
@Component(
        name = "custom.output.email.adapter.service.component",
        immediate = true
)
public class CustomEmailEventAdapterServiceDS {

    private static final Log log = LogFactory.getLog(CustomEmailEventAdapterServiceDS.class);

    @Activate
    protected void activate(ComponentContext context) {

        try {
            CustomEmailAdapterFactory emailEventAdaptorFactory = new CustomEmailAdapterFactory();
            context.getBundleContext().registerService(OutputEventAdapterFactory.class.getName(),
                    emailEventAdaptorFactory, null);
            if (log.isDebugEnabled()) {
                log.debug("Successfully deployed the output Email event adaptor service");
            }
        } catch (RuntimeException e) {
            log.error("Can not create the output Email event adaptor service ", e);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {

        if (log.isDebugEnabled()) {
            log.debug("Custom CustomEmailEventAdapterServiceDS Component is deactivated.");
        }
    }

}
