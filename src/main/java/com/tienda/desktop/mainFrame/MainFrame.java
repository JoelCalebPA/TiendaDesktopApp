package com.tienda.desktop.mainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tienda.desktop.producto.Producto;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	private static MainFrame instance;

	private ToolBar toolBar;
	private Desktop desktop;

	private MainFrame() {
		setTitle("Sistema de Administración de Tienda");
		setPreferredSize(new Dimension(1280, 720));
		initComponents();
	}

	public static MainFrame getInstance() {
		synchronized (MainFrame.class) {
			if (instance == null) {
				instance = new MainFrame();
			}
		}
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sAction = e.getActionCommand();

		if (sAction.equals(ToolBar.VENTA))
			onVenta();
		else if (sAction.equals(ToolBar.PRODUCTOS))
			onProductos();
	}
	
	private void onVenta() {
		
	}
	
	private void onProductos() {
		new Producto().showDialog();
	}

	private void initComponents()
    {
		desktop = new Desktop();
		toolBar = new ToolBar();
		toolBar.addActionListener( this );

        JPanel pnlAll = new JPanel();
               pnlAll.setBorder( new EmptyBorder( 5, 8, 5, 8 ) );
               pnlAll.setLayout( new BorderLayout( 0, 9 ) );
               pnlAll.add( toolBar, BorderLayout.NORTH );
               pnlAll.add( desktop, BorderLayout.CENTER );

       setLayout( new BorderLayout() );
       setContentPane( pnlAll );
    }
	
}
