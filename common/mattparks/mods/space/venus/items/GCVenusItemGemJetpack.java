package mattparks.mods.space.venus.items;

import mattparks.mods.space.venus.GCVenus;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusItemGemJetpack extends ItemArmor
{
	public boolean active;
    public boolean attachedMask;
    private final EnumArmorMaterial material;

    public GCVenusItemGemJetpack(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, boolean breathable)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
		this.setMaxStackSize(1);
		this.setMaxDamage(612);
        this.material = par2EnumArmorMaterial;
        this.attachedMask = breathable;
    }
    
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
        if (this.material == GCVenusItems.ARMORGEMJETPACK)
        {
            if (stack.getItem().itemID == GCVenusItems.gemJetpack.itemID)
            {
                return "textures/model/armor/redGemJetpack.png";
            }
        }

        return null;
    }

	@Override
    public CreativeTabs getCreativeTab()
    {
        return GCVenus.galacticraftVenusTab;
    }

    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) 
    {
    	if (entity instanceof EntityPlayer)
    	{
    		final EntityPlayer player = (EntityPlayer) entity;
    		
    		if (GCVenus.tick % 100 == 0)
    		{
    			if (!player.capabilities.isCreativeMode)
    			{
        			player.inventory.consumeInventoryItem(Item.coal.itemID);
    			}
    		}
    	}
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", "galacticraftvenus:"));
    }

    public void setActive()
	{
		this.active = true;
	}

    @Override
    public Item setUnlocalizedName(String par1Str)
    {
        super.setTextureName(par1Str);
        super.setUnlocalizedName(par1Str);
        return this;
    }
}
