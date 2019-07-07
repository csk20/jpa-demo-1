package com.example.cache.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.gemfire.mapping.annotation.Region;

import com.example.cache.profile.AppCache;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Region
public class GemfireCacheStore implements GemfireStore {
	
	
	public  Map<String,AppCache> map;

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
