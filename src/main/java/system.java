import Entities.users.Student;
import Entities.users.professor;
import Entities.users.user;

public class system {
     public static void main(String[] args) {
         user x = new professor();
         x= x.loging("test","test");
         System.out.println(x.getFirstName());

    }
}
