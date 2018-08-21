package daomephsta.groovytest

import groovy.transform.CompileStatic
import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = GrooveTest.MODID, version = GrooveTest.MOD_VERSION, 
	acceptedMinecraftVersions = GrooveTest.MC_VERSION, dependencies = GrooveTest.DEPENDENCIES)
class GrooveTest
{
	public static final String MODID = 'groovetest', 
		NAME = 'Forgroovy', 
		MOD_VERSION = '0.0.1', 
		MC_VERSION = '1.12.2',
		DEPENDENCIES = 'required-after:forgroovy'
		
	public void preInit(FMLPreInitializationEvent event)
	{
		println Blocks.ANVIL;
	}
}
