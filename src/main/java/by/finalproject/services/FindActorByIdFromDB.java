package by.finalproject.services;

import by.finalproject.dao.ActorDao;
import by.finalproject.entity.Actor;

public class FindActorByIdFromDB {

    public static Actor getActorFromDB(Long id){
        ActorDao actorDao = ActorDao.newInstance();
        Actor actor = actorDao.findById(id);
        return actor;
    }
}
