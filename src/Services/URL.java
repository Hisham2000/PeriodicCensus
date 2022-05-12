
package Services;

public class URL {
    
    private String url;

    protected String setURL() {
        url = "jdbc:mysql://localhost:3306/PeriodicCensus"
                + "?useUnicode=true&characterEncoding=UTF-8";
        return url;
    }
    
    protected String getURL()
    {
        return url;
    }
}
