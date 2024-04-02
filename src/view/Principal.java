package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorredor;

public class Principal {
	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1); 
		
		for(int id=1; id<=4; id++) {
			ThreadCorredor tr = new ThreadCorredor(semaforo, id); 
			tr.start();
		}
	}

}
