package com.company.AnnaNicholsU1Capstone.dao;

import com.company.AnnaNicholsU1Capstone.dto.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {
    private static final String INSERT_INVOICE_SQL =
            "Insert into invoice(name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total) Values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SELECT_INVOICE_SQL =
            "Select * From invoice where invoice_id = ?";

    private static final String SELECT_ALL_INVOICES_SQL =
            "Select * From invoice";

    private static final String UPDATE_INVOICE_SQL =
            "update invoice set name = ?, street = ?, city = ?, state = ?, zipcode = ?, item_type = ?, item_id = ?, unit_price = ?, quantity = ?, subtotal = ?, tax = ?, processing_fee = ?, total = ?, invoice_id=?";

    private static final String DELETE_INVOICE_SQL =
            "delete from invoice where invoice_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Invoice addInvoice(Invoice invoice) {

        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        invoice.setId(id);

        return invoice;
    }

    @Override
    public Invoice getInvoice(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_INVOICE_SQL, this::mapRowToInvoice, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<Invoice> getAllInvoices() {

        return jdbcTemplate.query(SELECT_ALL_INVOICES_SQL, this::mapRowToInvoice);

    }

    @Override
    public void updateInvoice(Invoice invoice) {

        jdbcTemplate.update(UPDATE_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal(),
                invoice.getId());
    }

    @Override
    public void deleteInvoice(int id) {
        jdbcTemplate.update(DELETE_INVOICE_SQL, id);
    }

    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();

        invoice.setId(rs.getInt("invoice_id"));
        invoice.setName(rs.getString("name"));
        invoice.setStreet(rs.getString("street"));
        invoice.setCity(rs.getString("city"));
        invoice.setState(rs.getString("state"));
        invoice.setZipcode(rs.getString("zipcode"));
        invoice.setItemType(rs.getString("item_type"));
        invoice.setItemId(rs.getInt("item_id"));
        invoice.setUnitPrice(rs.getBigDecimal("unit_price"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setSubtotal(rs.getBigDecimal("subtotal"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setProcessingFee(rs.getBigDecimal("processing_fee"));
        invoice.setTotal(rs.getBigDecimal("total"));

        return invoice;
    }
}
