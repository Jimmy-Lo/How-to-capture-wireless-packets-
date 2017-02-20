package org.pcap4j.sample;

import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;
import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapHandle.TimestampPrecision;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;

@SuppressWarnings("javadoc")
public class ReadPacketFile {

  private static final int COUNT = 3845390;

  private static final String PCAP_FILE_KEY
    = ReadPacketFile.class.getName() + ".pcapFile";
  private static final String PCAP_FILE
    = System.getProperty(PCAP_FILE_KEY,"src/main/resources/Lab_normal.pcap");

  private ReadPacketFile() {}

  public static void main(String[] args) throws PcapNativeException, NotOpenException, IOException {
    PcapHandle handle;
    try {
      handle = Pcaps.openOffline(PCAP_FILE, TimestampPrecision.NANO);
    } catch (PcapNativeException e) {
      handle = Pcaps.openOffline(PCAP_FILE);
    }

    File newTextFile = new File("C:/Users/usfcsa/OneDrive/workspace/Matlab/networkData.txt");
	FileWriter fw = new FileWriter(newTextFile);
	
    for (int i = 0; i < COUNT; i++) {
      try {
        Packet packet = handle.getNextPacketEx();  
        
        try {
        	int l = packet.length();
        	if (packet.getHeader() != null) {                  // normal tcp/ip/... packets. 
        		String str1 = packet.getHeader().getSrcAddress();
        		String str2 = packet.getHeader().getDstAddress();     	
        	    String timestamp = handle.getTimestamp().toString();
        	   
        		fw.append(str1);
        		fw.append(",");
        		fw.append(str2);
        		fw.append(",");
        		fw.append(String.valueOf(l));
        		fw.append(",");
        		fw.append(timestamp);
        		fw.append("\n");        	
        	}
        	else {                                     //normal 802.11 packets

        		byte[] s = packet.getRawData();
        		String str1 = "",str2 = "";
        		for (i = 1; i < 7; i++) {
        			int t1 = s[3+i];
        			str1 = str1.concat(Integer.toHexString(t1));
        			int t2 = s[9+i];
        			str2 = str2.concat(Integer.toHexString(t2));
        		}

        	    String timestamp = handle.getTimestamp().toString();
        	    
        	    fw.append(str2);
        		fw.append(",");
        		fw.append(str1);
        		fw.append(",");
        		fw.append(String.valueOf(l));
        		fw.append(",");
        		fw.append(timestamp);
        		fw.append("\n");        
        	}
        } catch (IOException iox) {
        	iox.printStackTrace();
        }
        
      } catch (TimeoutException e) {
      } catch (EOFException e) {
        System.out.println("EOF");
        break;
      }

    }
  
  	fw.close();
    handle.close();
  }

}