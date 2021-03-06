package mattparks.mods.space.io.client;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.client.FMLClientHandler;

public class GCIoSounds
{
	@ForgeSubscribe
	public void onMusicSound(PlayBackgroundMusicEvent event)
	{
		final Minecraft mc = FMLClientHandler.instance().getClient();

		if (mc.thePlayer != null && mc.thePlayer.worldObj != null && mc.thePlayer.worldObj.provider instanceof IGalacticraftWorldProvider)
		{
			final int randInt = FMLClientHandler.instance().getClient().thePlayer.worldObj.rand.nextInt(ClientProxyIo.newMusic.size() + 2);

			if (randInt < ClientProxyIo.newMusic.size())
			{
				event.result = ClientProxyIo.newMusic.get(randInt);
			}
		}
	}
}
