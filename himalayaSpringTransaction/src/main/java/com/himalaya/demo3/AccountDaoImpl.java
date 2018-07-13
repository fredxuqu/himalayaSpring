package com.himalaya.demo3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午9:24:16
* Description
*/
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao{

	@Override
	public void add(String account, Double amount) {
		String sql = "update TB_ACCOUNT set amount = amount + ? where account = ?";
		this.getJdbcTemplate().update(sql, amount, account);
	}

	@Override
	public void deduct(String account, Double amount) {
		String sql = "update TB_ACCOUNT set amount = amount - ? where account = ?";
		this.getJdbcTemplate().update(sql, amount, account);
	}

	@Override
	public void addAccount(String account, Double amount) {
		String sql = "INSERT INTO TB_ACCOUNT(ACCOUNT, AMOUNT) VALUES (?,?)";
		this.getJdbcTemplate().update(sql, account, amount);
	}

	@Override
	public List<String> listAllAccount() {
		String sql = "SELECT * FROM TB_ACCOUNT";
		List<String> list = this.getJdbcTemplate().query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String accountName = rs.getString("account");
				return accountName;
			}
		});
		return list;
	}
}
