//package com.liwnily.activiti.seed.security;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class FavUserDetailService implements UserDetailsService {
//	private static final Logger logger = LogManager.getLogger(FavUserDetailService.class);
//	/**  * 根据用户名获取用户 - 用户的角色、权限等信息   */
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserDetails userDetails = null;
//		try {
//			String name = "admin";
//			String password = "admin";
//			Collection<GrantedAuthority> authList = getAuthorities();
//			userDetails = new User(username, password.toLowerCase(),true,true,true,true,authList);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return userDetails;
//	}
//	/**  * 获取用户的角色权限,为了降低实验的难度，这里去掉了根据用户名获取角色的步骤     * @param    * @return   */
//	private Collection<GrantedAuthority> getAuthorities(){
//		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
//		authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		return authList;
//	}
//}