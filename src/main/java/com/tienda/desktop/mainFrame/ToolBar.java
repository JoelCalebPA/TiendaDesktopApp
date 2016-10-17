package com.tienda.desktop.mainFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ToolBar extends JPanel {

	public static final String VENTA = "venta";
	public static final String PRODUCTOS = "productos";
	
	private List<ActionListener> lstListeners = new ArrayList<ActionListener>();
	
	ToolBar() {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add( new Button( "Realizar Venta"  , VENTA , "venta"   ) );
        add( new Button( "Productos"  , PRODUCTOS, "producto"   ) );
		
	}
	
	public void addActionListener( ActionListener al )
    {
        if( al != null )
        {
            lstListeners.add( al );
        }
    }

    public void removeActionListener( ActionListener al )
    {
        if( al != null && lstListeners.contains( al ) )
        {
            lstListeners.remove( al );
        }
    }

    private void fireActionEvent( ActionEvent ae )
    {
        for( ActionListener al : lstListeners )
        {
            al.actionPerformed( ae );
        }
    }
	
	private final class Button extends JButton {
		
		Button(String texto, String actionCommand, String ico) {
			
			super(texto);
			setActionCommand(actionCommand);
			setFont( getFont().deriveFont( Font.BOLD, 14f ) );
            setMaximumSize( new Dimension( 220, 60 ) );
            
            addActionListener( new ActionListener()
            {
               @Override
               public void actionPerformed( ActionEvent ae )
               {
                   ToolBar.this.fireActionEvent( ae );
               }
            } );
            
		}
		
	}
	
}
