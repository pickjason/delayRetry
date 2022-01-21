package com.wzz.delayretry.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-21 15:05
 */
public class DelayRetryThreadFactory implements ThreadFactory {


    protected static final AtomicInteger POOL_SEQ = new AtomicInteger(1);

    protected final AtomicInteger threadNum = new AtomicInteger(1);

    protected final String prefix;

    protected final boolean daemon;

    protected final ThreadGroup group;

    public DelayRetryThreadFactory() {
        this("pool-" + POOL_SEQ.getAndIncrement(), false);
    }

    public DelayRetryThreadFactory(String prefix) {
        this(prefix, false);
    }

    public DelayRetryThreadFactory(String prefix, boolean daemon) {
        this.prefix = prefix + "-thread-";
        this.daemon = daemon;
        SecurityManager s = System.getSecurityManager();
       this.group = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        String name = prefix + threadNum.getAndIncrement();
        Thread ret = new Thread(group, runnable, name, 0);
        ret.setDaemon(daemon);
        return ret;
    }

    public ThreadGroup getThreadGroup() {
        return group;
    }

}
