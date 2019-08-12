//실제 데이터 액세스 계층으로 @repository를 설정하여 db에 접근한다.
//UserDao 인터페이스의 메소드들을 실제구현하여 작성한다.

package myspring.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

@Repository("userDao")
public class UserDaoImplJDBC implements UserDao {
	private JdbcTemplate oracle_jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource oracle_dataSource, DataSource mysql_dataSource) {
			this.oracle_jdbcTemplate = new JdbcTemplate(oracle_dataSource);
	}
	
	
	class UserMapper implements RowMapper<UserVO> {
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setPosition(rs.getString("position"));
			user.setDept(rs.getString("dept"));
			user.setSal(rs.getString("sal"));
			return user;
		}
	}

	
	@Override
	public UserVO read(String id) {	
		String SQL = "select * from employee where id = ?";
		try {
			UserVO user = oracle_jdbcTemplate.queryForObject(SQL,
					new Object[] { id }, new UserMapper());
			return user;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}	
	public void insert(UserVO user) {
		String SQL = "insert into employee (id, name, sex, position, dept, sal) values (?, ?, ?, ?, ?, ?)";
		//String job_SQL = "insert into job_employee (seq, id, name, sex, position, dept, sal, state) values (seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

		oracle_jdbcTemplate.update(SQL, user.getId(), user.getName(), user.getSex(), user.getPosition(), user.getDept(), user.getSal());
		//oracle_jdbcTemplate.update(job_SQL,  user.getId(), user.getName(), user.getSex(), user.getPosition(), user.getDept(), user.getSal(),1);

		System.out.println("등록된 Record UserId=" + user.getId() + " Name=" + user.getName());
	}

	public List<UserVO> readAll() {
		String SQL = "select * from employee order by id"; 
		List<UserVO>  userList = oracle_jdbcTemplate.query(SQL, new UserMapper());
	
		
		return userList;
	}

	public void delete(String id) {
		String SQL = "delete from employee where id = ?";
		//String job_SQL = "insert into job_employee (seq, id, state) values (seq.nextval, ?, ?)";

		oracle_jdbcTemplate.update(SQL, id); 
		//oracle_jdbcTemplate.update(job_SQL, id, 2);

		System.out.println("삭제된 Record with ID = " + id ); 
		
	}

	public void update(UserVO user) {
		String SQL = "update employee  set name = ?, sex = ?, position = ?, dept = ?, sal = ? where id = ?"; 
		//String job_SQL = "insert into job_employee (seq, id, name, sex, position, dept, sal, state) values (seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

		oracle_jdbcTemplate.update(SQL, user.getName(), user.getSex(), user.getPosition(), user.getDept(), user.getSal(), user.getId()); 
		//oracle_jdbcTemplate.update(job_SQL, user.getId(), user.getName(), user.getSex(), user.getPosition(), user.getDept(), user.getSal(),3);
		
		System.out.println("갱신된 Record with ID = " + user.getId() ); 
		System.out.println("갱신된 Record with name = " + user.getName() ); 

	}
	

}
