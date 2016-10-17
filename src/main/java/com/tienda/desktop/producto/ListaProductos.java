package com.tienda.desktop.producto;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.caleb.dao.ProductoDAOImpl;
import com.caleb.entity.Producto;

@SuppressWarnings("serial")
public class ListaProductos extends JPanel {
	
	private Object[][] data = null;
	private String[] title = { "Producto", "Precio", "Stock"};
	private DefaultTableModel tableModel = new DefaultTableModel(data, title);
	private JTable table = new JTable();
	private JScrollPane scrollPane = new JScrollPane();
	private ProductoDAOImpl dao = new ProductoDAOImpl();
	
	public ListaProductos() {
		initComponents();
	}
	
	private void initComponents() {
		table.setModel(tableModel);
		scrollPane.setPreferredSize(new Dimension(800, 500));
		scrollPane.setViewportView(table);
		add(scrollPane);
		for (Producto p : dao.listarProductos()) {
			Object[] rowData = { p.getDescripcion(), p.getPrecio(), p.getStock() };
			tableModel.addRow(rowData);
		}
		setVisible(true);
	}

}
