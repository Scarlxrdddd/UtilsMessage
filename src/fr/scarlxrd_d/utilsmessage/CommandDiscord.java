package fr.scarlxrd_d.utilsmessage;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDiscord implements CommandExecutor {
	
	 private Main main;
	 
	 public CommandDiscord (Main plugin) {
		 this.main = plugin;
		}
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		String message = "";
		if(!main.data.getConfig().getBoolean("discord")) {
			if(sender instanceof Player) {
			    Player player = (Player) sender;
				player.sendMessage("This command is not set on TRUE. Check config.yml");
				}
		} else {
			if(sender instanceof Player) {
				message = main.data.getConfig().getStringList("linkdiscord").get(0);
				Player player = (Player) sender;			
				player.sendMessage(message);
			}
		}
		
		return false;
	}

}
