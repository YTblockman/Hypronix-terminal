package hypronix.dev;

import com.sline.setup.Setup;
import hypronix.dev.commands.presence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sender implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        presence.setState(Setup.getStringFromInBar(2));
        presence.setDetails(Setup.getStringFromInBar(3));
        presence.reload();
    }
}
