package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/session-redis")
public class SessionRedisTestController {
	@Autowired
	private StringRedisTemplate redisTemplate;

	private String attrbuteName = "username";

	@RequestMapping("/getLoginMsg")
	@ResponseBody
	public String getLoginMsg(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute(attrbuteName);
		return "getLoginMsg <hr> 端口=" + request.getLocalPort() + " sessionId=" + request.getSession().getId()
				+ "<br/>获取用户名  " + username;
	}

	@RequestMapping("/getMsgWithRedisTemplate")
	@ResponseBody
	public String getMsgWithRedisTemplate(HttpServletRequest request) {
		//		String username = (String) request.getSession().getAttribute("username");
		String key = "spring:session:sessions:" + request.getSession().getId();
		String field = "sessionAttr:" + attrbuteName;
		String originUsername = (String) redisTemplate.opsForHash().get(key, field);
		String username = originUsername.substring(25);//前面有 \xac\xed\x00\x05t\x00\x04 会变成乱码 要使用序列化和反序列类RedisSerializer 截取ng
		return "getMsgWithRedisTemplate <hr> 端口=" + request.getLocalPort() + " sessionId="
				+ request.getSession().getId() + "<br/>获取用户名  " + username;
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request, @RequestParam(required = true) String username) {
		request.getSession().setAttribute(attrbuteName, username);
		return "端口=" + request.getLocalPort() + " sessionId=" + request.getSession().getId() + "<br/>保存用户名  "
				+ username;
	}
}
