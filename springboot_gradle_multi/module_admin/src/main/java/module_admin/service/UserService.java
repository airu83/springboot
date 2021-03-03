package module_admin.service;


import org.springframework.stereotype.Service;

import com.example.module_core.User;

import module_admin.mapper.UserMapper;

@Service
public class UserService {
	
	private UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public User getData() {
		User result = new User();
//		result = userMapper.getData();
		System.out.println(">>>test: " + userMapper.getCount());
		return result;
	}
}
