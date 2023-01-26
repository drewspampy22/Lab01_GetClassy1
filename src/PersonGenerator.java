import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;


public class PersonGenerator {

    public static void main(String[] args) {

        Scanner pipe = new Scanner(System.in);

        boolean done = false;
        String ID = "";
        String FName = "";
        String LName = "";
        String title = "";
        int yearOfBirth = 0;
        String[] record = new String[4];
        ArrayList<Person> personList = new ArrayList<>();




        do {

            ID = SafeInput.getNonZeroLenString(pipe,"ID?");
            FName = SafeInput.getNonZeroLenString(pipe,"First Name?");
            LName = SafeInput.getNonZeroLenString(pipe,"Last Name?");
            title = SafeInput.getNonZeroLenString(pipe,"Title?");
            yearOfBirth = SafeInput.getInt(pipe,"Birth Year?");

            Person personIn = new Person(FName,LName,ID,title,yearOfBirth);
            personList.add(personIn);
            done = SafeInput.getYNConfirm(pipe, "Are you finished? ");

        }while(!done);

        String nameOfFile;


        nameOfFile = SafeInput.getNonZeroLenString(pipe, "Please enter the name of the file you want to save these records into: ");
        nameOfFile += ".txt";

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\"+nameOfFile);


        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(Person i:personList)
            {
                writer.write(i.toCSVRecordMethod());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file complete");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
