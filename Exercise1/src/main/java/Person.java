import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class Person
{
    private UUID id;
    private String name;

    public Person()
    {
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID generateUUID()
    {
        return UUID.randomUUID();
    }

    public void getNameFromCommandLine()
    {
        String name;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please enter a name: ");
            name = bufferedReader.readLine();
            while (name.isEmpty())
            {
                System.out.println("Please enter a name: ");
                name = bufferedReader.readLine();
            }
            this.setName(name);
            this.setId(this.generateUUID());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "{Name= "+name+"\t"+"id= "+id+"}";
    }


}
