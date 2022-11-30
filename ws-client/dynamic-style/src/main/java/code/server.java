package code;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@WebService(targetNamespace = "abc")
public interface server {

    @WebMethod
    @WebResult(name="movies")
   public HashMap<String, movie> getAllmovie();
    @WebMethod
    @WebResult(name="actors")
    public HashMap<String, actor> getAllactor();
    @WebMethod
    @WebResult(name="movies")
    public HashMap<String, movie> addmovie(@WebParam(name = "id") String id, @WebParam(name = "title")String title);
    @WebMethod
    @WebResult(name="actor")
    public HashMap<String, actor> addactor(@WebParam(name = "name") String name, @WebParam(name = "age")String age);
    @WebMethod
    @WebResult(name="connect")
    public void connect(@WebParam(name = "name") String name, @WebParam(name = "title")String title);
}
