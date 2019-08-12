//DataAccessObject.
//데이터 액세스 계층
//실제 동작할 함수들을 인터페이스로 정의

package myspring.user.dao;

import java.util.List;

import myspring.user.vo.UserVO;

public interface UserDao {
	public void insert(UserVO user);

	public List<UserVO> readAll();

	public void update(UserVO user);

	public void delete(String id);

	public UserVO read(String id);
	

}
