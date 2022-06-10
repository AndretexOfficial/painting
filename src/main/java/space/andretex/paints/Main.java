package space.andretex.paints;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import space.andretex.paints.commands.PaintCommand;
import space.andretex.paints.commands.Paintr;
import space.andretex.paints.events.PlayerInterract;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {
    private List<Player> painters = new ArrayList<Player>();
    FileConfiguration config;

    World world;

    @Override
    public void onEnable() {
        this.getCommand("paint").setExecutor(new PaintCommand(this));
        this.getCommand("paintr").setExecutor(new Paintr(this));
        this.getServer().getPluginManager().registerEvents(new PlayerInterract(this), this);
        createWorld();
        saveDefaultConfig();
        System.out.println(ChatColor.GREEN + "ENABLED");
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "DISABLED");
    }

    public void createWorld() {
        WorldCreator c = new WorldCreator("Painter");
        c.type(WorldType.FLAT);

        c.generateStructures(false);
        world = c.createWorld();
    }

    public void addPainter(Player player) {
        painters.add(player);
    }

    public void removePainter(Player player) {
        painters.remove(player);
    }

    public List<Player> getPainters() {
        return painters;
    }

    public boolean hasPainters() {
        if (painters.isEmpty())
            return false;
        return true;
    }
}
