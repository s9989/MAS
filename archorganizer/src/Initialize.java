import lib.ObjectPlus;
import model.Project;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Initialize
{
    private static String filepath = "data/projects.txt";

    public static void main(String[] args)
    {
        Project project = new Project();
        project.setName("Budynki mieszkalne");
        project.setStartAt(new Date());

        save(project);
    }


    public static void save(ObjectPlus extent)
    {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            extent.writeExtents(objectOut);

        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
}