import java.sq.*;
public class connexion
{
    public Statement etat;
    public Connection con;
    public connexion()
    {
        this.etat=null;
        this.con=null;
        try{
            class.forName("org.gjt.mm.mysql.driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost//sd ","user","mdp");
            this.etat = this.con.createStatement();
        }
        catch(ClassNotFoundException){}
        catch(SQLExeption){}
    }
}