/**
* @author Kyle Ratti
* @version 1.0, 07/11/14
*/

package me.ratti.kyle.utilx.cli;

/** Provides a command line interface */
public class CLI {
	private final String name;
	private boolean running;

	public CLI(String strName) {
		this.name = strName;
		this.running = false;
	}

	public String getName() {
		return this.name;
	}

	public void start() {
		this.running = true;

		while(this.running) {
			//
		}
	}

	public void stop() {
		this.running = false;
	}
}