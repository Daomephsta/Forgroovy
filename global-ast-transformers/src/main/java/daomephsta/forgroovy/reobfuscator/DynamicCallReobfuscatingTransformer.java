package daomephsta.forgroovy.reobfuscator;

import java.io.*;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;

public class DynamicCallReobfuscatingTransformer implements ASTTransformation
{

	@Override
	public void visit(ASTNode[] nodes, SourceUnit source)
	{
		String nameLast = source.getName();
		
		try(Writer w = new FileWriter(nameLast + ".ASTTEST"))
		{
			w.write(nodes.length);
			w.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
