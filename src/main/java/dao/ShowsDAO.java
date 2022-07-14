package dao;

import static dao.ConnectionSingleton.close;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Show;

public class ShowsDAO {

    private static final String SQL_CREATE = "INSERT INTO shows(band, capacity, price, direction, observation, event_date) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM shows";
    private static final String SQL_READ_BY_ID = "SELECT * FROM shows WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE shows SET band = ?, capacity = ?, price = ?, direction = ?, observation = ?, event_date = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM shows WHERE id = ?";

    private Connection connection = null;

    public ShowsDAO() {
        try {
            ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance();
            this.connection = connectionSingleton.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ShowsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Show> findAll() {
        List<Show> shows = new ArrayList();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id");
                String band = rs.getString("band");
                int capacity = rs.getInt("capacity");
                double price = rs.getDouble("price");
                String direction = rs.getString("direction");
                String observation = rs.getString("observation");
                String eventDate = rs.getString("event_date");

                Show show = new Show(id, band, capacity, price, direction, observation, eventDate);
                shows.add(show);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeConection(rs, stmt);
        }
        return shows;

    }

    public Show findBy(int idEntrada) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Show show = null;
        try {
            stmt = connection.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1, idEntrada);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String band = rs.getString("band");
                int capacity = rs.getInt("capacity");
                double price = rs.getDouble("price");
                String direction = rs.getString("direction");
                String observation = rs.getString("observation");
                String eventDate = rs.getString("event_date");

                show = new Show(id, band, capacity, price, direction, observation, eventDate);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeConection(rs, stmt);
        }

        return show;
    }

    public int insert(Show show) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros = 0;
        try {
            stmt = connection.prepareStatement(SQL_CREATE);
            stmt.setString(1, show.getBand());
            stmt.setInt(2, show.getCapacity());
            stmt.setDouble(3, show.getPrice());
            stmt.setString(4, show.getDirection());
            stmt.setString(5, show.getObservation());
            stmt.setDate(6, show.getEventDate());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeConection(rs, stmt);
        }
        return registros;
    }

    public int update(int id, String band, int capacity, double price, String direction, String observation, String eventDate) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros = 0;
        try {
            stmt = connection.prepareStatement(SQL_UPDATE);
            stmt.setString(1, band);
            stmt.setInt(2, capacity);
            stmt.setDouble(3, price);
            stmt.setString(4, direction);
            stmt.setString(5, observation);
            stmt.setString(6, eventDate);
            stmt.setInt(7, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeConection(rs, stmt);
        }
        return registros;
    }

    public int delete(int id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros = 0;
        try {
            stmt = connection.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeConection(rs, stmt);
        }
        return registros;
    }

    private void closeConection(ResultSet rs, PreparedStatement stmt) {
        try {
            if (rs != null) {
                close(rs);
            }
            
            if (stmt != null) {
                close(stmt);
            }

            if (connection != null) {
                close(connection);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
