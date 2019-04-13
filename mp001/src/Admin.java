import java.util.ArrayList;

public class Admin extends User {

    /* przesłanianie */
    @Override
    public ArrayList<String> getRoles() {

        ArrayList<String> roles = super.getRoles();

        roles.add("ADMIN");

        return roles;
    }
}
