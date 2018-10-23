package br.cefetmg.vitor.node_management.core;

import java.awt.MouseInfo;

import br.cefetmg.vitor.node_management.Constants;

public class VerifyIdleThread implements Runnable {
	
	private int[] lastPosition;
	private long lastTimeUpdate;
	
	public VerifyIdleThread() {
		lastPosition = new int[2];
		lastTimeUpdate = System.currentTimeMillis();
	}
	
	public boolean isIdle() {
		return (System.currentTimeMillis() - lastTimeUpdate) >= Constants.IDLE_TIME;
	}


	@Override
	public void run() {
		int xPosition = MouseInfo.getPointerInfo().getLocation().x;
		int yPosition = MouseInfo.getPointerInfo().getLocation().y;
		
		if (xPosition != lastPosition[0] || yPosition != lastPosition[1]) {
			lastPosition[0] = xPosition;
			lastPosition[1] = yPosition;
			lastTimeUpdate = System.currentTimeMillis();
		}
	}

}
