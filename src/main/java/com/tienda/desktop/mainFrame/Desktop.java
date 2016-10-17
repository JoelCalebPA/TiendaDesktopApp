package com.tienda.desktop.mainFrame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;

public class Desktop extends JDesktopPane {

	Desktop()
    {
        setMinimumSize( new Dimension( 580, 380 ) );
        setBorder( new LineBorder( Color.black, 2, true ));
    }
	
}
