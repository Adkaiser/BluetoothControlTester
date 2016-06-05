import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;

public class BluetoothControlTester 
{
	public static Object lock;

	public static void main(String[] args) 
	{
		
		try 
		{
			lock = new Object();
			System.out.println("Discovering Devices...");
			LocalDevice localDevice = LocalDevice.getLocalDevice();
			DiscoveryAgent agent = localDevice.getDiscoveryAgent();
			agent.startInquiry(DiscoveryAgent.GIAC, new MyDiscoveryListener());
			try
			{
				synchronized(lock)
				{
					lock.wait();
				}
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("Device Inquiry Completed");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
