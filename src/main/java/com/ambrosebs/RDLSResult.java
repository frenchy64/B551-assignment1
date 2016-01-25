package com.ambrosebs;

/**
 * Created by ambrose on 1/25/16.
 */
public final class RDLSResult {
    /**
     * null if no result. If cutoffOccurred is also null,
     * the space was exhausted, and there is a failure.
     */
    public final Result r;
    /**
     * if cutoff reached, this is non-null.
     */
    public final Integer cutoffOccurred;

    public RDLSResult(Result r, Integer cutoffOccurred) {
        this.r = r;
        this.cutoffOccurred = cutoffOccurred;
    }
}
