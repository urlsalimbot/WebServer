import BillsPayment from "./BillsPayment";
import OrderSummary from "./OrderSummary";
import styles from "./summarycontainer.module.css";
export default function SummaryComponent() {
  return (
    <div className={styles.summaryComponent}>
      <div className={styles.titleDiv}>
        <h1>ORDER SUMMARY</h1>
        <OrderSummary />
        <BillsPayment />
        <div className={styles.processBtnDiv}>
          <button className={styles.processBtn}>PROCESS</button>
        </div>
      </div>
    </div>
  );
}
