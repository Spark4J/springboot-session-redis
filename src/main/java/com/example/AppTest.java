package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppTest {
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Test
	public void test01() {
		String object = (String) redisTemplate.opsForValue().get("username");
		System.out.println(object);
	}
}
