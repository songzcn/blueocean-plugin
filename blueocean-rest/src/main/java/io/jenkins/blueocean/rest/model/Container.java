package io.jenkins.blueocean.rest.model;

import com.google.common.collect.Iterables;
import io.jenkins.blueocean.commons.stapler.TreeResponse;
import io.jenkins.blueocean.rest.pageable.Pageable;
import io.jenkins.blueocean.rest.pageable.Pageables;
import org.kohsuke.stapler.WebMethod;
import org.kohsuke.stapler.verb.GET;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Stapler-bound REST endpoint for a collection of objects.
 *
 * @author Kohsuke Kawaguchi
 */
//TODO: extending AbstractCollection is workaround and should be removed once Stapler starts serializing Iterable
public abstract class Container<T> extends AbstractCollection<T> implements Pageable<T> {
    /**
     * Gets the individual member by its name
     *
     * @param name identifying the member
     *
     * @return individual member
     */
    public abstract T get(String name);

    // public abstract T create(..)

    // for stapler
    public final T getDynamic(String name) {
        return get(name);
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * Base implementation of pagination that is dumb.
     */
    @Override
    public Iterator<T> iterator(int start, int limit) {
        return Pageables.slice(iterator(),start,limit);
    }

    /**
     * When GET is requested on '/', serve the collection
     * @return collection in this container
     */
    @WebMethod(name="") @GET @TreeResponse
    // if we wanted collection listing to take filtering parameters, we can do that with one additional parameter
    public Object[] list(/*@QueryParameter Query q*/) {
        // TODO: pagenation
        return Iterables.toArray(this,Object.class);
    }
}
