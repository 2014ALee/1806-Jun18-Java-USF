package com.revature.models;

import java.util.Date;

public class Employee {
	
	private int id;
	private String name;
	private String role;
	private Date inserTime;
	
	public Employee() {}

	public Employee(int id, String name, String role, Date inserTime) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.inserTime = inserTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getInserTime() {
		return inserTime;
	}

	public void setInserTime(Date inserTime) {
		this.inserTime = inserTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((inserTime == null) ? 0 : inserTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (inserTime == null) {
			if (other.inserTime != null)
				return false;
		} else if (!inserTime.equals(other.inserTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", inserTime=" + inserTime + "]";
	}
	
	
}
