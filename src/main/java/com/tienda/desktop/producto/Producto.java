package com.tienda.desktop.producto;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import com.tienda.desktop.mainFrame.MainFrame;

@SuppressWarnings("serial")
public class Producto extends JTabbedPane {

	private ListaProductos listaProductos = new ListaProductos();
	
	public Producto () {
		
		initComponents();
		
	}
	
	public void showDialog()
    {
        JDialog dlg = new JDialog( MainFrame.getInstance() );
                dlg.setModal( true );
                dlg.setDefaultCloseOperation( JDialog.HIDE_ON_CLOSE );
                dlg.setTitle( "Lista de Productos" );
                dlg.setLayout( new BorderLayout() );
                dlg.setContentPane( this );
                dlg.pack();
                dlg.setLocationRelativeTo( MainFrame.getInstance() );
                dlg.setVisible( true );
    }
	
	private void initComponents()
    {

        add("Lista de Productos", listaProductos);   

        setSelectedIndex( 0 ); 
    }
	
}
