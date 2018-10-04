package dal;

import java.awt.Desktop;
import java.io.File;

public class Task3Dal {
	
	public void openFile(String name) throws Exception {
		String path = "C:\\Users\\Administrator\\eclipse-workspace\\database-programming\\src\\office\\";
		File filePath = new File(path + name);
		Desktop.getDesktop().open(filePath);
	}
}
