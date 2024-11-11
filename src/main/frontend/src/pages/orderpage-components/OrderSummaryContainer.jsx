import styles from "./ordersummarycontainer.module.css";
import SummaryComponent from "./products-components/order-summary-components/SummaryContainer";
export default function OrderSummary() {
  return (
    <div className={styles.orderContainer}>
      <SummaryComponent />
    </div>
  );
}
