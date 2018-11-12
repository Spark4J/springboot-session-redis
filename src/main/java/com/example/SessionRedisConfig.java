package com.example;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

// maxInactiveIntervalInSeconds 默认是1800秒过期，这里测试修改为60秒
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
public class SessionRedisConfig {

//	@Bean("redisSentinelConfiguration")
//	public RedisSentinelConfiguration redisSentinelConfiguration() {
//		return new RedisSentinelConfiguration();
//	}
//
//	@Bean
//	public JedisConnectionFactory connectionFactory(
//			@Qualifier("redisSentinelConfiguration") RedisSentinelConfiguration redisSentinelConfiguration)
//			 {
//		return new JedisConnectionFactory(redisSentinelConfiguration);
//	}

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
//    {
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        RedisObjectSerializer redisObjectSerializer = new RedisObjectSerializer();
//
//        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(redisConnectionFactory);
//        template.setKeySerializer(stringRedisSerializer);
//        template.setValueSerializer(redisObjectSerializer);
//        return template;
//    }
}
