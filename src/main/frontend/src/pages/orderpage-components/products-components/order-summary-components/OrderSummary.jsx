import styles from "./ordersummary.module.css";
import SummaryItem from "./SummaryItem";
export default function OrderSummary() {
  return (
    <div className={styles.orderSummaryContainer}>
      <SummaryItem />
    </div>
  );
}
