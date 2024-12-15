package se.henrik.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkroleDAOImpl implements WorkroleDAO {

    @Override
    public void insertWorkrole(Workrole workrole) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO work_role (title, description, salary, creation_date) VALUES (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, workrole.getTitle());
            ps.setString(2, workrole.getDescription());
            ps.setDouble(3, workrole.getSalary());
            ps.setDate(4, workrole.getCreationdate());
            int rowsaffected = ps.executeUpdate();
            System.out.println("Rader påverkade: " + rowsaffected);
            JDBCUtil.commit(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            JDBCUtil.closeStatement(ps);
            JDBCUtil.closeConnection(conn);
        }
    }
    @Override
    public void updateWorkrole(Workrole workrole) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "UPDATE work_role SET title = ?, description = ?, salary = ?, creation_date = ? WHERE role_Id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, workrole.getTitle());
            ps.setString(2, workrole.getDescription());
            ps.setDouble(3, workrole.getSalary());
            if (workrole.getCreationdate() != null) {
                ps.setDate(4, workrole.getCreationdate());
            } else {
                ps.setNull(4, Types.DATE);
            }
            ps.setInt(5, workrole.getRoleId());
            int rowsaffected = ps.executeUpdate();
            System.out.println("Rader påverkade : " + rowsaffected);
            JDBCUtil.commit(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeStatement(ps);
            JDBCUtil.closeConnection(conn);
        }
    }

    @Override
    public void deleteWorkrole(Workrole workrole) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "DELETE FROM work_role WHERE role_Id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, workrole.getRoleId());
            int rowsaffected = ps.executeUpdate();
            JDBCUtil.commit(con);
        } catch (SQLException e) {
                e.printStackTrace();
                throw e;
        }
        finally {
            JDBCUtil.closeStatement(ps);
            JDBCUtil.closeConnection(con);
        }
    }
    @Override
    public Workrole getWorkrole(Integer roleId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Workrole workrole = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM work_role WHERE role_Id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();

            if (rs.next()) {
                Integer workroleId = rs.getInt("role_Id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Double salary = rs.getDouble("salary");
                Date creationdate = rs.getDate("creation_date");
                workrole = new Workrole(title, description, salary, creationdate, roleId);
            }
            else {
                System.out.println("Ingen person hittad med detta id");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(ps);
            JDBCUtil.closeConnection(con);
        }
        return workrole;
    }
    @Override
    public List<Workrole> getAllWorkroles() throws SQLException {
        List<Workrole> toReturn = new ArrayList<>();
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM work_role";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer roleId = rs.getInt("role_Id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                double salary = rs.getDouble("salary");
                Date date = rs.getDate("creation_date");
                Workrole workrole = new Workrole(title, description, salary, date, roleId);
                toReturn.add(workrole);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(ps);
            JDBCUtil.closeConnection(con);
        }
        return toReturn;
    }


}
