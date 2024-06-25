import java.util.*;
import java.net.HttpCookie;

public class lab10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the value for the cookie (EMPID): ");
        String cookieValue = s.nextLine();

        s.close();

        HttpCookie cookie = new HttpCookie("EMPID", cookieValue);

        System.out.println("Cookie Name: " + cookie.getName());
        System.out.println("Cookie Value: " + cookie.getValue());
    }
}
