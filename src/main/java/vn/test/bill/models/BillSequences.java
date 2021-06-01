package vn.test.bill.models;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

public class BillSequences {
	
	private static AtomicLong seq = new AtomicLong(0);
	
	public static BigInteger nextSeq() {
		
		return BigInteger.valueOf(seq.addAndGet(1));
	}
}
