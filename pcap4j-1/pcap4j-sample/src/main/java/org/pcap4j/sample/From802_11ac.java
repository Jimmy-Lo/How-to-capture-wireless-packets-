package org.pcap4j.sample;

import java.io.IOException;

import org.pcap4j.packet.Packet;

@SuppressWarnings("javadoc")
public class From802_11ac {

	public static PacketInformation GetPacketInformation( Packet packet, int i) throws IOException {
					
		int m = 0; //count variable
			
		byte[] rd = packet.getRawData(); // get the raw Data and put it in bt.
		double rate = 0;
		PacketInformation PI = new PacketInformation("","","","",0,0);
		String[] addressList = new String[3]; 
			
		if (m == 0 && rd.length > 41) { 
			String[] rateSeg1 = new String[3];
			String BF1 = String.valueOf(Util.toHexString(rd[13]).toCharArray()[1]);  
			for (int q = 0; q < 3; q++) { 
					rateSeg1[q] = Util.toHexString(rd[14 + q]);
				} 
			String[] rateSeg2 = new String[3];
			String BF2 = String.valueOf(Util.toHexString(rd[37]).toCharArray()[1]);
			for (int q = 0; q < 3; q++) { 
				rateSeg2[q] = Util.toHexString(rd[38 + q]); 
			} 
			String[] rateSeg3 = new String[3];
			String BF3 = String.valueOf(Util.toHexString(rd[27]).toCharArray()[1]); 
			for (int q = 0; q < 3; q++) {
				rateSeg3[q] = Util.toHexString(rd[28 + q]);
			} 
			String s1 = String.valueOf(rateSeg1[2].toCharArray()[0]),
				   s2 = String.valueOf(rateSeg2[2].toCharArray()[0]), 
				   s3 = String.valueOf(rateSeg3[2].toCharArray()[0]), 
				   s4 = String.valueOf(rateSeg2[0].toCharArray()[1]);		
					
			if ((rateSeg1[0].equals("00")) && (rateSeg1[1].equals("04"))) { 
				switch (Byte.valueOf(s1)) {
					case 0: rate = 58.5;break;case 1: rate = 117;break;case 2: rate = 175.5;break;
					case 3: rate = 234;break; case 4: rate = 351;break;case 5: rate = 468;break;
					case 6: rate = 526.5;break;case 7: rate = 585;break; case 8: rate =	702;break;
					case 9: rate = 780;break;
				} 
				/*		if (BF1.equals("0"))
							l = 1; 
						else 
							l = 0;
						m =Integer.valueOf(s1,16);
				*/		
				addressList = Util.getAddresses(rd,28);	
			}
			
			if((rateSeg1[0].equals("04")) && (rateSeg1[1].equals("04"))) { 
				switch (Byte.valueOf(s1)) {
					case 0: rate = 65;break;case 1: rate = 130;break;case 2: rate = 195;break;
					case 3: rate = 260;break; case 4: rate = 390;break;case 5: rate = 520;break;
					case 6: rate = 585;break;case 7: rate = 650;break; case 8: rate = 780;break;
					case 9: rate = 866.7;break; 
				} 
				/*		if (BF1.equals("0")) 
							l = 1; 
						else
							l = 0;
						m =Integer.valueOf(s1,16);
				*/		
				addressList = Util.getAddresses(rd,28);	

			}
			
			if((rateSeg3[0].equals("04")) && (rateSeg3[1].equals("04"))) {
				switch (Byte.valueOf(s3)) {
					case 0: rate = 65;break;case 1: rate = 130;break;case 2: rate = 195;break;
					case 3: rate = 260;break; case 4: rate = 390;break;case 5: rate = 520;break;
					case 6: rate = 585;break;case 7: rate = 650;break; case 8: rate = 780;break;
					case 9: rate = 866.7;break;
				}
				/*		if (BF3.equals("0")) 
							l = 1; 
						else 
							l = 0;
						m =Integer.valueOf(s3,16);
				*/		
				addressList = Util.getAddresses(rd,56);	

			}
			if ((s4.equals("4")) && (rateSeg2[1].equals("04"))) {
				switch (Byte.valueOf(s2)) { 
					case 0: rate = 65;break;case 1: rate = 130;break;case 2: rate = 195;break;
					case 3: rate = 260;break; case 4: rate = 390;break;case 5: rate = 520;break;
					case 6: rate = 585;break;case 7: rate = 650;break; case 8: rate = 780;break;
					case 9: rate = 866.7;break; 
				} 
			/*			if (BF2.equals("0")) 
							l = 1;
						else
				  			l = 0;
						m =Integer.valueOf(s2,16);
			*/			
				addressList = Util.getAddresses(rd,28);		  
			}
		   
		}
		PI.setPacketInformation(addressList[0], addressList[1], addressList[2], "", 0, rate);
		return PI;
	}
	
	
}
