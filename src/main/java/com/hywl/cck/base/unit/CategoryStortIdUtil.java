package com.hywl.cck.base.unit;

import com.hywl.cck.base.unit.ehcache.EhCacheUtils;

public class CategoryStortIdUtil {
	
	 public static final String CACHE_SECONDSTORTID = "secondCategoryId";// uploadConfig缓存二级分类对象名


	    public static boolean putEcache(String cacheString,String secondCategory,String stortId){
	        EhCacheUtils.putInCache(cacheString,secondCategory, stortId);
	        return false;
	    }
	    
	    public static String getCode(String secondCategory){

	        String code = (String) EhCacheUtils.getFromCache(secondCategory,secondCategory);
	        if(code==null||code.equals("")){
	            return null;
	        }
	        return code;
	    }
	    
	    public static void delCode(String phoneNum){
	        EhCacheUtils.delInCache(CACHE_SECONDSTORTID,phoneNum);
	    }

}
