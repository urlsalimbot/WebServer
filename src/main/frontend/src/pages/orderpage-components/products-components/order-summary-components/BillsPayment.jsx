import styles from "./billspayment.module.css";
export default function BillsPayment({ total, setPayment, payment, change }) {
  function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
  }
  return (
    <div className={styles.billsPaymentContainer}>
      <div className={styles.subContainer}>
        <div>TOTAL</div>
        <div className={styles.totalAmount}>₱ {numberWithCommas(total)}.00</div>
      </div>
      <div className={styles.subContainer}>
        <div>PAYMENT</div>
        <div className={styles.paymentBox}>
          ₱
          <input
            type="number"
            onChange={(e) => setPayment(e.target.value)}
            value={payment}
          />
        </div>
      </div>
      <div className={styles.subContainer}>
        <div>CHANGE</div>
        <div className={styles.changeContainer}>
          ₱ {numberWithCommas(change)}.00
        </div>
      </div>
    </div>
  );
}
