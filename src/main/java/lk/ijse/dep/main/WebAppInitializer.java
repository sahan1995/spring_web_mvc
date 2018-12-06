package lk.ijse.dep.main;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("Root");
        return new Class[]{WebRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("App");
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("/");
        return new String[]{"/"};
    }


}
