package Transaction;

public class Transaction {
	private int transactionid;
	private long accno;
	private String typeoftransaction;
	private double amount;
	private long transferredto;
	public int getTransactionid() {
		return transactionid;
	}
	public Transaction(int transactionid, long accno, String typeoftransaction, double amount, long transferredto) {
		this.transactionid = transactionid;
		this.accno = accno;
		this.typeoftransaction = typeoftransaction;
		this.amount = amount;
		this.transferredto = transferredto;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getTypeoftransaction() {
		return typeoftransaction;
	}
	public void setTypeoftransaction(String typeoftransaction) {
		this.typeoftransaction = typeoftransaction;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getTransferredto() {
		return transferredto;
	}
	public void setTransferredto(long transferredto) {
		this.transferredto = transferredto;
	}
	
	public String toString() {
		return transactionid+" "+accno+" "+typeoftransaction+" "+amount+" "+transferredto;
	}

}
