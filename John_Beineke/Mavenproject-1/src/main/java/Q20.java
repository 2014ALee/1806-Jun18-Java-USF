import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Q20 {

	public static void main(String[] args) {
		
		String fileName = "data.txt";
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			String fileString = (String) ois.readObject();
			System.out.println(fileString);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException ioe){
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
