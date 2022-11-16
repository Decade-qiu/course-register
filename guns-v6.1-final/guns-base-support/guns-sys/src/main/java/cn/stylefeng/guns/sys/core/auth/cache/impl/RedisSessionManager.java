package cn.stylefeng.guns.sys.core.auth.cache.impl;

import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.sys.core.auth.cache.SessionManager;

/**
 * 基于redis的会话管理
 *
 * @author fengshuonan
 * @date 2019-09-28-14:43
 */
public class RedisSessionManager implements SessionManager {

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void createSession(String token, LoginUser loginUser) {
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        redisTemplate.opsForValue().set(SESSION_PREFIX + token, loginUser, 24, TimeUnit.HOURS);
    }

    @Override
    public LoginUser getSession(String token) {
        return null;
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        return (LoginUser) redisTemplate.opsForValue().get(SESSION_PREFIX + token);
    }

    @Override
    public void removeSession(String token) {
//        redisTemplate.delete(SESSION_PREFIX + token);
    }

    @Override
    public boolean haveSession(String token) {
        return false;
//        Boolean flag = redisTemplate.hasKey(SESSION_PREFIX + token);
//        if (flag == null) {
//            return false;
//        } else {
//            return redisTemplate.hasKey(SESSION_PREFIX + token);
//        }
    }

}
