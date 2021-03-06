package com.kylin.jbosscache.api;

import org.jboss.cache.Cache;
import org.jboss.cache.CacheFactory;
import org.jboss.cache.CacheStatus;
import org.jboss.cache.DefaultCacheFactory;
import org.jboss.cache.Fqn;
import org.jboss.cache.Node;

public class MyListenerTest {
	
	public void test() {
		
		CacheFactory factory = new DefaultCacheFactory();
		Cache cache = factory.createCache(false);
		MyListener myListener = new MyListener();
		cache.addCacheListener(myListener);
		System.out.println(cache.getCacheStatus());
		cache.start();
		System.out.println(cache.getCacheStatus());
		
		if(cache.getCacheStatus().equals(CacheStatus.STARTED)) {
			System.out.println("Yes");
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("JBossCache Info: \n");
		sb.append("  JBossCache Version: " + cache.getVersion() + "\n");
		sb.append("  JBossCache Status: " + cache.getCacheStatus() + "\n");
		sb.append("  JBossCache ClusterName: " + cache.getConfiguration().getClusterName() + "\n");
		sb.append("  JBossCache CacheMode: " + cache.getConfiguration().getCacheMode());
		System.out.println(sb.toString());
		
//		Node root = cache.getRoot();
//		Fqn abcFqn = Fqn.fromString("/a/b/c");
//		Node node = root.addChild(abcFqn);
//		node.put("k1", "v1");
//		node.put("k2", "v2");
//		node.put("k3", "v3");
//		node.put("k4", "v4");
//		node.put("k5", "v5");
//		node.remove("k1");
//		node.remove("k2");
//		node.clearData();
		
//		abc.put("content", new Content("abc test"));
//		abc.get("content");
//		Node node = root.getChild(Fqn.fromString("/a/b"));
//		node.removeChild("c");
//		cache.stop();
//		cache.destroy();
	}

	public static void main(String[] args) {
		new MyListenerTest().test();
	}

}
