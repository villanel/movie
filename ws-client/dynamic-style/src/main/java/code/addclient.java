package code;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class addclient {


        private static final String wsdlLocation = "http://localhost:8080/custom/Service?wsdl";

        public static void main(String[] args) throws MalformedURLException {
            URL location = new URL(wsdlLocation);
            String namespace = "abc";
            QName serviceName = new QName(namespace, "serverService");
            Service service = Service.create(location, serviceName);
            QName portName = new QName(namespace, "serverPort");

            server proxy = service.getPort(portName, server.class);

//		add movie
             proxy.addmovie("tt0076759", "star wars");
//		add actor
             proxy.addactor("Mark Hamill", "20");
        }

}
