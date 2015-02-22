import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

import javax.mail.*;
import java.util.Properties;

/**
 * Created by Sensei on 21.12.2014.
 */
public class BookUI {

    private final DefaultTableModel questTableModel;
    private final JTextField searchField;

    private JTextField login = new JTextField(10);
    private JTextField password = new JTextField(10);

    private JTextField FirstName = new JTextField(10);
    private JTextField SecondName = new JTextField(10);
    private JTextField loginChoose = new JTextField(10);
    private JTextField passwordChoose = new JTextField(10);
    private JTextField emailChoose = new JTextField(10);
    private JTextField emailPassword = new JTextField(10);

    private JFrame authenticationF;
    private JFrame registrationF;
    private JFrame frame;
    private JFrame questFrame;
    private JFrame dataIsNotValid;
    private JFrame thereIsNothingToDelete;

    private JTable table;
    private JTable firstQuestTable;
    private JTable questTable;
    private DefaultTableModel tableModel;
    private JTextField txtField1;
    private JTextField txtField2;
    private JTextField txtField3;
    private JTextField txtField4;
    private JTextField txtField5;
    private JTextField txtField6;

    private Authentication authentication;
    private Registration registration;

    private int firstRegistration = 0;

    public BookUI(Authentication authenticationForm, Registration registrationForm) {
        this.authentication = authenticationForm;
        this.registration = registrationForm;

        authenticationF = new JFrame("Authentication");
        registrationF = new JFrame("Registration");

        JPanel panelA = new JPanel();
        panelA.setLayout(new BoxLayout(panelA, BoxLayout.Y_AXIS));
        JPanel panelAButtons = new JPanel();
        JPanel panelAL = new JPanel();
        panelAL.setLayout(new BoxLayout(panelAL, BoxLayout.Y_AXIS));

        JButton registrationButton = new JButton("Registration");
        panelAButtons.add(registrationButton);
        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticationF.setVisible(false);
                firstRegistration++;
                registrationF.setVisible(true);
                }
        });

        JButton loginButton = new JButton("Enter");
        panelAButtons.add(loginButton);
        loginButton.addActionListener(new EnterButtonListener());

        JLabel loginLabel = new JLabel("Login");
        panelA.add(loginLabel);
        panelA.add(login);
        JLabel passwordLabel = new JLabel("Password");
        panelAL.add(passwordLabel);
        panelAL.add(password);
        authenticationF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        authenticationF.getContentPane().add(BorderLayout.NORTH, panelA);
        authenticationF.getContentPane().add(BorderLayout.CENTER, panelAL);
        authenticationF.getContentPane().add(BorderLayout.SOUTH, panelAButtons);
        authenticationF.setBounds(500, 500, 10, 50);
        authenticationF.pack();
        authenticationF.setVisible(true);


        JPanel panelR = new JPanel();
        panelR.setLayout(new BoxLayout(panelR, BoxLayout.Y_AXIS));
        JPanel panelRButtons = new JPanel();

        JButton registerButton = new JButton("Register");
        panelRButtons.add(registerButton);
        registerButton.addActionListener(new RegisterButtonListener());

        JButton returnToAuthenticationButton = new JButton("Return to authentication");
        panelRButtons.add(returnToAuthenticationButton);
        returnToAuthenticationButton.addActionListener(new ReturnToAuthenticationButtonListener());

        JLabel firstNameLabel = new JLabel("First name");
        panelR.add(firstNameLabel);
        panelR.add(FirstName);
        JLabel secondNameLabel = new JLabel("Second name");
        panelR.add(secondNameLabel);
        panelR.add(SecondName);
        JLabel loginChooseLabel = new JLabel("Login");
        panelR.add(loginChooseLabel);
        panelR.add(loginChoose);
        JLabel passwordChooseLabel = new JLabel("Password");
        panelR.add(passwordChooseLabel);
        panelR.add(passwordChoose);
        JLabel emailChooseLabel = new JLabel("Email");
        panelR.add(emailChooseLabel);
        panelR.add(emailChoose);
        JLabel emailPasswordLabel = new JLabel("Email Password");
        panelR.add(emailPasswordLabel);
        panelR.add(emailPassword);

        registrationF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        registrationF.getContentPane().add(BorderLayout.NORTH, panelR);
        registrationF.getContentPane().add(BorderLayout.SOUTH, panelRButtons);
        registrationF.setBounds(500, 500, 10, 50);
        registrationF.pack();

        thereIsNothingToDelete = new JFrame("Delete error");
        JPanel errorDelete = new JPanel();
        JPanel errorDeleteButtons = new JPanel();
        JLabel errorDeleteMessage = new JLabel("There is nothing to delete");
        JButton okDeleteButtonEr = new JButton("Ok");
        okDeleteButtonEr.addActionListener(new okDeleteButtonErListener());
        errorDelete.add(errorDeleteMessage);
        errorDeleteButtons.add(okDeleteButtonEr);
        thereIsNothingToDelete.getContentPane().add(BorderLayout.NORTH, errorDelete);
        thereIsNothingToDelete.getContentPane().add(BorderLayout.SOUTH, errorDeleteButtons);
        thereIsNothingToDelete.setBounds(500, 500, 10, 50);
        thereIsNothingToDelete.pack();
        thereIsNothingToDelete.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        dataIsNotValid = new JFrame("Error");
        JPanel errorPanel = new JPanel();
        JPanel errorPanelButtons = new JPanel();
        JLabel error = new JLabel("Access denied");
        JButton okErrorButton = new JButton("Ok");
        okErrorButton.addActionListener(new OkErrorButtonListener());
        errorPanel.add(error);
        errorPanelButtons.add(okErrorButton);
        dataIsNotValid.getContentPane().add(BorderLayout.NORTH, errorPanel);
        dataIsNotValid.getContentPane().add(BorderLayout.SOUTH, errorPanelButtons);
        dataIsNotValid.setBounds(500, 500, 10, 50);
        dataIsNotValid.pack();
        dataIsNotValid.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame = new JFrame("Book shop");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        table = new JTable();
        JLabel lblField1 = new JLabel("Book Title   ");
        JLabel lblField2 = new JLabel("Author   ");
        JLabel lblField3 = new JLabel("Year of Out  ");
        JLabel lblField4 = new JLabel("Publisher  ");
        JLabel lblField5 = new JLabel("Price in usd  ");
        JLabel lblField6 = new JLabel("Number of copies  ");
        txtField1 = new JTextField();
        txtField2 = new JTextField();
        txtField3 = new JTextField();
        txtField4 = new JTextField();
        txtField5 = new JTextField();
        txtField6 = new JTextField();
        txtField1.setPreferredSize(lblField1.getPreferredSize());
        txtField2.setPreferredSize(lblField2.getPreferredSize());
        txtField3.setPreferredSize(lblField3.getPreferredSize());
        txtField4.setPreferredSize(lblField4.getPreferredSize());
        txtField5.setPreferredSize(lblField5.getPreferredSize());
        txtField6.setPreferredSize(lblField6.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane);

        JButton addBook = new JButton("add book");
        JButton deleteBook = new JButton("delete book");
        JPanel buttonsPanel = new JPanel();
        JPanel bookData = new JPanel();
        bookData.add(lblField1);
        bookData.add(txtField1);
        bookData.add(lblField2);
        bookData.add(txtField2);
        bookData.add(lblField3);
        bookData.add(txtField3);
        bookData.add(lblField4);
        bookData.add(txtField4);
        bookData.add(lblField5);
        bookData.add(txtField5);
        bookData.add(lblField6);
        bookData.add(txtField6);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem loadMenuItem = new JMenuItem("Load");
        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuItemListener());
        loadMenuItem.addActionListener(new LoadMenuListener());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        buttonsPanel.add(addBook);
        buttonsPanel.add(deleteBook);
        addBook.addActionListener(new AddBookListener());
        deleteBook.addActionListener(new DeleteBookListener());

        tableModel = new DefaultTableModel(new Object[]{"Book title",
                "Author",
                "Year of out",
                "Publisher",
                "Price in usd", "NumberOfCopies"}, 0);

        table.setModel(tableModel);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.EAST, buttonsPanel);
        frame.getContentPane().add(BorderLayout.NORTH, bookData);
        frame.setBounds(100, 100, 800, 200);
        frame.pack();

        questTableModel = new DefaultTableModel(new Object[]{"Book title",
                "Author",
                "Year of out",
                "Publisher",
                "Price in usd"}, 0);

        questFrame = new JFrame("Book Shop");
        questFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel questPanel = new JPanel();
        questPanel.setLayout(new BoxLayout(questPanel, BoxLayout.Y_AXIS));

        //panelAL.setLayout(new BoxLayout(panelAL, BoxLayout.Y_AXIS));

        firstQuestTable = new JTable();
        JScrollPane firstQuestScrollPane = new JScrollPane(firstQuestTable);

        
        searchField = new JTextField(5);
        questPanel.add(searchField);

        JPanel userInteraction = new JPanel();
        userInteraction.setLayout(new BoxLayout(userInteraction, BoxLayout.Y_AXIS));

        JButton searchButton = new JButton("Search");
        userInteraction.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            private String stringToFind;
            private String inNeed = searchField.getText();
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = firstQuestTable.getRowCount();
                int neededRow = 0;
                for (int i = 0; (i < count) && (stringToFind != inNeed); i++, neededRow++){
                    stringToFind = (String)((((Vector)tableModel.getDataVector().elementAt(i)).elementAt(0)));
                }
                neededRow--;
                tableModel.moveRow(neededRow, neededRow, 0);
            }
        });

        questPanel.add(firstQuestScrollPane);

        firstQuestTable.setModel(tableModel);
        firstQuestTable.setAutoCreateRowSorter(true);

        questFrame.getContentPane().add(BorderLayout.CENTER, questPanel);

        JPanel questTablePanel = new JPanel();
        questTable = new JTable();
        JScrollPane questScrollPane = new JScrollPane(questTable);
        questTablePanel.add(questScrollPane);

        JButton formOrder = new JButton("Order");
        questTablePanel.add(formOrder);
        formOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String to = null;
                String from = null;
                String passwordToGetTo = null;

                try {
                    BufferedReader reader = new BufferedReader(new FileReader("AuthenticationData.txt"));
                    String line = null;
                    int i = 1;

                    line = reader.readLine();
                    while (!(line.equals("Kit"))) {
                        line = reader.readLine();
                    }
                    while (!(line.contains("@"))) {
                        line = reader.readLine();
                    }
                    from = line;

                    while(!(line.contains("pass"))){
                        line = reader.readLine();
                    }
                    line = reader.readLine();
                    passwordToGetTo = line;

                    while(!(line.equals(login.getText()))){
                        line = reader.readLine();
                    }

                    while (!(line.contains("@"))){
                        line = reader.readLine();
                    }
                    to = line;


                    reader.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                final String toAdr = to;
                final String fromAdr = from;
                final String passwordToEmail = passwordToGetTo;

                Properties props = new Properties();
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");

                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return  new PasswordAuthentication(fromAdr, passwordToEmail);
                    }
                });

                try{

                    Message msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress(fromAdr));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAdr));
                    msg.setSubject("Book Shop");
                    msg.setText("Books was delivered!");

                    Transport.send(msg);

                } catch (MessagingException e1){
                    throw new RuntimeException();
                }
            }
        });

        questTable.setModel(questTableModel);

        questFrame.getContentPane().add(BorderLayout.WEST, questTablePanel);


        JButton buyBook = new JButton("Buy book");
        userInteraction.add(buyBook);
        buyBook.addActionListener(new ActionListener() {
            private String[] content = new String[1000];
            @Override
            public void actionPerformed(ActionEvent e) {
                int countColumns = firstQuestTable.getColumnCount();
                int stringCount = 0;

                for (int i : firstQuestTable.getSelectedRows()) {
                    for (int j = 0; j < countColumns; j++) {
                        if((countColumns - 1) == j){
                            int numberOfCopies =  Integer.parseInt((String) ((((Vector) tableModel.getDataVector().elementAt(i)).elementAt(j))));
                            numberOfCopies--;
                            tableModel.setValueAt(Integer.toString(numberOfCopies), i, j);
                        } else{
                            content[stringCount] = (String)((((Vector)tableModel.getDataVector().elementAt(i)).elementAt(j)));
                        }

                        stringCount++;
                    }
                }

                for(int j = 0; j < (stringCount - 1); j = j + 6){
                    questTableModel.addRow(new Object[]{content[j], content[j + 1], content[j + 2], content[j + 3], content[j + 4]});
                }
            }
        });

        questFrame.getContentPane().add(BorderLayout.EAST, userInteraction);

        questFrame.setBounds(100, 100, 800, 200);
        questFrame.pack();
    }

    class EnterButtonListener implements ActionListener {

        private BookShopLoad bookShopLoad = new BookShopLoad();

        public void actionPerformed(ActionEvent event) {
            boolean userInBase = authentication.authentication(login.getText(), password.getText());
            boolean userInAdminGroup = authentication.adminAuthentication(login.getText(), password.getText());
            if (userInAdminGroup == true) {
                frame.setVisible(true);
                authenticationF.setVisible(false);
            } else if (userInBase == true){
                questFrame.setVisible(true);
                bookShopLoad.loadBookShop(new File("Books.txt"), tableModel);
                authenticationF.setVisible(false);
            }
            else {
                dataIsNotValid.setVisible(true);
            }
        }
    }

    class RegisterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(firstRegistration > 1) {
                registration.registrate(FirstName.getText(), SecondName.getText(), loginChoose.getText(), passwordChoose.getText(), emailChoose.getText());
            } else {
                registration.registrate(FirstName.getText(), SecondName.getText(), loginChoose.getText(), passwordChoose.getText(), emailChoose.getText(), emailPassword.getText());
            }
            registrationF.setVisible(false);
            authenticationF.setVisible(true);
        }
    }

    class ReturnToAuthenticationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            registrationF.setVisible(false);
            authenticationF.setVisible(true);
        }
    }

    class OkErrorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            dataIsNotValid.setVisible(false);
        }
    }

    class okDeleteButtonErListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            thereIsNothingToDelete.setVisible(false);
        }
    }

    class AddBookListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int count = tableModel.getRowCount();
            int neededRow = 0;
            int rowToChange = 0;
            for (int i = 0; (i < count) && (neededRow < 1); i++){
                if ((txtField1.getText()).equals((String)((((Vector)tableModel.getDataVector().elementAt(i)).elementAt(0))))){
                    neededRow++;
                }
                rowToChange++;
            }
            rowToChange--;

            if (neededRow == 1){
                tableModel.setValueAt(Integer.toString(Integer.parseInt((String) (tableModel.getValueAt(rowToChange, 5))) + Integer.parseInt(txtField6.getText())), rowToChange, 5);
            } else {
                tableModel.addRow(new Object[]{txtField1.getText(), txtField2.getText(), txtField3.getText(), txtField4.getText(), txtField5.getText(), txtField6.getText()});
            }
        }
    }

    class DeleteBookListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int count = tableModel.getRowCount();
            if (count == 0) {
                thereIsNothingToDelete.setVisible(true);
            }
            tableModel.removeRow(count - 1);
        }
    }

    class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

        }
    }

    class SaveMenuItemListener implements ActionListener {
        private BookShopSave bookShopSave = new BookShopSave();

        public void actionPerformed(ActionEvent event) {
            int count = table.getRowCount();
            int countColumns = table.getColumnCount();

            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            bookShopSave.saveBookShop(fileSave.getSelectedFile(), tableModel, count, countColumns);
        }
    }

    class LoadMenuListener implements ActionListener {
        private BookShopLoad bookShopLoad = new BookShopLoad();

        public void actionPerformed(ActionEvent event) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            bookShopLoad.loadBookShop(fileOpen.getSelectedFile(), tableModel);
        }
    }
}
