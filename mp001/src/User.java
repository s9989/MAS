import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    /* atrybut klasowy */
    private static int minimalAge = 18;

    private String firstName;

    /* atrybut opcjonalny */
    private String secondName;
    private String lastName;
    private LocalDate birthDate;

    /* atrybut powatarzalny*/
    private ArrayList<String> roles = new ArrayList<>();

    /* atrybut złożony */
    private Address address;

    User()
    {
        this.roles.add("USER");
    }

    User(String firstName, String lastName)
    {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /* przeciążanie */
    User(String firstName, String lastName, LocalDate birthDate)
    {
        this(firstName, lastName);
        this.birthDate = birthDate;
    }

    /* metoda klasowa */
    public static int getMinimalAge()
    {
        return User.minimalAge;
    }

    /* atrybut wyliczalny (pochodny) */
    public int getAge()
    {
        LocalDate curDate = LocalDate.now();
        return Period.between(birthDate, curDate).getYears();
    }

    public String getFullName()
    {
        StringBuilder result = new StringBuilder(this.firstName);

        if (null != this.getSecondName()) {
            result.append(" ");
            result.append(this.secondName);
        }

        result.append(" ");
        result.append(this.lastName);

        return result.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public void addRole(String role) {
        this.roles.add(role);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
