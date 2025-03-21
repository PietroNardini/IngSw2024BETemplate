package it.unife.ingsw202324.MicroservizioBase.api;
import it.unife.ingsw202324.MicroservizioBase.services.Response;

import it.unife.ingsw202324.MicroservizioBase.models.MyTable;
import it.unife.ingsw202324.MicroservizioBase.services.MyService;
import it.unife.ingsw202324.MicroservizioBase.services.TemplateRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /* Annotation per definire che la classe risponderà tramite rest  */
@RequestMapping("/api") /* Annotation per definire il path della classe  */
public class MainController {
    @Autowired
    MyService myService;
    @RequestMapping("/testMysql") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public List<MyTable> testMysql() {
        return myService.getAll();
    }

    @RequestMapping("/testWithElements") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public List<MyTable> addElements() {

        /* Chiamata a un servizio che ritorna inserisce 3 dati e ritorna il db */
        return myService.addElements();
    }
    @RequestMapping("/testInsert")
    public String testInsert() {
        myService.insert(new MyTable(null, "Inserted via API"));
        return "Inserted successfully!";
    }
    
    @RequestMapping("/callREST") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public String callRest() {
        Response res=TemplateRestConsumer.callREST("helloMock", null, true);
        Long id=Long.valueOf(res.getId());
        String description=res.getDescription();
        myService.insert(new MyTable(id, description));
        return "Inserted successfully!";

    
    }
}
