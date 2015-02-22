/**
 * Created by Sensei on 21.12.2014.
 */
public class BookLibraryRunner {
    public static void main(String[] args){
        Authentication authentication = new Authentication();
        Registration registration = new Registration();
        BookUI bookUI = new BookUI(authentication, registration);
    }
}
