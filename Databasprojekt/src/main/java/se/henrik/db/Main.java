package se.henrik.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        WorkroleDAO workroleDAO = new WorkroleDAOImpl();

        Workrole acountant = new Workrole("Acountant", "Counting", 45000, Date.valueOf("1979-03-22"));

        Workrole doctor = new Workrole("Doctor", "Healing", 25000, Date.valueOf("1976-04-21"));

        try {
            /*List<Workrole> workroles = workroleDAO.getAllWorkroles();
            for (Workrole workrole1 : workroles)
                System.out.println(workrole1);*/

             Workrole workrole = workroleDAO.getWorkrole(3);
           // System.out.println(workrole);
            //workrole.setDescription("Tax fraud");
            //workrole.setTitle("revisor");
            //workrole.setTitle("cleaner");
           // workrole.setSalary(23000);
            //workroleDAO.updateWorkrole(workrole);

            workroleDAO.deleteWorkrole(workrole);

                //workroleDAO.insertWorkrole(doctor);
                // Workrole workrole = workroleDAO.getWorkrole(7);
                // workrole.setTitle("Boss");
                // workrole.setDescription("Buy and sell");
                // workroleDAO.updateWorkrole(workrole);
                //workroleDAO.(workrole);
                //System.out.println(workrole);

            } catch(SQLException e){
                throw new RuntimeException(e);
            }


        }

}
