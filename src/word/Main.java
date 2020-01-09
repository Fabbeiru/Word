package word;

/**
 *
 * @author Fabián B.
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class Main extends JFrame {
    private static final String[][] toolbars = {
        {"new","open","save","print","cut","copy","paste"}
    };
    private Map<String, Command> commands;
    private ToolbarUpdater toolbarUpdater;

    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        setTitle("Word");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        createToolbarUpdater();
        add(toolbar(0), BorderLayout.NORTH);
    }
    
    private void execute() {
        this.commands = CommandFactory.instance().build();
        this.toolbarUpdater.run();
        setVisible(true);
    }

    private JComponent toolbar(int index) {
        JPanel toolbar = new JPanel();
        for (String id : toolbars[index])
            toolbar.add(button(id));
        return toolbar;
    }

    private JComponent button(String id) {
        JButton button = new JButton(id);
        button.setName(id);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(id).execute();
                toolbarUpdater.run();
            }
        });
        return toolbarUpdater.add(button);
    }

    private void createToolbarUpdater() {
        toolbarUpdater = new ToolbarUpdater();
    }

    public class ToolbarUpdater {

        private List<JComponent> components = new ArrayList<>();

        protected void run() {
            for (JComponent component : components) {
                Command command = commands.get(component.getName());
                component.setEnabled(command.isEnabled());
            }
        }

        JComponent add(JComponent component) {
            components.add(component);
            return component;
        }

    }    
       
}