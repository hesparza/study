package labs;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.URI;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hesparza
 */
public class Runner  {
    
    static String URL = "http://localhost:8080/jaxrs";
    public static void main(String[] args) {
        
        ResourceConfig rc = new ResourceConfig(ItemManagerRS.class);
        
        HttpServer server = JdkHttpServerFactory.createHttpServer(URI.create(URL), rc);                
    }
}
