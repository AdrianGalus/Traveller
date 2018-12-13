package traveller.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import traveller.filters.SessionFilter;
import javax.servlet.Filter;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        return null;
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[] {ApplicationConfig.class};
    }
    @Override
    protected String[] getServletMappings() {

        return new String[] {"/"};
    }
    @Override
    protected Filter[] getServletFilters() {

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        SessionFilter sessionFilter = new SessionFilter();
        return new Filter[] {characterEncodingFilter, sessionFilter};
    }
}
