//서비스 계층
//실제 동작할 함수들을 인터페이스로 정의

package myspring.user.service;

import java.util.List;

import myspring.user.vo.UserVO;

public interface UserService {
	
	//user 객체의 함수들 호출
	public void insertUser(UserVO user);

	public List<UserVO> getUserList();

	public void deleteUser(String id);

	public UserVO getUser(String id);

	public void updateUser(UserVO user);
	
}
