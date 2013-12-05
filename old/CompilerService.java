/**
* @author Kyle Ratti (PC18)
* @version 1.0, 11/11/13
*/

package utilx;

/** A template to enable applications to be run through the utilx Compiler */
public interface CompilerService
{
	/**
	* A base method to enable command line applications to be run via the compiler<br/>
	* <br/>
	* Implement "main(args);" in the method
	*/
	public void run(String[] args);
}