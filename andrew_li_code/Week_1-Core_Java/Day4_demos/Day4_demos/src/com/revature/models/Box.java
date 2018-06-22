package com.revature.models;



public class Box implements Comparable<Box> {
	private int volume;

	public Box(int volume) {
		super();
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Box [volume=" + volume + "]";
	}

	@Override
	public int compareTo(Box theBox) {
		if (volume < theBox.volume) {
			return -1;
		} else if (volume > theBox.volume) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
