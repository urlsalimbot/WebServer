import { useState } from "react";
import BillsPayment from "./BillsPayment";
import OrderSummary from "./OrderSummary";
import styles from "./summarycontainer.module.css";
export default function SummaryComponent({
  summaryItems,
  addItem,
  summaryBundles,
  addBundle,
  numOfClassic,
  numOfPremium,
  isBundle,
  setIsBundle,
  bundleClassic,
  bundlePremium,
  setCurrentBundle,
  currentBundle,
  reset,
}) {
  let total = 0;
  const [payment, setPayment] = useState(0);
  const [change, setChange] = useState(0);

  summaryItems.map((items) => (total += items.price * items.qty));
  summaryBundles.map((items) => (total += items.price));

  function processPayment() {
    if (payment > total && total != 0) {
      console.log("Payment processed");
      setChange(payment - total);
      summaryBundles.map((item) => console.log(item.bundlePremium));
      summaryBundles.map((item) => console.log(item.bundleClassic));
      summaryItems.map((item) => console.log("summaryItem: " + item.name));
    }
  }

  function cancel() {
    reset();
    setPayment(0);
    setChange(0);
  }

  return (
    <div className={styles.summaryComponent}>
      <div className={styles.titleDiv}>
        <h1>ORDER SUMMARY</h1>
        <OrderSummary
          summaryItems={summaryItems}
          addItem={addItem}
          summaryBundles={summaryBundles}
          addBundle={addBundle}
          numOfClassic={numOfClassic}
          numOfPremium={numOfPremium}
          isBundle={isBundle}
          setIsBundle={setIsBundle}
          bundleClassic={bundleClassic}
          bundlePremium={bundlePremium}
          setCurrentBundle={setCurrentBundle}
          currentBundle={currentBundle}
        />
        <BillsPayment
          total={total}
          setPayment={setPayment}
          payment={payment}
          change={change}
        />
        <div className={styles.processBtnDiv}>
          <button className={styles.cancelBtn} onClick={() => cancel()}>
            X
          </button>
          <button className={styles.processBtn} onClick={processPayment}>
            PROCESS
          </button>
        </div>
      </div>
    </div>
  );
}
