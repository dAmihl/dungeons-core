package at.gousoogames.dungeons.core.gui.console;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JTextField;

public class TextFieldInputStream extends InputStream {

	byte[] contents = null;
	int pointer = 0;

	JTextField textField;
	
    public TextFieldInputStream(final JTextField text) {
    	
    	this.textField = text;
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar()=='\n'){
                    contents = text.getText().getBytes();
                    pointer = 0;
                    text.setText("");
                }
                super.keyReleased(e);
            }
        });
    }
    
    

    @Override
    public int read() throws IOException {
    	if (contents == null) return -1;
        if(pointer >= contents.length) {
        	return -1;
        }
        return this.contents[pointer++];	
    }

}
