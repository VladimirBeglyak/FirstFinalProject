package by.finalproject.services;

import by.finalproject.dao.ActorDao;
import by.finalproject.entity.Actor;

public class SaveActorToDB {

    public static void getActorFromServlet(Actor actor){
        ActorDao actorDao = ActorDao.newInstance();
        System.out.println(actorDao.saveActor(actor));
    }
}
