package com.revature.models;

public class Box implements Comparable<Box> {
	
	private double volume;
	private String color;
	
	public Box() {}

	public Box(double volume, String color) {
		super();
		this.volume = volume;
		this.color = color;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Box other = (Box) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		return true;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int compareTo(Box theBox) {
		if(this.volume - theBox.volume > 0)
		{
			return 1;
		}
		else if(this.volume - theBox.volume < 0)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

}
