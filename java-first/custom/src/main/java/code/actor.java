package code;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;


@XmlRootElement(name = "actor")
@XmlType(propOrder = { "name","age", "movieList"}, namespace="abc")
@XmlAccessorType(XmlAccessType.FIELD)
public class actor {
    private String name;
    private String age;

    public ArrayList<String> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<String> movieList) {
        this.movieList = movieList;
    }

    public ArrayList<String> movieList;
    public actor() {}
    public actor(String name, String age) {
        this.name = name;
        this.age = age;

         movieList=new ArrayList<>();
    }

    public actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", age='" + age + '\''
                ;
    }

    public void setName(String name) {
        this.name = name;
    }
}
