

package DatabaseConnection;
import java.sql.*;

public class Communicatie {
    public void addToDatabase(String SQL){

        // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien deze voor jou anders is.
        String connectionUrl = "jdbc:sqlserver://LAPTOP-Q21ELVRV;databaseName=ProgRDB;integratedSecurity=true;";

        // Connection beheert informatie over de connectie met de database.
        Connection con = null;

        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;

        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;

        try {
 // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);


            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
            while (rs.next()) {
                // Vraag per row de kolommen in die row op.
                String email = rs.getString("Email");
                String name = rs.getString("Name");
                Date birthDate = rs.getDate("BirthDate");
                String gender = rs.getString("Gender");
                String address = rs.getString("Address");
                String residence = rs.getString("Residence");
                String country = rs.getString("Country");

                // Print de kolomwaarden.
                // System.out.println(Email + " " + Name + " " + BirthDate + " " + Gender + " " + Address + " " + Residence + " " + Country);

                // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
                // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.
                System.out.format("| %20s | %-20s | %-18s | %-2s | %-20s| %-20s| %-20s\n", email, name,birthDate,gender, address, residence, country);
            }

        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }
}