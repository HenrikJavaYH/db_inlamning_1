package se.henrik.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        WorkroleDAO workroleDAO = new WorkroleDAOImpl();

        try {
            /*List<Workrole> workroles = workroleDAO.getAllWorkroles();
            for (Workrole workrole1 : workroles) {
                System.out.println(workrole1);
            }*/
            Workrole workrole = workroleDAO.getWorkrole(7);
           // workrole.setTitle("Boss");
           // workrole.setDescription("Buy and sell");
           // workroleDAO.updateWorkrole(workrole);
            workroleDAO.deleteWorkrole(workrole);
            //System.out.println(workrole);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Workrole Developer = new Workrole("Developer", "Developing", 38000,
                Date.valueOf(String.valueOf("1995-09-10")));

        Workrole Chef = new Workrole("CEO", "Management", 210000,
                Date.valueOf(String.valueOf("1979-08-13")), 7);

        Workrole Securityguard = new Workrole( "Security guard", "Safety and order", 35000,
                Date.valueOf(String.valueOf("1998-08-31")));





       // workroleDAO.deleteWorkrole(4);


        //workroleDAO.updateWorkrole(Chef);
        /*try {
            workroleDAO.insertWorkrole(Doctor);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }


            public static void insertWorkrole (WorkroleDAO workroleDAO, Workrole workrole) {
               // @Override

                try {
                   workroleDAO.insertWorkrole(workrole);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }

            //@Override
            public void updateWorkrole(WorkroleDAO workroleDAO, Workrole workrole) {
                 try {
                     workroleDAO.updateWorkrole(workrole);
                 } catch (SQLException e) {
                     throw new RuntimeException(e);
                 }
            }



            public static Workrole getWorkrole(WorkroleDAO workroleDAO, Workrole workrole, int id) {
                  try {
                      workroleDAO.getWorkrole(id);
                  } catch (SQLException e) {
                      throw new RuntimeException(e);
                  }
                return workrole;
            }


            public List<Workrole> getAllWorkrole(WorkroleDAO workroleDAO) {
                  try {
                      List<Workrole> workroles = workroleDAO.getAllWorkroles();
                      for (Workrole workrole1 : workroles) {

                      }
                  } catch (SQLException e) {
                      throw new RuntimeException(e);
                  }
                return List.of();

        }



}
