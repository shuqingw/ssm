package com.august.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.august.cache.RedisCache;
import com.august.dao.UserMapper;
import com.august.entity.User;
import com.august.enums.ResultEnum;
import com.august.exception.BizException;
import com.august.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserMapper userDao;
	@Resource
	private RedisCache redisCache;

	@Override
	public User getUserById(int userId) {
		String cache_key = RedisCache.CACHE_NAME + "|getUserById|" + userId;
		User result_cache = redisCache.getCache(cache_key, User.class);
		if (result_cache == null) {
			// 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			result_cache = userDao.selectByPrimaryKey(userId);
			redisCache.putCacheWithExpireTime(cache_key, result_cache, RedisCache.EXPIRETIME);
			logger.info("put cache with key:" + cache_key);
			return result_cache;
		} else {
			logger.info("get cache with key:" + cache_key);
		}
		return result_cache;
	}
	
	@Transactional
	@Override
	public void updateUser(User user){
		userDao.updateByPrimaryKey(user);
		//redisCache.putCache("testJedisTransactional", user);
		//尽量使用超时，避免出现脏数据无法清理
		redisCache.putCacheWithExpireTime("testJedisTransactional", user, RedisCache.EXPIRETIME);
		if(user.getAge() > 100){//回滚，update和cache都会回滚
			throw new BizException(ResultEnum.ROLLBACK_EXCEPTION.getMsg());
		}
	}
	
	@Override
	public void addUser(User user){
		userDao.insert(user);
	}
}
