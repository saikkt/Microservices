public class PersonDemo
{
    public static void main(String[] args) {
        Person person = new Person();
        if(args.length==0)
        {
            person.getNameFromCommandLine();
        }
        else {
            person.setName(args[0]);
            person.setId(person.generateUUID());
        }
        System.out.println(person.toString());
    }
}
