package org.pcap4j.sample;

public class PacketInformation {
	String str1,str2,str3,str4;
	int L;
	double D;
	public PacketInformation(String string, String string2, String string3, String string4, int i, int j) {
		str1 = "";
		str2 = "";
		str3 = "";
		str4 = "";
		L = 0;
		D = 0;
	}
	void setPacketInformation (String s1,String s2,String s3,String s4,int l, double d) {
		str1 = s1;
		str2 = s2;
		str3 = s3;
		str4 = s4;
		L = l;
		D = d;
	}
}
