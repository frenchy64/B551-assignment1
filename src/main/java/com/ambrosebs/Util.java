package com.ambrosebs;

// from https://github.com/square/okio/blob/c200cb65ddf37fc4d11c01205ae1dd1eaf5f1136/okio/src/main/java/okio/Util.java#L64
public final class Util {
  /**
   * Throws {@code t}, even if the declared throws clause doesn't permit it.
   * This is a terrible – but terribly convenient – hack that makes it easy to
   * catch and rethrow exceptions after cleanup. See Java Puzzlers #43.
   */
  public static void sneakyRethrow(Throwable t) {
    Util.<Error>sneakyThrow2(t);
  }

  @SuppressWarnings("unchecked")
  private static <T extends Throwable> void sneakyThrow2(Throwable t) throws T {
    throw (T) t;
  }
}
