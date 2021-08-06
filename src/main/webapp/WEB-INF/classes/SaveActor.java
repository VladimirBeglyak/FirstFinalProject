import by.finalproject.entity.Actor;
import by.finalproject.services.SaveActorToDB;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/saveActor")
public class SaveActor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> result = request.getReader().lines()
                .collect(Collectors.toList());
        ServletContext context = getServletContext();

        context.setAttribute("name", result.get(0));
        context.setAttribute("film", result.get(1));
        context.setAttribute("age", result.get(2));

        String name = (String) context.getAttribute("name");
        String film = (String) context.getAttribute("film");
        String ageString = (String) context.getAttribute("age");
        Integer age = Integer.valueOf(ageString);

        Actor actor = new Actor(name, film, age);

        SaveActorToDB.getActorFromServlet(actor);

    }
}
