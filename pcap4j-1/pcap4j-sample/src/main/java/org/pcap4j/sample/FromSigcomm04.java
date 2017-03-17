package org.pcap4j.sample;

import java.io.IOException;

import org.pcap4j.packet.Packet;

@SuppressWarnings("javadoc")
public class FromSigcomm04 {

	public static PacketInformation GetPacketInformation( Packet packet, int i) throws IOException {
					
		int m = 0; //count variable
		int L = 0;
		
		byte[] rd = packet.getRawData(); // get the raw Data and put it in bt.
		double rate = 0;
		PacketInformation PI = new PacketInformation("","","","",0,0);
		String[] addressList = new String[3]; 
		
		rate = Integer.valueOf(Util.toHexString(rd[119])
		         .concat(Util.toHexString(rd[118]))
		         .concat(Util.toHexString(rd[117]))
		         .concat(Util.toHexString(rd[116])),16)/2;
		
		if (rd.length > 167) {
			addressList = Util.getAddresses(rd, 148);
		}
		
		L = Integer.valueOf(Util.toHexString(rd[143])
					         .concat(Util.toHexString(rd[142]))
					         .concat(Util.toHexString(rd[141]))
					         .concat(Util.toHexString(rd[140])),16);
		
		PI.setPacketInformation(addressList[0], addressList[1], addressList[2], "", L, rate);
		return PI;
	}

}
