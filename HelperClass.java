package window.copy;

import javax.swing.ImageIcon;

//import javax.swing.ImageIcon;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.jdbc.practice.ConnectionProvider;

public class Window extends Composite {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text field;
	private LocalResourceManager localResourceManager;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Window(Composite parent, int style) {
		super(parent, style);
		createResourceManager();
		
		field = formToolkit.createText(this, "New Text", SWT.NONE);
		field.setText("enter Id");
		field.setBounds(20, 10, 168, 68);
		
		CLabel imageLabel = new CLabel(this, SWT.NONE);
		imageLabel.setBounds(20, 84, 404, 195);
		formToolkit.adapt(imageLabel);
		formToolkit.paintBordersFor(imageLabel);
		imageLabel.setText("");

		
		Button button = formToolkit.createButton(this, "Image get", SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				String str = field.getText();
				int id = Integer.parseInt(str);
				ImageIcon icon = HelperClass.getImageIconById(id, ConnectionProvider.getConnection());
				imageLabel.setIcon(icon);
				
				
				
				
			}
		});
		button.setImage(localResourceManager.create(ImageDescriptor.createFromFile(Window.class, "/icons/progress/ani/7@2x.png")));
		button.setBounds(223, 10, 205, 68);
		
		
	}
	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(),this);
	}
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, false));
		Window w1 = new Window(shell, SWT.NONE);

		

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
