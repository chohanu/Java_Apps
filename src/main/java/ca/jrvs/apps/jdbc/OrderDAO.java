package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO extends DataAccessObject<Order> {
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order dto) {
        return null;
    }

    @Override
    public Order create(Order dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    protected int getLastVal(String sequence) {
        return super.getLastVal(sequence);
    }

    private final static String GET_BY_ID = "SELECT\n" +
            "  c.first_name, c.last_name, c.email, o.order_id,\n" +
            "  o.creation_date, o.total_due, o.status,\n" +
            "  s.first_name, s.last_name, s.email,\n" +
            "  ol.quantity,\n" +
            "  p.code, p.name, p.size, p.variety, p.price\n" +
            "from orders o\n" +
            "  join customer c on o.customer_id = c.customer_id\n" +
            "  join salesperson s on o.salesperson_id=s.salesperson_id\n" +
            "  join order_item ol on ol.order_id=o.order_id\n" +
            "  join product p on ol.product_id = p.product_id\n" +
            "where o.order_id = ?;";
    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Order findbyId(long id) {
        Order order = new Order();
        try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);) {
            statement.setLong(1, id);


            ResultSet r = statement.executeQuery();
            long orderId = 0;
            List<OrderLine> orderLines = new ArrayList<>();
            while (r.next()) {
                if (orderId == 0) {
                    order.setCustomerFirstname(r.getString(1));
                    order.setCustomerLastname(r.getString(2));
                    order.setCustomerEmail(r.getString(3));
                    order.setId(r.getLong(4));
                    orderId = order.getId();
                    order.setCreationDate(new Date(r.getDate(5).getTime()));
                    order.setTotalDue(r.getBigDecimal(6));
                    order.setStatus(r.getString(7));
                    order.setSalespersonFirstName(r.getString(8));
                    order.setSalespersonLastName(r.getString(9));
                    order.setSalespersonEmail(r.getString(10));

                }

                OrderLine orderLine = new OrderLine();
                orderLine.setQuantity(r.getInt(11));
                orderLine.setProductCode(r.getString(12));
                orderLine.setProductName(r.getString(13));
                orderLine.setProductSize(r.getInt(14));
                orderLine.setProductPrice(r.getBigDecimal(16));
                orderLine.setProductVariety(r.getString(15));
                orderLines.add(orderLine);

            }
            order.setOrderLine(orderLines);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return order; }
}

