package code;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class DemoWSClient {
	private static final String wsdlLocation = "http://localhost:8080/custom/Service?wsdl";

	public static void main(String[] args) throws MalformedURLException {
		URL location = new URL(wsdlLocation);
		String namespace = "abc";
		QName serviceName = new QName(namespace, "serverService");
		Service service = Service.create(location, serviceName);
		QName portName = new QName(namespace, "serverPort");

		server proxy = service.getPort(portName, server.class);

		proxy.connect("Mark Hamill","star wars");
		HashMap<String, actor> allactor = proxy.getAllactor();
		HashMap<String, movie> allmovie = proxy.getAllmovie();
		//查询演员和电影
		movie star = allmovie.get("star wars");
		actor mark = allactor.get("Mark Hamill");
		//电影和演员相关信息
		System.out.println("Search movie actor information:");
		System.out.println("star wars' detail:");
		System.out.println(star);
		System.out.println("Mark's detail:");
		System.out.println(mark);
		System.out.println("\n");
		//关联电影和演员信息
		proxy.connect("Mark Hamill","star wars");
		System.out.println("after connect:");
		System.out.println("star wars' actorlist:");
		System.out.println(star.ActorList);
		System.out.println("Mark's movielist:");

		System.out.println(mark.movieList);
		System.out.println("\n");
		//从omdb获取电影相关信息
		System.out.println("star wars details from omdb:");
		System.out.println(code.movie.serch("star wars"));
	}}