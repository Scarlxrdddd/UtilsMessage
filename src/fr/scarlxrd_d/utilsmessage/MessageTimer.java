package fr.scarlxrd_d.utilsmessage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class MessageTimer extends BukkitRunnable
{
	
	public Main main;
    private int lastMessage;
    
    public MessageTimer(Main plugin)
    {
    	this.main = plugin;
    }
    
    @Override
    public void run()
    {
        String message = "";
       
        if (!main.data.getConfig().getBoolean("random"))
        {
        	 
        } else
        {
        	lastMessage = 0;
        	Random random = new Random();
        	
            int nextMessage = random.nextInt(main.data.getConfig().getStringList("messages").size());
            message = main.data.getConfig().getStringList("messages").get(nextMessage);
            for (Player player : Bukkit.getOnlinePlayers())
            {
                player.sendMessage(message);
            }
        }
    }
}