package net.minecraft.server;

public class BlockBarrier extends Block {

    protected BlockBarrier() {
        super(Material.BANNER);
        this.v();
        this.b(6000001.0F);
        this.J();
        this.t = true;
    }

    public int b() {
        return -1;
    }

    public boolean c() {
        return false;
    }

    public void dropNaturally(World world, BlockPosition blockposition, IBlockData iblockdata, float f, int i) {}
}
