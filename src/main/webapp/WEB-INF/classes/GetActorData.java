import by.finalproject.entity.Actor;
import by.finalproject.services.FindActorByIdFromDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getActorData")
public class GetActorData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idFromURL = request.getParameter("id");
        Long id = Long.valueOf(idFromURL);
        Actor actorFromDB = FindActorByIdFromDB.getActorFromDB(id);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>Actor : " + actorFromDB.getName() +
                ", film : " + actorFromDB.getFilm() +
                ", age of actor : " + actorFromDB.getAge() + "</h1>");
    }
}
