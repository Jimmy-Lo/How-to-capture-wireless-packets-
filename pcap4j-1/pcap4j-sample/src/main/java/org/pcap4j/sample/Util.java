package org.pcap4j.sample;

import java.io.FileWriter;
import java.io.IOException;

public class Util {

	/**
	 * get the source and destination address segment 
	 * @param <retrun>
	 * @param rd
	 * @param offset
	 */
	public static String[] getAddresses (byte[] rd, int offset) { 
		String[] bt = new String[18];
		String str1="",str2="",str3="";
		String[] addressList = new String[3];
		
		if (rd.length <= offset + 12 && rd.length > offset + 6) {
			for (int q = 0; q < 6; q++) { 
				bt[q] = Util.toHexString(rd[offset + q]);
			} 
		} else if (rd.length < offset + 18 && rd.length > offset + 12) {
			for (int q = 0; q < 12; q++) {
				bt[q] = Util.toHexString(rd[offset + q]);
			} 
		} else if (rd.length >=offset + 18) {
			for (int q = 0; q < 18; q++) { 
				bt[q] = Util.toHexString(rd[offset + q]);
			} 
		}
			
		if (bt.length < 12) { // deal with abnormal packets.
			for(int k = 0; k < 6; k++) { 
				str1 = str1.concat(bt[k]);
			} 
		} 
		if (bt.length < 18) { // deal with abnormal packets.
			for (int k = 0; k < 6; k++) { 
				str1 = str1.concat( bt[k]); 
				str2 = str2.concat(bt[6 +k]);
			}
		} else { // normal packets
			for (int k = 0; k < 6; k++) { 
				str1 = str1.concat( bt[k]); 
				str2 = str2.concat( bt[6 + k]); 
				str3 = str3.concat( bt[12 + k]);
			}
		}
		addressList[0] = str1;
		addressList[1] = str2;
		addressList[2] = str3;
		return addressList;
	}	
	
	
	/**
	 * write the information to the .txt file.
	 * 
	 * @param fw
	 * @param str1
	 * @param str2
	 * @param l
	 * @param timestamp
	 * @param rate
	 * @throws IOException
	 */
	public static void WriteFile(FileWriter fw, String str1, String str2, String str3, String str4,
			int L,double D) throws IOException {
		fw.append(str1);
		fw.append(",");
		fw.append(str2);
		fw.append(",");
		fw.append(str3);
		fw.append(",");
		fw.append(str4);
		fw.append(",");
		fw.append(String.valueOf(L));
		fw.append(",");
		fw.append(String.valueOf(D));
		fw.append("\n");
	}
	
	/**
	 * turn byte to hexString
	 * 
	 * @param str
	 * @return
	 */
	public static String toHexString(byte str) {
		String s = Integer.toHexString(Integer.valueOf(str));
		char[] c = s.toCharArray();
		String r;
		if (c.length > 1) {
			r = String.valueOf(c[c.length - 2]).concat(String.valueOf(c[c.length - 1]));
		} else if (!c.equals('0')) {
			r = "0".concat(String.valueOf(c[c.length - 1]));
		} else
			r = "00";
		return r;
	}

}
