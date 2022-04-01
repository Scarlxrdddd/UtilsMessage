package fr.scarlxrd_d.utilsmessage;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.scarlxrd_d.utilsmessage.files.DataManager;


public class Main extends JavaPlugin {
	public List<String> site;
	public List<String> discord;
	public DataManager data;
	public MessageTimer timer;
	public int taskid;

	@Override
	public void onEnable() {
		
		this.data = new DataManager(this);
		if (!new File(getDataFolder(), "config.yml").exists())
            saveDefaultConfig();

        int interval = data.getConfig().getInt("interval") * 20;

        timer = new MessageTimer(this);
        taskid = timer.runTaskTimer(this, 0, interval).getTaskId();
        getCommand("site").setExecutor(new CommandSite(this));
        getCommand("discord").setExecutor(new CommandDiscord(this));
        getCommand("utilsreload").setExecutor(new CommandUtilsReload(this));
        int pluginId = 14763; // <-- Replace with the id of your plugin!
        
        
            Metrics metrics = new Metrics(this, pluginId);
            metrics.addCustomChart(new Metrics.SingleLineChart("players", new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    // (This is useless as there is already a player chart by default.)
                    return Bukkit.getOnlinePlayers().size();
                }
            }));
        
        	
        System.out.println("UtilsMessage - s/o Thomas");
        
	}
	
	
	
	@Override
	public void onDisable() {
		System.out.println("UtilsMessage [X]");
	}

}
