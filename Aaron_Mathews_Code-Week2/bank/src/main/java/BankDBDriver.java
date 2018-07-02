import java.sql.Connection;

import com.revature.util.ConnectionFactory;

public class BankDBDriver {
	
	public static void main(String[] args) {
		
		Connection conn = ConnectionFactory.getInstance().getConnection();
		
		
	}

}
