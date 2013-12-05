/**
* @author Kyle Ratti (PC18)
* @version 1.0, 11/11/13
*/

package utilx;

import utilx.CompilerResults;

import java.util.Arrays;
import java.util.Locale;

import java.net.URLClassLoader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;

import java.io.IOException;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/** Provides an interface for compiling Java files (mostly borrowed code from <a href="http://www.accordess.com/wpblog/an-overview-of-java-compilation-api-jsr-199/" target="_blank">http://www.accordess.com/wpblog/an-overview-of-java-compilation-api-jsr-199/</a>) */
public class Compiler
{
	private static final String[] compileOptions = new String[]{};
	private JavaCompiler compiler;

	public Compiler()
	{
		// System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_45");
		// this.compiler = ToolProvider.getSystemJavaCompiler();
	}

	/**
	* Attempts to compile a Java file
	*
	* @param strFile The .java file to attempt to compile
	* @return true, if the compile finished without errors
	*/
	public CompilerResults compile(String strFile)
	{
		System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_45");
		this.compiler = ToolProvider.getSystemJavaCompiler();

		SimpleJavaFileObject objFile = new DynamicJavaSourceCode(strFile, new FileIO(strFile));
		JavaFileObject objFileObjects[] = new JavaFileObject[] {objFile};

		if(this.compiler == null)
		{
			throw new RuntimeException("Unable to locate Java compiler");
		}

		StandardJavaFileManager objFileManager = this.compiler.getStandardFileManager(null, Locale.getDefault(), null);

		Iterable<? extends JavaFileObject> objCompilationUnits = Arrays.asList(objFileObjects);
		Iterable<String> objCompileOptions = Arrays.asList(Compiler.compileOptions);

		DiagnosticCollector<JavaFileObject> objDiagnostics = new DiagnosticCollector<JavaFileObject>();

		CompilationTask objCompilerTask = this.compiler.getTask(
			null,
			objFileManager,
			objDiagnostics,
			objCompileOptions,
			null,
			objCompilationUnits
		);

		long lgStart = System.currentTimeMillis();
		boolean bSuccess = objCompilerTask.call();
		CompilerResults objResults = new CompilerResults(bSuccess, lgStart);

		if(!objResults.successful())
		{
			for(Diagnostic objDiagnostic : objDiagnostics.getDiagnostics())
			{
				objResults.addError(objDiagnostic.getLineNumber(), objDiagnostic.getColumnNumber(), objDiagnostic.getMessage(Locale.getDefault()));
				//System.out.printf("Error on line %d in %s\n", objDiagnostic.getLineNumber(), objDiagnostic);
			}
		}

		try
		{
			objFileManager.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		return objResults;
	}

	/**
	* Attempt to run a compiled Java file
	*
	* @param objFile The file to attempt to run
	*/
	public void run(FileIO objFile)
	{
		String strAbsolutePath = objFile.getAbsolutePath();
		String strFullName = objFile.getFilename(true);
		URL objURL = null;

		try
		{
			objURL = new URL("file:///" + strAbsolutePath.substring(0, strAbsolutePath.lastIndexOf(strFullName)));
		}
		catch(MalformedURLException e)
		{
			Prompt.println("Error formatting URL");
			return;
		}

		URLClassLoader objLoader = new URLClassLoader(new URL[]{
			objURL
		});

		String strName = objFile.getFilename();
		CompilerService objService = null;

		try
		{
			objService = (CompilerService) Class.forName(strName, true, objLoader).newInstance();
		}
		catch(ClassNotFoundException e)
		{
			Prompt.println("Class not found!");
			return;
		}
		catch(InstantiationException e)
		{
			Prompt.println("What am I?");
			return;
		}
		catch(IllegalAccessException e)
		{
			Prompt.println("Illegal to access my exception foo");
			return;
		}

		objService.run(new String[]{});
	}
}

class DynamicJavaSourceCode extends SimpleJavaFileObject
{
	private String qualifiedName;
	private FileIO file;

	protected DynamicJavaSourceCode(String strQualifiedName, FileIO objFile)
	{
		//super(URI.create("string:///" + strQualifiedName.replaceAll("\\.", "/") + Kind.SOURCE.extension), Kind.SOURCE);
		super(URI.create("string:///" + strQualifiedName), Kind.SOURCE);
		this.qualifiedName = strQualifiedName;
		this.file = objFile;
	}

	@Override
	public CharSequence getCharContent(boolean bIgnoreEncodingErrors) throws IOException
	{
		return this.file.getContents();
	}

	public String getQualifiedName()
	{
		return this.qualifiedName;
	}

	public void setQualifiedName(String strQualifiedName)
	{
		this.qualifiedName = strQualifiedName;
	}

	public String getSourceCode()
	{
		return this.file.getContents();
	}
}