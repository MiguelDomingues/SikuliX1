package org.sikuli.ide;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

public class ScriptEndHooks {
    private static Queue<Consumer<Void>> hooks = new ConcurrentLinkedQueue<Consumer<Void>>();

    public static void add(Consumer<Void> c) {
        hooks.add(c);
    }

    public static void runAll() {
        while(!hooks.isEmpty()){
            Consumer<Void> r = hooks.poll();
            r.accept(null);
        }
    }
}