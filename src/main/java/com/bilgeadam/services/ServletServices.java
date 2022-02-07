package com.bilgeadam.services;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


@RestController
@Log4j2
public class ServletServices {

    @Autowired
    private ServletContext servletContext;

    // http://localhost:8090/restcontroller/servlet
    @GetMapping("/restcontroller/servlet")
    public ResponseEntity<?> getServletServices(HttpServletRequest request) {
        String uri = request.getRequestURI() + " ";
        String session = request.getSession() + " ";
        return ResponseEntity.ok("uri: " + uri + " \nsession: " + session);
    }


    // http://localhost:8090/restcontroller/servlet/secret
    @GetMapping("/restcontroller/servlet/secret")
    public ResponseEntity<?> getServletSecretServices() {
        String secretData=servletContext.getInitParameter("secretInformation");
        log.info(secretData);
        //2.yol ==>  request.getServletContext()
        return ResponseEntity.ok("secret: " + secretData);
    }

}
