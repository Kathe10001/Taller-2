package logica;

public class Monitor {

	private int lectores;
	private boolean escribiendo;

	public Monitor() {
		this.lectores = 0;
		this.escribiendo = false;
	}

	public synchronized void comienzoLectura() {
		while(escribiendo){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		lectores++;
	}

	public synchronized void terminoLectura() {
		lectores--;
	    notify();
	}


	public synchronized void comienzoEscritura() {
	    while(lectores > 0 || escribiendo){
    		try {
	  			wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    escribiendo = true;
	}

	public synchronized void terminoEscritura() {
		escribiendo = false;
	    notify();
	}

}
