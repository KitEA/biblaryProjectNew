import java.io.*;

/**
 * Created by Sensei on 27.12.2014.
 */
public class Registration {

    public void registrate(String FirstName, String SecondName, String login, String password, String email, String passwordEmail){
        try{
            BufferedWriter registrationWriter = new BufferedWriter(new FileWriter("AuthenticationData.txt", true));

            registrationWriter.write(FirstName + "\n");
            registrationWriter.write(SecondName + "\n");
            registrationWriter.write(login + "\n");
            registrationWriter.write(password + "\n");
            registrationWriter.write(email+ "\n");
            registrationWriter.write("pass" + "\n");
            registrationWriter.write(passwordEmail + "\n");
            registrationWriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void registrate(String FirstName, String SecondName, String login, String password, String email){
        try{
            BufferedWriter registrationWriter = new BufferedWriter(new FileWriter("AuthenticationData.txt", true));

            registrationWriter.write(FirstName + "\n");
            registrationWriter.write(SecondName + "\n");
            registrationWriter.write(login + "\n");
            registrationWriter.write(password + "\n");
            registrationWriter.write(email+ "\n");
            registrationWriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
