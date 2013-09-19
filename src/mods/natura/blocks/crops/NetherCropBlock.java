package mods.natura.blocks.crops;

import mods.natura.common.NaturaTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class NetherCropBlock extends CropBlock
{
    protected NetherCropBlock(int id)
    {
        super(id);
        this.setTickRandomly(true);
        float var3 = 0.5F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
        this.setCreativeTab((CreativeTabs) null);
        this.setHardness(0.0F);
        this.setStepSound(soundGrassFootstep);
        this.disableStats();
        this.setCreativeTab(NaturaTab.tab);
    }

    @Override
	boolean requiresSun (int meta)
    {
        return false;
    }

    @Override
    public int getPlantMetadata (World world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z);
    }

    @Override
    public EnumPlantType getPlantType (World world, int x, int y, int z)
    {
		return EnumPlantType.Nether;
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    @Override
	public boolean canBlockStay (World par1World, int x, int y, int z)
    {
        Block soil = blocksList[par1World.getBlockId(x, y - 1, z)];
		return soil.blockMaterial == Material.ground;
    }
}
