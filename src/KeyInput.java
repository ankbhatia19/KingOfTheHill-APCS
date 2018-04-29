import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter 
{
	Handler handler;

	public KeyInput (Handler handler)
	{
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE)
		{
			System.exit(1);
		}

		for(GameObject thisObj : handler.objects)
		{
			if (thisObj.getID() == ObjectID.Player)
			{
				switch (key)
				{
				case KeyEvent.VK_RIGHT:
					thisObj.setVelX(5);
					break;

				case KeyEvent.VK_LEFT:
					thisObj.setVelX(-5);
					break;

				case KeyEvent.VK_UP:
					if (!thisObj.isJumping())
					{
						thisObj.setVelY(-10);
						thisObj.setJumping(true);
					}
				}
			}
		}
	}

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();

		for(GameObject thisObj : handler.objects)
		{
			if (thisObj.getID() == ObjectID.Player)
			{
				switch (key)
				{
				case KeyEvent.VK_RIGHT:
					thisObj.setVelX(0);
					break;

				case KeyEvent.VK_LEFT:
					thisObj.setVelX(0);
					break;

				}
			}
		}
	}
}
