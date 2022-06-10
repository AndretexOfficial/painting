package space.andretex.paints.commands;
//reload

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import space.andretex.paints.Main;

public class Paintr implements CommandExecutor {
    private Main plugin;
    public Paintr(Main plugin) {
        this.plugin = plugin;
    }

    FileConfiguration config;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Reloading.");
            try{
                Thread.sleep(1000);
            }catch (Exception err) {}
            sender.sendMessage("Reloading..");
            try{
                Thread.sleep(1000);
            }catch (Exception err) {}
            sender.sendMessage("Realoading...");
            try{
                Thread.sleep(1000);
            }catch (Exception err) {}
            plugin.reloadConfig();
            try{
                Thread.sleep(5000);
            }catch (Exception err) {}

            sender.sendMessage("Reloaded!!");
        }

        if(sender instanceof Player) {
            sender.sendMessage("Reloading.");
            try{
                Thread.sleep(1000);
            }catch (Exception err) {}
            sender.sendMessage("Reloading..");
            try{
                Thread.sleep(1000);
            }catch (Exception err) {}
            sender.sendMessage("Realoading...");
            try{
                Thread.sleep(1000);
            }catch (Exception err) {}
            plugin.reloadConfig();
            try{
                Thread.sleep(5000);
            }catch (Exception err) {}

            sender.sendMessage("Reloaded!!");
        }
        return true;
    }
}
