import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Lab9")
public class Lab_9 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Lab_9() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String usn = request.getParameter("usn");
        int m1 = Integer.parseInt(request.getParameter("m1"));
        int m2 = Integer.parseInt(request.getParameter("m2"));
        int total = m1 + m2;
        double percentage = (total / 200.0) * 100;

        response.setContentType("text/html");
        PrintWriter p = response.getWriter();
        p.println("<html><head>");
        p.println("<title>Student Details</title></head>");
        p.println("<body><h2>Student Details</h2>");
        p.println("<p>Name:" + name + "<br>USN:" + usn + "<br>Mark 1:" + m1 + "<br>Mark 2:" + m2 + "<br>Total Marks:" + total + "<br>Percentage:" + percentage + "%</p>");
        p.println("</body></html>");
    }
}
