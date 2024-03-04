package window.copy;

import java.awt.Image;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class HelperClass {
	public static ImageIcon getImageIconById(int id, Connection con) {
		ImageIcon icon = null;
		
		
		try {
			
			
			String q = "select pic form images where id=?";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setInt(1,id);
			
			ResultSet set = pstmt.executeQuery();
			
			if(set.next()) {
				Blob b = set.getBlob("pic");
				
				InputStream is = b.getBinaryStream();
				
				Image image = ImageIO.read(is);
				
				icon = new ImageIcon(image);
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return icon;
		
	}
}
