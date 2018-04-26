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
		createWorld(0, 32);
		/*
		for (int i = 0; i < Game.WIDTH; i += 32)
		{
			addObject(new Block(i, Game.HEIGHT - 50, ObjectID.Block));
		}
		*/
	}
	
	private void createWorld(int start, int height)
	{
		if (start >= Game.WIDTH)
			return;
		
		for (int i = start; i< Game.WIDTH - start; i += 32)
			addObject(new Block(i, Game.HEIGHT - height, ObjectID.Block));
		
		createWorld(start + 32, height + 32);
	}
}

