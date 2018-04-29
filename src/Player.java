import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Player extends GameObject {

	private int width;
	private int height;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	private Handler handler;
	
	public Player(float x, float y, ObjectID id, Handler handler) 
	{
		super(x, y, id);
		width = 48;
		height = 96;
		this.handler = handler;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<GameObject> objects) 
	{
		// TODO Auto-generated method stub
		y += velY;
		x += velX;
		
		if (falling || jumping)
		{
			velY += gravity;
		}
		
		if (velY > MAX_SPEED)
			velY = MAX_SPEED;
		
		colission(objects);
	}
	
	private void colission(LinkedList<GameObject> objects)
	{
		for (int i = 0; i < handler.objects.size(); i++)
		{
			GameObject thisObj = handler.objects.get(i);
			if (thisObj.getID() == ObjectID.Block)
			{
				if (getBoundsTop().intersects(thisObj.getBounds()))
				{
					velY = 0;
					y = thisObj.getY() + height / 2;
				}
				
				if (getBounds().intersects(thisObj.getBounds()))
				{
					velY = 0;
					jumping = false;
					y = thisObj.getY() - height;
				}
				
				if (getBoundsLeft().intersects(thisObj.getBounds()))
				{
					x = thisObj.getX() + 32;
				}
				
				if (getBoundsRight().intersects(thisObj.getBounds()))
				{
					x = thisObj.getX() - width;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, width, height);
		
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.CYAN);
		
		g2d.draw(getBounds());
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());
	}

	@Override
	public Rectangle getBounds() 
	{
		return new Rectangle((int)(x + width / 2 - width / 4), (int)(y + height / 2), width /2 , height / 2);
	}
	public Rectangle getBoundsTop() 
	{
		return new Rectangle((int)(x + width / 2 - width / 4), (int)y, (width / 2), height / 2);
	}
	public Rectangle getBoundsLeft() 
	{
		return new Rectangle((int)x, (int)(y + 5), 5, height - 10);
	}
	public Rectangle getBoundsRight() 
	{
		return new Rectangle((int)(x + width - 5), (int)(y + 5), 5, height - 10);
	}
}
