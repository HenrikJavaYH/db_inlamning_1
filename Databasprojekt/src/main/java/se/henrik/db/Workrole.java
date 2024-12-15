package se.henrik.db;

import java.util.Objects;

public class Workrole {
    private Integer roleId;
    private String title;
    private String description;
    private double salary;
    private java.sql.Date creationdate;

    Workrole ( String title, String description, double salary, java.sql.Date creationdate, Integer roleId) {
        this.roleId = roleId;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creationdate = creationdate;
    }

    Workrole (String title, String description, double salary, java.sql.Date creationdate) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creationdate = creationdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workrole workrole = (Workrole) o;
        return Double.compare(salary, workrole.salary) == 0 && Objects.equals(roleId, workrole.roleId) && Objects.equals(title, workrole.title) && Objects.equals(description, workrole.description) && Objects.equals(creationdate, workrole.creationdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, title, description, salary, creationdate);
    }

    //Getter och setter

    int getRoleId() {
        return roleId;
    }
    void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    String getTitle() {
        return title;
    }
    void setTitle(String title) {
        this.title = title;
    }
    String getDescription() {
        return description;
    }
    void setDescription(String description) {
        this.description = description;
    }
    double getSalary() {
        return salary;
    }
    void setSalary(double salary) {
        this.salary = salary;
    }
    java.sql.Date getCreationdate() {
        return creationdate;
    }
    void setCreationdate(java.sql.Date creationdate) {
        this.creationdate = creationdate;
    }

    @Override
    public String toString() {
        return String.format(
                "Role ID: %d\nTitle: %s\nDescription: %s\nSalary: %.2f\nCreation date: %s\n",
                roleId, title, description, salary, creationdate != null ? creationdate.toString() : "null"
        );
    }
}
