package code;


import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@XmlRootElement(name = "movie")
@XmlType(propOrder = { "title","year", "ActorList","id","released","runtime","genre","actors","plot","poster","imdbRating"}, namespace="abc")
@XmlAccessorType(XmlAccessType.FIELD)
public class movie {
    private String released;
    private String runtime;
    private String genre;
    private String actors;
    private String plot;
    private String imdbRating;
    private String poster;
    private String title;
    private String id;
    private String year;

    public ArrayList<String> getGetActor() {
        return ActorList;
    }

    public void setGetActor(ArrayList<String> getActor) {
        this.ActorList = getActor;
    }

    public ArrayList<String> ActorList;

    public movie(String title, String id) {
        this.title = title;
        this.id = id;
        ActorList = new ArrayList<>();
    }

    public movie() {
    }

    ;

    public movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public movie(String released, String runtime, String genre, String actors, String plot, String imdbRating, String poster, String title, String id, String year) {
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.actors = actors;
        this.plot = plot;
        this.imdbRating = imdbRating;
        this.poster = poster;
        this.title = title;
        this.id = id;
        this.year = year;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                        ", id='" + id + '\'' +
                        "released='" + released + '\'' +
                        ", runtime='" + runtime + '\'' +
                        ", genre='" + genre + '\'' +
                        ", actors='" + actors + '\'' +
                        ", plot='" + plot + '\'' +
                        ", imdbRating='" + imdbRating + '\'' +
                        ", poster='" + poster + '\'' +
                        ", year='" + year + '\'' +
                        ", ActorList=" + ActorList
                ;
    }

    public static movie serch(String data) {
        String icarus = movie.getHttpRequestData(data);
        Gson gson = new Gson();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        HashMap<String,String> map = gson.fromJson(icarus, stringStringHashMap.getClass());
        String title =  map.get("Title");
        String year = map.get("Year");
        String released = map.get("Released");
        String runtime = map.get("Runtime");
        String genre = map.get("Genre");
        String actors = map.get("Actors");
        String plot = map.get("Plot");
        String imdbRating = map.get("imdbRating");
        String poster = map.get("Poster");
        String imdbID = map.get("imdbID");
        movie movie = new movie(released, runtime, genre, actors, plot, imdbRating, poster, title, imdbID, year);
        return movie;
    }

    public String getGenre() {
        return genre;
    }

    public static String getHttpRequestData(String data) {
        String returnString = "1";
        try {
            StringBuilder sb = new StringBuilder();
            String urlP = "http://www.omdbapi.com/?apikey=dcbad6ad&t=";
            sb.append(urlP);
            data = URLEncoder.encode(data, "UTF-8");
            sb.append(data);
            URL url = new URL(sb.toString());
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");
            connect.connect();
            InputStream isString = connect.getInputStream();
            BufferedReader isRead = new BufferedReader(new InputStreamReader(isString));
            String str = "";
            while ((str = isRead.readLine()) != null) {
                str = new String(str.getBytes(), "UTF-8");
                returnString = str;
            }
            isString.close();
            connect.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnString;
    }
}