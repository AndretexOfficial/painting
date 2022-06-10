package space.andretex.paints.events;

import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import space.andretex.paints.Main;

public class PlayerInterract implements Listener {
    FileConfiguration config;

    private Main plugin;
    public PlayerInterract(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPaint(PlayerInteractEvent event) {
        if(!event.hasItem())
            return;

        if (!event.getItem().getType().isBlock())
            return;

        if(!plugin.hasPainters())
            return;
        if (!plugin.getPainters().contains(event.getPlayer()))
            return;
        if (event.getPlayer().rayTraceBlocks(50) == null)
            return;

        //THEY ARE A PAINTER
        event.setCancelled(true);

        Block block = event.getPlayer().rayTraceBlocks(50).getHitBlock();
        block.setType(event.getItem().getType());

    }
}
