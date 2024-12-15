package se.henrik.db;

import org.hsqldb.lib.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Dbtest {

    @Test
    public void testConnectionIsOk () {
        try {
            JDBCUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testVerifyAddperson () {
        WorkroleDAO workroleDAO = new WorkroleDAOImpl();
        Workrole workrole = new Workrole("Judge", "Office", 44000, Date.valueOf("1980-05-13"));
        List<Workrole> workroles = new ArrayList<>();

        try {
            workroleDAO.insertWorkrole(workrole);


            System.out.println(workroleDAO.getAllWorkroles());




           //workroles = workroleDAO.getAllWorkroles();


        } catch (SQLException e) {
            throw new RuntimeException(e);

        }







    }



    @AfterEach
    public void tearDown() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            //ta bort person-tabellen
            stmt.execute("DROP TABLE IF EXISTS work_role");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //stäng ned resurser
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
        }

    }





}
