package com.mpango.api;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class LMSApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet();

    public LMSApplication() {
        singletons.add(new LMSServiceImpl());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return this.empty;
    }

}
