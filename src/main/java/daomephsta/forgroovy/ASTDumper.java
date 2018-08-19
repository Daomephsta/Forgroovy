package daomephsta.forgroovy;

import java.io.*;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
public class ASTDumper implements ASTTransformation
{
	private SourceUnit sourceUnit;
	private boolean started = false;
	private Writer w;

	@Override
	public void visit(ASTNode[] nodes, SourceUnit source)
	{
		try
		{
			if (!started)
			{
				w = new FileWriter("ASTDump.txt");
				started = true;
			}
			if (sourceUnit != source)
			{
				sourceUnit = source;
				w.write(System.lineSeparator());
				w.write(sourceUnit.getName());
			}
			for (ASTNode node : nodes)
			{
				w.write(node.getClass() + ": " + node.getText());
			}
			w.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
