package org.pcap4j.sample;

import java.io.IOException;

import org.pcap4j.packet.Packet;

@SuppressWarnings("javadoc")
public class From802_11n {

	public static PacketInformation GetPacketInformation( Packet packet, int i) throws IOException {
					
		int m = 0; //count variable
			
		byte[] rd = packet.getRawData(); // get the raw Data and put it in bt.
		double rate = 0;
		PacketInformation PI = new PacketInformation("","","","",0,0);
		String[] addressList = new String[3]; 
			
		// for 802.11 n
		if (rate == 0) { 
			String[] rateSeg1 = new String[2]; 
			for (int q = 0; q < 2; q++) {
				rateSeg1[q] = Util.toHexString(rd[11 + q]); 
			} 
			String[] rateSeg2 = new String[2]; 
			for (int q = 0; q < 2; q++) {
				rateSeg2[q] = Util.toHexString(rd[26 + q]); 
			}
			char ch1 = rateSeg1[1].toCharArray()[1],ch2 = rateSeg2[1].toCharArray()[1];
			String s1 = String.valueOf(ch1), s2 = String.valueOf(ch2);
		    
			//for Bandwith of 20HZ
			if ((rateSeg1[0].equals("07")) && (s1.equals("4"))) {
				switch (rd[13]) { 
		  			case 0: rate = 7.2;break;case 1: rate = 14.4;break;case 2: rate = 21.7;break;case 3: rate = 28.9;break;
		  			case 4: rate = 43.3;break;case 5: rate = 57.8;break;case 6: rate = 65;break;case 7: rate = 72.2;break; 
		  			case 8: rate = 14.4;break;case 9: rate = 28.9;break;case 10: rate = 43.3;break;case 11: rate = 57.8;break; 
		  			case 12: rate = 86.7;break;case 13: rate = 115.6;break;case 14: rate = 130;break;case 15: rate = 144.4;break;
		  			case 16: rate = 21.7;break;case 17: rate = 43.3;break;case 18: rate = 65;break;case 19: rate = 86.7;break;
		  			case 20: rate = 130;break;case 21: rate = 173.3;break;case 22: rate = 195;break;case 23: rate = 216.7;break; 
		  			case 24: rate = 28.9;break;case 25: rate = 57.8;break;case 26: rate = 86.7;break;case 27: rate = 115.6;break; 
		  			case 28: rate = 173.3;break;case 29: rate = 231.1;break;case 30: rate = 260;break;case 31: rate = 288.9;break; 
				} 
				addressList = Util.getAddresses(rd,18);	
			}
			if ((rateSeg1[0].equals("07")) && (s1.equals("0"))) { 
				switch (rd[13]) { 
			 		case 0: rate = 6.5;break;case 1: rate = 13;break;case 2: rate = 19.5;break;case 3: rate = 26;break;
			 		case 4: rate = 39;break;case 5: rate = 52;break;case 6: rate = 58.5;break;case 7: rate = 65;break; 
			 		case 8: rate = 13;break;case 9: rate = 26;break;case 10: rate = 39;break;case 11: rate = 52;break; 
			 		case 12: rate = 78;break;case 13: rate = 104;break;case 14: rate = 117;break;case 15: rate = 130;break; 
			 		case 16: rate = 19.5;break;case 17: rate = 39;break;case 18: rate = 58.5;break;case 19: rate = 78;break;
			 		case 20: rate = 117;break;case 21: rate = 156;break;case 22: rate = 175.5;break;case 23: rate = 195;break; 
			 		case 24: rate = 26;break;case 25: rate = 52;break;case 26: rate = 78;break;case 27: rate = 104;break; 
			 		case 28: rate = 156;break;case 29: rate = 208;break;case 30: rate = 234;break;case 31: rate = 260;break;
				}
				addressList = Util.getAddresses(rd,18);	
			}
		  
			if ((rateSeg2[0].equals("37")) && (s2.equals("0"))) {
				switch (rd[28]) {
					case 0: rate = 6.5;break;case 1: rate = 13;break;case 2: rate = 19.5;break;case 3: rate = 26;break;
			 		case 4: rate = 39;break;case 5: rate = 52;break;case 6: rate = 58.5;break;case 7: rate = 65;break; 
			 		case 8: rate = 13;break;case 9: rate = 26;break;case 10: rate = 39;break;case 11: rate = 52;break; 
			 		case 12: rate = 78;break;case 13: rate = 104;break;case 14: rate = 117;break;case 15: rate = 130;break; 
			 		case 16: rate = 19.5;break;case 17: rate = 39;break;case 18: rate = 58.5;break;case 19: rate = 78;break;
			 		case 20: rate = 117;break;case 21: rate = 156;break;case 22: rate = 175.5;break;case 23: rate = 195;break; 
			 		case 24: rate = 26;break;case 25: rate = 52;break;case 26: rate = 78;break;case 27: rate = 104;break; 
			 		case 28: rate = 156;break;case 29: rate = 208;break;case 30: rate = 234;break;case 31: rate = 260;break;
				}
				addressList = Util.getAddresses(rd,48);	
			}
		  
		    if ((rateSeg2[0].equals("37")) && (s2.equals("4"))) {
				switch (rd[28]) { 
			  		case 0: rate = 7.2;break;case 1: rate = 14.4;break;case 2: rate = 21.7;break;case 3: rate = 28.9;break;
	  				case 4: rate = 43.3;break;case 5: rate = 57.8;break;case 6: rate = 65;break;case 7: rate = 72.2;break; 
	  				case 8: rate = 14.4;break;case 9: rate = 28.9;break;case 10: rate = 43.3;break;case 11: rate = 57.8;break; 
	  				case 12: rate = 86.7;break;case 13: rate = 115.6;break;case 14: rate = 130;break;case 15: rate = 144.4;break;
	  				case 16: rate = 21.7;break;case 17: rate = 43.3;break;case 18: rate = 65;break;case 19: rate = 86.7;break;
	  				case 20: rate = 130;break;case 21: rate = 173.3;break;case 22: rate = 195;break;case 23: rate = 216.7;break; 
	  				case 24: rate = 28.9;break;case 25: rate = 57.8;break;case 26: rate = 86.7;break;case 27: rate = 115.6;break; 
	  				case 28: rate = 173.3;break;case 29: rate = 231.1;break;case 30: rate = 260;break;case 31: rate = 288.9;break; 
				} 
				addressList = Util.getAddresses(rd,48);	

			}
		  
/*		    
		    //for Bandwidth of 40HZ
		    if ((rateSeg1[0].equals("07")) && (s1.equals("5"))) {
				switch (rd[13]) {
				case 0: rate = 15;break;case 1: rate = 30;break;case 2: rate = 45;break;case 3: rate = 60;break;
				case 4: rate = 90;break;case 5: rate = 120;break;case 6: rate = 135;break;case 7: rate = 150;break;
				case 8: rate = 30;break;case 9: rate = 60;break;case 10: rate = 90;break;case 11: rate = 120;break;
				case 12: rate = 180;break;case 13: rate = 240;break;case 14: rate = 270;break;case 15: rate = 300;break;
				case 16: rate = 45;break;case 17: rate = 90;break;case 18: rate = 135;break;case 19: rate = 180;break;
				case 20: rate = 270;break;case 21: rate = 360;break;case 22: rate = 405;break;case 23: rate = 450;break;
				case 24: rate = 60;break;case 25: rate = 120;break;case 26: rate = 180;break;case 27: rate = 240;break;
				case 28: rate = 360;break;case 29: rate = 480;break;case 30: rate = 540;break;case 31: rate = 600;break;					
				}
			}
			if ((rateSeg1[0].equals("07")) && (s1.equals("1"))) {
				switch (rd[13]) {
				case 0: rate = 13.5;break;case 1: rate = 27;break;case 2: rate = 40.5;break;case 3: rate = 54;break;
				case 4: rate = 81;break;case 5: rate = 108;break;case 6: rate = 121.5;break;case 7: rate = 135;break;
				case 8: rate = 27;break;case 9: rate = 54;break;case 10: rate = 81;break;case 11: rate = 108;break;
				case 12: rate = 162;break;case 13: rate = 216;break;case 14: rate = 243;break;case 15: rate = 270;break;
				case 16: rate = 40.5;break;case 17: rate = 81;break;case 18: rate = 121.5;break;case 19: rate = 162;break;
				case 20: rate = 243;break;case 21: rate = 324;break;case 22: rate = 364.5;break;case 23: rate = 405;break;
				case 24: rate = 54;break;case 25: rate = 108;break;case 26: rate = 162;break;case 27: rate = 216;break;
				case 28: rate = 324;break;case 29: rate = 432;break;case 30: rate = 486;break;case 31: rate = 540;break;
				}
			}

			if ((rateSeg2[0].equals("37")) && (s2.equals("1"))) {
				switch (rd[28]) {
				case 0: rate = 13.5;break;case 1: rate = 27;break;case 2: rate = 40.5;break;case 3: rate = 54;break;
				case 4: rate = 81;break;case 5: rate = 108;break;case 6: rate = 121.5;break;case 7: rate = 135;break;
				case 8: rate = 27;break;case 9: rate = 54;break;case 10: rate = 81;break;case 11: rate = 108;break;
				case 12: rate = 162;break;case 13: rate = 216;break;case 14: rate = 243;break;case 15: rate = 270;break;
				case 16: rate = 40.5;break;case 17: rate = 81;break;case 18: rate = 121.5;break;case 19: rate = 162;break;
				case 20: rate = 243;break;case 21: rate = 324;break;case 22: rate = 364.5;break;case 23: rate = 405;break;
				case 24: rate = 54;break;case 25: rate = 108;break;case 26: rate = 162;break;case 27: rate = 216;break;
				case 28: rate = 324;break;case 29: rate = 432;break;case 30: rate = 486;break;case 31: rate = 540;break;
				}
			}
			if ((rateSeg2[0].equals("37")) && (s2.equals("5"))) {
				switch (rd[28]) {
				case 0: rate = 15;break;case 1: rate = 30;break;case 2: rate = 45;break;case 3: rate = 60;break;
				case 4: rate = 90;break;case 5: rate = 120;break;case 6: rate = 135;break;case 7: rate = 150;break;
				case 8: rate = 30;break;case 9: rate = 60;break;case 10: rate = 90;break;case 11: rate = 120;break;
				case 12: rate = 180;break;case 13: rate = 240;break;case 14: rate = 270;break;case 15: rate = 300;break;
				case 16: rate = 45;break;case 17: rate = 90;break;case 18: rate = 135;break;case 19: rate = 180;break;
				case 20: rate = 270;break;case 21: rate = 360;break;case 22: rate = 405;break;case 23: rate = 450;break;
				case 24: rate = 60;break;case 25: rate = 120;break;case 26: rate = 180;break;case 27: rate = 240;break;
				case 28: rate = 360;break;case 29: rate = 480;break;case 30: rate = 540;break;case 31: rate = 600;break;					
				}
			}
			
*/
		}
		
		PI.setPacketInformation(addressList[0], addressList[1], addressList[2], "", 0, rate);
		return PI;
	}
	
}
