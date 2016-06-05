import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

public class MyDiscoveryListener implements DiscoveryListener 
{

	@Override
	public void deviceDiscovered(RemoteDevice rdevice, DeviceClass dclass) 
	{
		String name;
		try
		{
			name = rdevice.getFriendlyName(false);
		}
		catch(Exception e)
		{
			name = rdevice.getBluetoothAddress();
		}
		
		System.out.println("Device '"+name+"' found.");
	}

	@Override
	public void inquiryCompleted(int arg0) 
	{
		synchronized(BluetoothControlTester.lock)
		{
			BluetoothControlTester.lock.notify();
		}
	}

	@Override
	public void serviceSearchCompleted(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void servicesDiscovered(int arg0, ServiceRecord[] arg1) {
		// TODO Auto-generated method stub

	}

}
