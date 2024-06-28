package co.com.apirest.automation.utils;

public enum Uri {

    //Aqui en el Uri contiene las peticiones de nuestro api rest
    LIST_USERS("/api/users?page=2"),
    CREATE_USER("/api/users"),
    UPDATE_USER("/api/users/2"),
    DELETE("/api/users/2");

    private String uri;

    Uri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
