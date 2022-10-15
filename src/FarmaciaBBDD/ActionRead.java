package FarmaciaBBDD;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class ActionRead extends JFrame{
	
	private Connection conexion;
	private ResultSet sql;
	private Statement state;
	private TablaSeleccionada tablaResulset;
	private JTable tabla;
	private JPanel lamina;
	private JButton regresar;
	
	public ActionRead() {
		
		setTitle("Leer Elementos");
		setBounds(400, 200, 700, 500);	
		Index index= new Index();
		index.setVisible(false);
		setLayout(new BorderLayout());
		
		lamina= new JPanel(new GridLayout(1,0));
		regresar= new JButton("Regresar");
		regresar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				index.setVisible(true);
				setVisible(false);
			}
		});
	
		try {
			
			conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			
			state= conexion.createStatement();
			sql= state.executeQuery("SELECT * FROM medicamentos");
			
			tablaResulset=new TablaSeleccionada(sql);			
			tabla= new JTable(tablaResulset);
			
			lamina.add(new JScrollPane(tabla));
			add(lamina);
			add(regresar, BorderLayout.SOUTH);
			
			validate();  //para que imprima o escriba la tabla

			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	
}
class TablaSeleccionada extends AbstractTableModel{
	
	public TablaSeleccionada(ResultSet result) {
		
		sql=result;
		
		try {
			sqlMeta= (ResultSetMetaData) sql.getMetaData();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int getRowCount() {
		
		try {
			sql.last();									//para ir al final de los registros	
			return sql.getRow();						//para saber cuantas filas tiene la tabla
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	}

	public int getColumnCount() {
	
		try {
			return sqlMeta.getColumnCount();			//para saber cuantas columnas tiene la tabla
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			sql.absolute(rowIndex + 1);
			
			return sql.getObject(columnIndex + 1);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public String getColumnName(int x) {
		try {
			return sqlMeta.getColumnName(x + 1);			
		
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
	}
	
	
	private ResultSet sql;
	private ResultSetMetaData sqlMeta;
	
}


