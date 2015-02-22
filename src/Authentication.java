import java.io.*;

/**
 * Created by Sensei on 23.12.2014.
 */
public class Authentication {

    private boolean userExist = false;
    private boolean userIsAdmin = false;

    public boolean authentication(String login, String password){
        try {
            int i = 0;
            BufferedReader reader = new BufferedReader(new FileReader("AuthenticationData.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.equals(login)) {
                    i++;
                } else if (line.equals(password)) {
                    i++;
                }
            }
            reader.close();

            if (i == 2) {
                userExist = true;
            }

        } catch(IOException ex){
            ex.printStackTrace();
        }
        return userExist;
    }

    public boolean adminAuthentication(String login, String password){
        try{
            int j = 0;
            BufferedReader reader = new BufferedReader(new FileReader("AuthenticationData.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.equals("Kit") && line.equals(login)){
                    j++;
                } else if (line.equals("1237qua") && line.equals(password)){
                    j++;
                }
            }
            reader.close();

            if (j == 2){
                userIsAdmin = true;
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }
        return  userIsAdmin;
    }
}
