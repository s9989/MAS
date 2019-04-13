import java.io.*;
import java.util.ArrayList;

/* ekstensja */
public class Users {

    private static String filename = "users.data";
    private static ArrayList<User> users = new ArrayList<>();

    /* ekstensja trwałość */
    public static void save() throws IOException
    {
        ObjectOutputStream out2 = new ObjectOutputStream(new BufferedOutputStream(new
                FileOutputStream(Users.filename)));
        Users.writeExtent(out2);
        out2.close();
    }

    public static void load() throws IOException
    {
        ObjectInputStream in2 = new ObjectInputStream(new BufferedInputStream(new
                FileInputStream(Users.filename)));
        Users.readExtent(in2);
        in2.close();
    }

    public static void add(User user)
    {
        Users.users.add(user);
    }

    public static void print()
    {
        for (User user : Users.users)
        {
            System.out.println(user.getFullName());
        }
    }

    private static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(Users.users);
    }
    private static void readExtent(ObjectInputStream stream) throws IOException {
        try {
            Users.users = (ArrayList<User>) stream.readObject();
        } catch (ClassNotFoundException ex) {
            throw new IOException(ex.getMessage(), ex.getCause());
        }
    }

}
