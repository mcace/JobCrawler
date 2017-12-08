package com.mcsoft.crawler;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 线程安全的待爬取连接队列
 * 过滤掉已经爬取过的连接
 * Created by Mc on 2017/12/7.
 */
public class CrawQueue {
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<String>(100);
    private static final ConcurrentSet<String> crawed = new ConcurrentSet<String>();

    private CrawQueue() {
    }

    public static String take() throws InterruptedException {
        String takeUrl;
        do {
            takeUrl = queue.take();
            //当Set中已有该url，则继续获取下一个要抓的url，使用ConcurrentHashMap来确保
            //crawed这个Set集的多线程安全
        } while (!crawed.add(takeUrl));
        return takeUrl;
    }

    public static void put(String url) throws InterruptedException {
        if (crawed.contains(url)) {
            return;
        }
        queue.put(url);
    }

    private static class ConcurrentSet<T> extends AbstractSet<T> implements Set<T> {
        private final ConcurrentHashMap<T, Object> crawed = new ConcurrentHashMap<T, Object>();
        private final Object E = new Object();

        public Iterator<T> iterator() {
            return crawed.keySet().iterator();
        }

        public int size() {
            return crawed.size();
        }

        @Override
        public boolean add(T o) {
            return crawed.put(o, E) == null;
        }

        @Override
        public boolean contains(Object o) {
            return crawed.containsKey(o);
        }
    }
}
