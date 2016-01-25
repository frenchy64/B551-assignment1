package com.ambrosebs;

import java.util.List;

/**
 * Created by ambrose on 1/24/16.
 */
public final class Result {
    public final List<String> path;
    public final Integer cost;

    public Result(List<String> path, Integer cost) {
        this.path = path;
        this.cost = cost;
    }

    public String toString() {
        return path.toString() + ", " + cost.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.path != null ? this.path.hashCode() : 0);
        hash = 53 * hash + this.cost;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Result other = (Result) obj;
        if ((this.path == null) ? (other.path != null) : !this.path.equals(other.path)) {
            return false;
        }
        if (!this.cost.equals(other.cost)) {
            return false;
        }
        return true;
    }

}
