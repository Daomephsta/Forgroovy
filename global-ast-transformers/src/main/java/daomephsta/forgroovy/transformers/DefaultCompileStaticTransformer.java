package daomephsta.forgroovy.transformers;

import org.codehaus.groovy.ast.*;
import org.codehaus.groovy. control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.AbstractASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

import groovy.transform.CompileDynamic;
import groovy.transform.CompileStatic;

@CompileStatic
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS) // Must be run at this phase for added transformer annotations to have an effect
public class DefaultCompileStaticTransformer extends AbstractASTTransformation
{
	private static final ClassNode COMPILE_STATIC_CLASS_NODE = ClassHelper.make(CompileStatic.class);
	private static final ClassNode COMPILE_DYNAMIC_CLASS_NODE = ClassHelper.make(CompileDynamic.class);
	
	@Override
	public void visit(ASTNode[] nodes, SourceUnit source)
	{
		for (ClassNode classNode : source.getAST().getClasses())
		{
			if (!hasAnnotation(classNode, COMPILE_DYNAMIC_CLASS_NODE))
			{
				AnnotationNode staticCompileAnn = new AnnotationNode(COMPILE_STATIC_CLASS_NODE);
				classNode.addAnnotation(staticCompileAnn);
			}
		}
	}
}
