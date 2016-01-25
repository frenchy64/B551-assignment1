package com.ambrosebs;

import java.util.List;

/**
 * Created by ambrose on 1/22/16.
 */
public final class Node {
    /**
     * The name of the node.
     */
    public final String state;
    public final Integer path_cost;
    public final List<String> path;

    public Node(final String state, Integer path_cost, List<String> path) {
        this.state = state;
        this.path_cost = path_cost;
        this.path = path;
    }

    @Override
    public String toString() {
        return state.toString() + ", " + path_cost.toString() + ", " + path.toString();
    }
}
