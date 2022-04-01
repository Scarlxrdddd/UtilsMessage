package fr.scarlxrd_d.utilsmessage;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.scarlxrd_d.utilsmessage.files.DataManager;
import net.md_5.bungee.api.ChatColor;

public class CommandUtilsReload implements CommandExecutor {

	public Main main;
	public DataManager data;
	
	public CommandUtilsReload(fr.scarlxrd_d.utilsmessage.Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		main.timer = new MessageTimer(main);
		Bukkit.getScheduler().cancelTask(main.taskid);
		main.data.reloadConfig();
		int interval = main.data.getConfig().getInt("interval") * 20;
		main.taskid = main.timer.runTaskTimer(main, 0, interval).getTaskId();
        sender.sendMessage(ChatColor.RED + "[UtilsMessage] " +ChatColor.GREEN + "Reload Successful");
		return false;
	}

}
