package it.unife.ingsw202324.MicroservizioBase.services;


        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.web.client.RestClient;
        import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class TemplateRestConsumer {
    private static final String URI_BASE_MOCK = "http://localhost:3001/api/";
    private static final RestTemplate restTemplate = new RestTemplate();
    public static Response callREST(String resourceName, String uriBase, boolean useMock) {
        
        try {
            System.out.println("Calling: " + URI_BASE_MOCK);

            return restTemplate.getForObject(URI_BASE_MOCK,Response.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;    
        }
        
}
}