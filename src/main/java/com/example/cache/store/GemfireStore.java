package com.example.cache.store;

import com.example.cache.profile.AppCache;

public interface GemfireStore {
	
	public AppCache	fetch(String cacheId );
	
 public void put(AppCache appCache);

}
