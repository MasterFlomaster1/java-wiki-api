package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.util.WikiApiUrl;
import lombok.Getter;

/**
 * Properties are data about a page, such as categories, or content on a page, such as images or links.
 * To request a property, you pass the prop parameter of your query a valid property submodule, corresponding
 * to the information that you need.
 * The page or pages whose data you are requesting are specified either by the {@code titles}, {@code pageids}, or
 * {@code revids} parameters of the query, or via a generator.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Properties">API:Properties</a>
 */
@Getter
public abstract class AbstractProp {

    private final String name;
    protected final WikiApiUrl apiUrl = new WikiApiUrl();

    AbstractProp(final String name) {
        this.name = name;
    }

}
