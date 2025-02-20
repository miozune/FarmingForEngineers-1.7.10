package com.guigs44.farmingforengineers.network;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.guigs44.farmingforengineers.client.gui.GuiMarket;
import com.guigs44.farmingforengineers.container.ContainerMarket;
import com.guigs44.farmingforengineers.container.ContainerMarketClient;
import com.guigs44.farmingforengineers.tile.TileMarket;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int MARKET = 1;

    @Override
    @Nullable
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == MARKET) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity instanceof TileMarket) {
                return new ContainerMarket(player, x, y, z);
            }
        }
        return null;
    }

    @Override
    @Nullable
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == MARKET) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity instanceof TileMarket) {
                return new GuiMarket(new ContainerMarketClient(player, x, y, z));
            }
        }
        return null;
    }
}
