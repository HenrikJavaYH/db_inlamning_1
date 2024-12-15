package se.henrik.db;

import java.sql.SQLException;
import java.util.List;

public interface WorkroleDAO {

    public void insertWorkrole(Workrole workrole) throws SQLException;
    public void updateWorkrole( Workrole workrole) throws SQLException;
    public void deleteWorkrole(Workrole workrole) throws SQLException;
    public Workrole getWorkrole(Integer roleId) throws SQLException;
    public List<Workrole> getAllWorkroles() throws SQLException;
    //Samt inloggning och se den anställdes roll

    /*public void insertPerson(Person person) throws SQLException;

    public List<Person> getPersons() throws SQLException;
    public Person getPerson(Integer personId) throws SQLException;
    public void deletePerson(Integer personId) throws SQLException;
    public void updatePerson(Person person) throws SQLException;*/

   /* - skapa ny arbetsroll- ta bort en arbetsroll-
    visa alla arbetsroller- visa en arbetsroll- uppdatera
     en arbetsroll- logga in och se din (den anställdes) roll
    */


}
