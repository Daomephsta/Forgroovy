package daomephsta.forgroovy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Forge {@link ILanguageAdapter} for Groovy support
 * @author Daomephsta
 */
public class GroovyLanguageAdapter implements ILanguageAdapter
{
	@Override
	public Object getNewInstance(FMLModContainer container, Class<?> objectClass, ClassLoader classLoader, Method factoryMarkedMethod)
		throws Exception
	{
		return factoryMarkedMethod != null ? factoryMarkedMethod.invoke(null) : objectClass.newInstance(); 
	}

	@Override
	public boolean supportsStatics()
	{
		return true;
	}

	@Override
	public void setProxy(Field target, Class<?> proxyTarget, Object proxy) throws IllegalArgumentException,
		IllegalAccessException, NoSuchFieldException, SecurityException
	{
		target.set(null, proxy);
	}

	@Override
	public void setInternalProxies(ModContainer mod, Side side, ClassLoader loader)
	{
		// Nothing to do
	}
}
