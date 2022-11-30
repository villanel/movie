package code;

import java.util.*;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(targetNamespace = "abc")
public class server {
    HashMap<String, movie> movieMap = new HashMap<>();
    HashMap<String, actor> actorMap = new HashMap<>();
    public server() {
    }

    @WebMethod
    @WebResult(name="movies")
        public HashMap<String, movie> getAllmovie() {
            return movieMap;
        }
    @WebMethod
    @WebResult(name="actors")
    public HashMap<String, actor> getAllactor() {
        return actorMap;
    }
    @WebMethod
    @WebResult(name="movies")
    public HashMap<String, movie> addmovie(@WebParam(name = "id") String id, @WebParam(name = "title")String title) {
        movie movie = new movie(title, id);
        movieMap.put(title,movie);
        return movieMap;
    }
    @WebMethod
    @WebResult(name="actor")
    public HashMap<String, actor> addactor(@WebParam(name = "name") String name, @WebParam(name = "age")String age) {
        actor actor = new actor(name,age);
        actorMap.put(name,actor);
        return actorMap;
    }
    @WebMethod
    @WebResult(name="connect")
    public void connect(@WebParam(name = "name") String name, @WebParam(name = "title")String title) {
        actor actor = actorMap.get(name);
        movie movie = movieMap.get(title);
        actor.movieList.add(title);
        movie.ActorList.add(name);
        actorMap.replace(name,actor);
        movieMap.replace(title,movie);
    }
}
