package com.example.samplewebapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.jooq.impl.DSL.*;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.example.samplewebapp.domainmodel.Customer;

@Component
public class CustomerDaoImpl extends NamedParameterJdbcDaoSupport implements
		CustomerDao {

	DSLContext create = DSL.using(this.getDataSource(), SQLDialect.POSTGRES);

	@Override
	public int getCustomerCount() {
		String sql = create.selectCount().from(tableByName("customer"))
				.getSQL();
		return this.getNamedParameterJdbcTemplate().getJdbcOperations()
				.queryForInt(sql);
	}

	@Override
	public String getCustomerFirstName(int id) {
		Query query = create.select(fieldByName("first_name"))
				.from(tableByName("customer"))
				.where(fieldByName("id").equal(param("id", id)));
		String str = create.renderNamedParams(query);
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		return this.getNamedParameterJdbcTemplate().queryForObject(str, namedParameters, String.class);
	}

	@Override
	public Customer getCustomer(int id) {
		String sql = "SELECT * FROM CUSTOMER WHERE ID = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		return this.getNamedParameterJdbcTemplate().queryForObject(sql,
				namedParameters, new CustomerMapper());
	}

	@Override
	public List<Customer> getAllCustomers() {
		String sql = "SELECT * FROM CUSTOMER";
		return this.getNamedParameterJdbcTemplate().getJdbcOperations()
				.query(sql, new CustomerMapper());
	}

	@Override
	public void insertCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME) VALUES (:id, :firstName, :lastName)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",
				customer.getId())
				.addValue("firstName", customer.getFirstName()).addValue(
						"lastName", customer.getLastName());
		this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	@Override
	public void insertCustomerNamedParameters(Customer customer) {
		String sql = "INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME) VALUES (:id, :firstName, :lastName)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",
				customer.getId())
				.addValue("firstName", customer.getFirstName()).addValue(
						"lastName", customer.getLastName());
		this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	private static final class CustomerMapper implements RowMapper<Customer> {
		@Override
		public Customer mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			// rowNum can for example be used to count the rows returned
			Customer customer = new Customer();
			customer.setId(resultSet.getInt("ID"));
			customer.setFirstName(resultSet.getString("FIRST_NAME"));
			customer.setLastName(resultSet.getString("LAST_NAME"));
			return customer;
		}
	}
}
