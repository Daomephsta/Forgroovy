package daomephsta.groovetest

import net.minecraftforge.fml.common.Mod

@Mod(modid = GrooveTest.MODID, version = GrooveTest.MOD_VERSION, 
	acceptedMinecraftVersions = GrooveTest.MC_VERSION, dependencies = GrooveTest.DEPENDENCIES)
class GrooveTest
{
	public static final String MODID = 'groovetest', 
		NAME = 'Forgroovy', 
		MOD_VERSION = '0.0.1', 
		MC_VERSION = '1.12.2',
		DEPENDENCIES = 'required-after:forgroovy'
}
