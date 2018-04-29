import java.awt.Graphics;
import java.util.LinkedList;

public class Handler 
{
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	
	public void tick()
	{	
		for (GameObject thisObject : objects)
		{
			thisObject.tick(objects);
		}
	}
	
	public void render(Graphics g)
	{
		for (GameObject thisObject : objects)
		{
			thisObject.render(g);
		}
	}
	
	public void addObject(GameObject object)
	{
		objects.add(object);
	}
	
	public void removeObject(GameObject object)
	{
		objects.remove(object);
	}
	
	public void createWorld()
	{
		for (int i = 32; i < Game.WIDTH - 32; i += 32)
		{
			addObject(new Block(i, Game.HEIGHT - 50, ObjectID.Block));
		}
		
		for (int i = 0; i < Game.HEIGHT - 32; i += 32)
		{
			addObject(new Block(Game.WIDTH - 42, i, ObjectID.Block));
			addObject(new Block(32, i, ObjectID.Block));
		}
		
		for (int i = 256; i < Game.WIDTH - 256; i += 32)
		{
			addObject(new Block(i, Game.HEIGHT - 150, ObjectID.Block));
		}
	}
	
	
}

