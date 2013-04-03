/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Администратор
 */
public class TM extends AbstractTableModel {
    //public Iterable<TableModelListener> listeners;
 //   DBConnection DBC=new DBConnection();
    public ArrayList<ArrayList> result;
    public ArrayList ColumName;
    public TM(ArrayList<ArrayList> data,ArrayList ColumName){
        result=data;
        this.ColumName=ColumName;
    
    }
            
    @Override
    public int getRowCount() {
        return result.size();
    }

    @Override
    public int getColumnCount() {        
         return  result.size()==0 ? 0 : result.get(0).size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       this.fireTableDataChanged();
      return result.get(rowIndex).get(columnIndex);
    }

   
    
    @Override
    public String getColumnName(int column) {
        return ColumName.get(column).toString();
    }
    

    
}

