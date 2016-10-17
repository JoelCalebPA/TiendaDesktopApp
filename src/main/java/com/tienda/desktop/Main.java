package com.tienda.desktop;

import java.awt.EventQueue;

import com.caleb.util.HibernateUtil;
import com.tienda.desktop.mainFrame.MainFrame;

public class Main {

	public static void main(String[] args) {
		
		final MainFrame frame = MainFrame.getInstance();
		frame.pack();
		EventQueue.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                frame.setVisible( true );
                frame.requestFocus();
                frame.setLocationRelativeTo(null);
            }
        } );
		final Thread dbThread = new Thread() {
			
			@Override
			public void run() {
				HibernateUtil.getSessionFactory();
			}
		};
		dbThread.start();
	}

}
