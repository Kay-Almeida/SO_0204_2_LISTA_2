package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread{
	
	int id; 
	private Semaphore semaforo; 
	
	public ThreadCorredor (Semaphore semaforo, int id) {
		this.id = id; 
		this.semaforo = semaforo; 
	}
	
	public void run() {
		int distanciatotal = 200;
		int distancia = (int) ((Math.random()*2)+4);
		int distanciapercorrida = 0;

		int metros = 0; 
		int tempo = 1000;
		
		while(distanciapercorrida<=distanciatotal) {
			distanciapercorrida = distanciapercorrida + distancia; 
			
			if(distanciapercorrida>=metros) {
				System.out.println("A pessoa do corredor "+ id+ " andou "+ distanciapercorrida+ " metros");
				metros= metros + 50; 
			}
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
		int tempo2 = (int) ((Math.random()*1001)+1000); 
		try {
			semaforo.acquire();
			System.out.println("A pessoa do corredor "+ id+ " chegou a porta");
			sleep(tempo2); 
			System.out.println("A pessoa do corredor "+ id+ " cruzou a porta");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		
	}

}
