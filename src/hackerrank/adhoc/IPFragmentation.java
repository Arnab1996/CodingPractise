package hackerrank.adhoc;

public class IPFragmentation {

	/*
	 * IP Fragmentation -> The question was based on IP fragmentation, where data
	 * length was divided into multiples of MTU(maximum transmission unit).
	 * Defragment all the received fragments into one packet.  
	 * 
	 * a. Size of a single datagram more than the size of frame, this limit is
	 * called MTU
	 * 
	 * b. IP frame max size is 2^16-1 = 65,535 i.e. for 16 bytes
	 * 
	 * c. This is done on network layer, and hence is an overhead for the Network
	 * layer on OSI model
	 * 
	 * d. Maximum fragment offset possible = (65535 – 20) – 1 = 65514 {where 65535
	 * is maximum size of datagram and 20 is minimum size of IP header}. So, we need
	 * ceil(log2 65514) = 16 bits for fragment offset but fragment offset field has
	 * only 13 bits. So, to represent efficiently we need to scale down fragment
	 * offset field by 2^16/2^13 = 8 which acts as a scaling factor. Hence, all
	 * fragments except the last fragment should have data in multiples of 8 so that
	 * fragment offset ∈ N.
	 * 
	 */

	public static void main(String[] args) {

		/*
		 * Question: An IP router with a Maximum Transmission Unit (MTU) of 200 bytes
		 * has received an IP packet of size 520 bytes with an IP header of length 20
		 * bytes. Find the values of the relevant fields in the IP header.
		 */

		/*
		 * int MTU = 200; int receivedPacketSize = 520; int ipHeaderLength = 20;
		 */

		int MTU = 576;
		int receivedPacketSize = 1440;
		int ipHeaderLength = 20;

		relevantFields(MTU, receivedPacketSize, ipHeaderLength);
	}

	private static void relevantFields(int MTU, int receivedPacketSize, int ipHeaderLength) {

		// Since the MTU is 200 bytes and 20 bytes is the header size so
		// max length of data = 180 bytes

		int lengthOfData = MTU - ipHeaderLength;

		// But the above length can not be represented in fragment offset since, it is
		// not divisible by 8

		int simplifiedLengthOfData = 0;
		if (lengthOfData % 8 == 0) {
			simplifiedLengthOfData = lengthOfData;
		} else {
			simplifiedLengthOfData = Math.floorDiv(lengthOfData, 8) * 8;
		}

		System.out.println("Simplified Length Of Data is : " + simplifiedLengthOfData);

		// Number of fragments = ceiling (520/200) = 3.

		int numberOfFragments = (receivedPacketSize / MTU) + 1;

		System.out.println("Number Of Fragments is/are : " + numberOfFragments);

		// Effective Data content = (520-20) = 500 bytes

		int effectiveData = receivedPacketSize - ipHeaderLength;

		System.out.println("Effective Data is i.e. Data without header : " + effectiveData);
		System.out.printf("\nFragment Offset \t MF \t Total Length\n");
		for (int i = 0; i < numberOfFragments; i++) {

			System.out.printf("%8d ",
					(simplifiedLengthOfData + ipHeaderLength < effectiveData)
							? Math.floorDiv(simplifiedLengthOfData, 8) * i
							: (effectiveData + ipHeaderLength) / 8 * i);
			System.out.printf("%17d ", (i + 1 < numberOfFragments) ? 1 : 0);
			System.out.printf("%14d ",
					(simplifiedLengthOfData + ipHeaderLength < effectiveData)
							? (simplifiedLengthOfData + ipHeaderLength)
							: effectiveData);
			System.out.println();
			effectiveData -= simplifiedLengthOfData;
		}
	}

}
