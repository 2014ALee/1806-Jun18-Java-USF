package ers.run.models;

import java.util.ArrayList;

public class UserReimbursments {
	
	private User user;
	private ArrayList<Reimbursment> reim;
	
	UserReimbursments() {}

	public UserReimbursments(User user, ArrayList<Reimbursment> reim) {
		super();
		this.user = user;
		this.reim = reim;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Reimbursment> getReim() {
		return reim;
	}

	public void setReim(ArrayList<Reimbursment> reim) {
		this.reim = reim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reim == null) ? 0 : reim.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserReimbursments other = (UserReimbursments) obj;
		if (reim == null) {
			if (other.reim != null)
				return false;
		} else if (!reim.equals(other.reim))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserReimbursments [user=" + user + ", reim=" + reim + "]";
	}

	
	
}
