//스케줄링을 위한 메소드로 bean에 설정해준 10초단위로 backup을 실행한다.

package myspring.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import myspring.user.vo.JobUserVO;

@Component("scheduling")
public class UserBackup {
	private JdbcTemplate mysql_jdbcTemplate;
	private JdbcTemplate oracle_jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource oracle_dataSource, DataSource mysql_dataSource) {
		this.oracle_jdbcTemplate = new JdbcTemplate(oracle_dataSource);
		this.mysql_jdbcTemplate = new JdbcTemplate(mysql_dataSource);
	}

	public void backup() {

		class BackupUserMapper implements RowMapper<JobUserVO> {
			public JobUserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				JobUserVO user = new JobUserVO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setPosition(rs.getString("position"));
				user.setDept(rs.getString("dept"));
				user.setSal(rs.getString("sal"));
				user.setState(rs.getString("state"));
				return user;
			}
		}

		String SQL = " select * from job_employee order by seq"; // insert
		List<JobUserVO> list = oracle_jdbcTemplate.query(SQL, new BackupUserMapper());

		for (JobUserVO jobUserVO : list) {
			int type = Integer.parseInt(jobUserVO.getState());

			if (type == 1) {// insert

				String MYSQL = "insert into employee (id, name, sex, position, dept, sal) values( ?, ?, ?, ?, ?, ?)";
				mysql_jdbcTemplate.update(MYSQL, jobUserVO.getId(), jobUserVO.getName(), jobUserVO.getSex(),
						jobUserVO.getPosition(), jobUserVO.getDept(), jobUserVO.getSal());
				System.out.println("insert backup :" + jobUserVO.getId());

			} else if (type == 2) { // delete

				String MYSQL = "delete from employee where id=?";
				mysql_jdbcTemplate.update(MYSQL, jobUserVO.getId());
				System.out.println("delete backup :" + jobUserVO.getId());

			} else {// update

				String MYSQL = "update employee  set name = ?, sex = ?, position = ?, dept = ?, sal = ? where id = ?";
				mysql_jdbcTemplate.update(MYSQL, jobUserVO.getName(), jobUserVO.getSex(), jobUserVO.getPosition(),
						jobUserVO.getDept(), jobUserVO.getSal(), jobUserVO.getId());
				System.out.println("update backup :" + jobUserVO.getId());

			}
		}
		oracle_jdbcTemplate.update("delete from job_employee");
		System.out.println("10초마다 backup 실행중");
	}
}
