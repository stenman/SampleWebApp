package com.example.samplewebapp.dal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import static org.jooq.impl.DSL.*;
import org.jooq.DSLContext;
import org.jooq.Param;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.samplewebapp.domain.model.Customer;

@Repository
public class CustomerDaoImpl extends NamedParameterJdbcDaoSupport implements CustomerDao {

	private static final String jndiEnvironment = "java:comp/env";
	private static final String jndiResource = "jdbc/sample_webapp_datasource";

	// TODO: Use enums or constants for database tables and fields?
	// TODO: This DAO knows of above layer (model: TransactionType). Refactor to
	// generic objects?
	// TODO: Add and verify error handling
	// TODO: Add logging
	// TODO: Test!

	@PostConstruct
	private void initialize() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup(jndiEnvironment);
		DataSource dataSource = (DataSource) envCtx.lookup(jndiResource);
		setDataSource(dataSource);
	}

	DSLContext create = DSL.using(this.getDataSource(), SQLDialect.POSTGRES);

	@Override
	public int getCustomerCount() {
		String sql = create.selectCount().from(tableByName("customer")).getSQL();
		return this.getNamedParameterJdbcTemplate().getJdbcOperations().queryForInt(sql);
	}

	@Override
	public Customer getCustomer(int id) {
		Query query = create.select().from(tableByName("customer")).where(fieldByName("id").equal(param("id", id)));
		String sql = create.renderNamedParams(query);
		Param<?> paramId = query.getParam("id");
		SqlParameterSource namedParameters = new MapSqlParameterSource(paramId.getName(), id);
		return this.getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters, new CustomerMapper());
	}

	@Override
	public List<Customer> getAllCustomers() {
		Query query = create.select().from(tableByName("customer"));
		String sql = create.renderNamedParams(query);
		return this.getNamedParameterJdbcTemplate().getJdbcOperations().query(sql, new CustomerMapper());
	}

	@Override
	public void insertCustomer(Customer customer) {
		Query query = create.insertInto(tableByName("customer"), fieldByName("id"), fieldByName("first_name"),
				fieldByName("last_name")).values(param("id", customer.getId()),
				param("firstName", customer.getFirstName()), param("lastName", customer.getLastName()));
		String sql = create.renderNamedParams(query);
		Param<?> paramId = query.getParam("id");
		Param<?> paramFirstName = query.getParam("firstName");
		Param<?> paramLastName = query.getParam("lastName");
		SqlParameterSource namedParameters = new MapSqlParameterSource(paramId.getName(), customer.getId()).addValue(
				paramFirstName.getName(), customer.getFirstName()).addValue(paramLastName.getName(),
				customer.getLastName());
		this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	private static final class CustomerMapper implements RowMapper<Customer> {
		@Override
		public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			// rowNum can for example be used to count the rows returned
			Customer customer = new Customer();
			customer.setId(resultSet.getInt("ID"));
			customer.setFirstName(resultSet.getString("FIRST_NAME"));
			customer.setLastName(resultSet.getString("LAST_NAME"));
			return customer;
		}
	}
}
