//��ü������ ���� �о���� �����׽�Ʈ�� ���� ����  Ŭ����

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

		System.out.println("------���ڵ� ����--------");
		service.deleteUser("4");
		service.deleteUser("5");
		service.deleteUser("6");

		System.out.println("------���ڵ� ����--------");
		service.insertUser(new UserVO("4", "������", "��", "����", "�������", "300"));
		service.insertUser(new UserVO("5", "������", "��", "����", "�������", "300"));
		service.insertUser(new UserVO("6", "������", "��", "����", "�������", "300"));


		System.out.println("---- ���ڵ� ���� -----");
		service.updateUser(new UserVO("5", "������", "��", "����", "����", "500"));
		service.updateUser(new UserVO("6", "������", "��", "����", "CS��", "500"));
		

	}
	
}
