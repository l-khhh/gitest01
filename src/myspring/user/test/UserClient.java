//전체적으로 값을 밀어넣을 단위테스트를 위해 만든  클래스

package myspring.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/ds/beans.xml")
public class UserClient {
	@Autowired
	ApplicationContext context;
	@Autowired
	UserService service;
	
	@Test
	// @Ignore
	public void serviceTest() {
		UserService service = context.getBean(UserService.class);

		System.out.println("------레코드 삭제--------");
		service.deleteUser("4");
		service.deleteUser("5");
		service.deleteUser("6");

		System.out.println("------레코드 생성--------");
		service.insertUser(new UserVO("4", "수정전", "남", "차장", "모바일팀", "300"));
		service.insertUser(new UserVO("5", "수정전", "여", "차장", "모바일팀", "300"));
		service.insertUser(new UserVO("6", "수정전", "남", "차장", "모바일팀", "300"));


		System.out.println("---- 레코드 갱신 -----");
		service.updateUser(new UserVO("5", "수정후", "남", "부장", "웹팀", "500"));
		service.updateUser(new UserVO("6", "수정후", "남", "부장", "CS팀", "500"));
		

	}
	
}
