package it.unife.ingsw202324.MicroservizioBase.api;

import it.unife.ingsw202324.MicroservizioBase.models.MyTable;
import it.unife.ingsw202324.MicroservizioBase.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController /* Annotation per definire che la classe risponderà tramite rest  */
@RequestMapping("/api") /* Annotation per definire il path della classe  */
public class MainController {
    @Autowired
    MyService myService;
    @RequestMapping("/hello") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public List<MyTable> hello() {
        /* In attesa di una connessione db
        return myService.getAll();
         */

        /* Chiamata a un servizio che ritorna dati da DB H2 */
        List<MyTable> myServiceMock =  myService.getMock();
        return myServiceMock;
    }

}
