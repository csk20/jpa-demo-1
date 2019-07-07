package com.example.cache.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.cache.profile.AppCache;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HashMapStore implements GemfireStore {
	
	public static Map<String,AppCache> map= new  ConcurrentHashMap();

	@Override
	public AppCache fetch(String cacheId) {
		// TODO Auto-generated method stub
		return map.get(cacheId);
	}

	@Override
	public void put(AppCache appCache) {
		map.put(appCache.getCacheId(), appCache);

	}

}
