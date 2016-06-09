import javax.swing.UIManager;


public class main {
	 public static void main(String[] arguments) {
		try { 
			    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			    e.printStackTrace();
			}
         mainFrame frame = new mainFrame();
         model m = new model();
         Register r = new Register();
         Controller c = new Controller(frame, m, r);
         frame.setVisible(true);

         r.setVisible(true);

 }

}
