import javax.swing.table.AbstractTableModel;

/**
 * Created by Sensei on 28.12.2014.
 */
public class MyTableModel extends AbstractTableModel {
    private String[] columnNames = {"Book title",
            "Author",
            "Year of out",
            "Publisher",
            "Price in usd"};

    /*private Object[][] data = {
            {"Lord Of The Rings", "Tolkien",
                    "1954", "Great books", 20},
            {"Alice in Wonderland", "Lewis Carroll",
                    "1865", "Books are never old", 15},
            {"Treasure Island", "Robert Louis Stevenson",
                    "1883", "Good old books", 10}
    };*/

    private Object[][] data = {
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
            " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "},
            {" ", " ",
                    " ", " ", " "}
    };

    public int getColumnCount(){
        return columnNames.length;
    }

    public int getRowCount(){
       return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        if (row < 1) {
            return false;
        } else {
            return true;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
