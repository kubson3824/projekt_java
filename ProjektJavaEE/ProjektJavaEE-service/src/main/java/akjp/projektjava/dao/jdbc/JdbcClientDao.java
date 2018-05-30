/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package akjp.projektjava.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import akjp.projektjava.dao.ClientDao;
import akjp.projektjava.exception.DataAccessException;
import akjp.projektjava.model.Client;
import akjp.projektjava.util.ConnectionFactory;

public class JdbcClientDao implements ClientDao {

    @Override
    public void save(Client t) {
        final String SQL = "insert into app.client values (DEFAULT,?,?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection()) {
            try (PreparedStatement statement = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, t.getFirstName());
                statement.setString(2, t.getLastName());
                statement.setString(3, t.getPesel());
                statement.setString(4, t.getEmail());
                statement.executeUpdate();
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        t.setId(rs.getInt(1));
                    }
                } catch (SQLException ex) {
                    throw new DataAccessException(ex);
                }
            } catch (SQLException ex) {
                throw new DataAccessException(ex);
            }
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }
    
    @Override
    public void update(Client t) {
        final String SQL = "update app.client set firstName=?, lastName=?, pesel=?, email=? where id=?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            try (PreparedStatement statement = conn.prepareStatement(SQL)) {
                statement.setString(1, t.getFirstName());
                statement.setString(2, t.getLastName());
                statement.setString(3, t.getPesel());
                statement.setString(4, t.getEmail());
                statement.setInt(5, t.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new DataAccessException(ex);
            }
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }

    @Override
    public void delete(Client t) {
        final String SQL = "delete from app.client where id=?";
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setInt(1, t.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }

    @Override
    public Client findById(Integer id) {
        final String SQL = "select * from app.client where id = ?";
        Client result = null;
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    result = new Client();
                    result.setId(rs.getInt("id"));
                    result.setFirstName(rs.getString("firstName"));
                    result.setLastName(rs.getString("lastName"));
                    result.setPesel(rs.getString("pesel"));
                    result.setEmail(rs.getString("email"));
                }
            } catch (SQLException ex) {
                throw new DataAccessException(ex);
            }
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
        return result;
    }

    @Override
    public List<Client> findAll() {
        final String SQL = "select * from app.customer";
        List<Client> list = new LinkedList<>();
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Client c = new Client();
                c.setId(rs.getInt("id"));
                c.setFirstName(rs.getString("firstName"));
                c.setLastName(rs.getString("lastName"));
                c.setEmail(rs.getString("email"));
                list.add(c);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

}
