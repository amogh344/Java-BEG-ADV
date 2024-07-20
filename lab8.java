import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Lab8")
public class Lab8 extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
    public Lab8() {
        super();
        // TODO Auto-generated constructor stub
    }

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        response.setContentType("text/html");
        PrintWriter p = response.getWriter();
        p.println("<html><head>");
        p.println("<title>Greeting</title>");
        p.println("</head><body><h1>Hello, " + username + "</h1>");
        p.println("<p>How are you?</p></body></html>");
        p.close(); // Close the PrintWriter
    }
}
