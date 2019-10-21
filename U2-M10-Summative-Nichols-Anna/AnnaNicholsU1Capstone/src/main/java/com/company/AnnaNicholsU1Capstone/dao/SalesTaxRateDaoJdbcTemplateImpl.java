package com.company.AnnaNicholsU1Capstone.dao;

import com.company.AnnaNicholsU1Capstone.dto.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class SalesTaxRateDaoJdbcTemplateImpl implements SalesTaxRateDao {
    private static final String INSERT_SALES_TAX_RATE_SQL =
            "Insert into sales_tax_rate(state, rate) Values (?,?)";

    private static final String SELECT_SALES_TAX_RATE_SQL =
            "Select * From sales_tax_rate where state = ?";

    private static final String SELECT_ALL_SALES_TAX_RATES_SQL =
            "Select * From sales_tax_rate";

    private static final String UPDATE_SALES_TAX_RATE_SQL =
            "update sales_tax_rate set state = ?, rate = ?";

    private static final String DELETE_SALES_TAX_RATE_SQL =
            "delete from sales_tax_rate where state=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesTaxRateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate) {

        jdbcTemplate.update(INSERT_SALES_TAX_RATE_SQL,
                salesTaxRate.getState(),
                salesTaxRate.getRate());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);


        return salesTaxRate;
    }

    @Override
    public SalesTaxRate getSalesTaxRate(String state) {

        try {
            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_SQL, this::mapRowToSalesTaxRate, state);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<SalesTaxRate> getAllSalesTaxRates() {

        return jdbcTemplate.query(SELECT_ALL_SALES_TAX_RATES_SQL, this::mapRowToSalesTaxRate);

    }

    @Override
    public void updateSalesTaxRate(SalesTaxRate salesTaxRate) {

        jdbcTemplate.update(UPDATE_SALES_TAX_RATE_SQL,
                salesTaxRate.getState(),
                salesTaxRate.getRate());
    }

    @Override
    public void deleteSalesTaxRate(String state) {
        jdbcTemplate.update(DELETE_SALES_TAX_RATE_SQL, state);
    }

    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();

        salesTaxRate.setState(rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate"));

        return salesTaxRate;
    }
}
