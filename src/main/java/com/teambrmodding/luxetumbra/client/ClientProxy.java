package com.teambrmodding.luxetumbra.client;

import com.teambrmodding.luxetumbra.common.CommonProxy;
import com.teambrmodding.luxetumbra.documentation.Documentation;
import com.teambrmodding.luxetumbra.events.RenderEvents;
import com.teambrmodding.luxetumbra.manager.BlockManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraftforge.common.MinecraftForge;

import static com.teambrmodding.luxetumbra.client.ItemRenderManager.registerBlockModel;

/**
 * This file was created for Lux-et-Umbra-Redux
 * <p>
 * Lux-et-Umbra-Redux is licensed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 *
 * @author Dyonovan
 * @since 10/3/2016
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        ItemRenderManager.registerBlockRenderers();
    }

    @Override
    public void init() {
        ItemRenderManager.registerItemRenderers();
        Documentation.init();
        KeybindHandler.getInstance().registerBindings();
    }

    @Override
    public void postInit() {
        MinecraftForge.EVENT_BUS.register(new RenderEvents());
        IReloadableResourceManager manager = (IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager();
        manager.registerReloadListener(new RenderEvents());
        MinecraftForge.EVENT_BUS.register(KeybindHandler.getInstance());
    }
}
