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
    public Iterable<TableModelListener> listeners;
   

    
    @Override
    public int getRowCount() {
        return DBConnection.result.size();
    }

    @Override
    public int getColumnCount() {
        int cc = 0;
        try {
            cc=DBConnection.sel.getMetaData().getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(TM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cc;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      return DBConnection.result.get(rowIndex).get(columnIndex);
    }

   
    @Override
    public void fireTableChanged(TableModelEvent tme) {
		for(TableModelListener l : this.listeners) {
			l.tableChanged(tme);
		}
	}
}
