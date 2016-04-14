package net.darkhax.darkutils.tileentity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.chunk.Chunk;

public class TileEntityAntiSlime extends TileEntity {
    
    public boolean shareChunks (EntityLivingBase entity) {
        
        Vec3d entPos = entity.getPositionVector();
        BlockPos blockpos = new BlockPos(MathHelper.floor_double(entPos.xCoord), 0, MathHelper.floor_double(entPos.zCoord));
        Chunk chunk = entity.worldObj.getChunkFromBlockCoords(blockpos);
        Chunk tileChunk = this.worldObj.getChunkFromBlockCoords(this.pos);
        return (chunk.xPosition == tileChunk.xPosition && chunk.zPosition == tileChunk.zPosition);
    }
}