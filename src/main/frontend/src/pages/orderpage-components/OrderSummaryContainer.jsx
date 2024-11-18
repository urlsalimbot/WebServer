import styles from "./ordersummarycontainer.module.css";
import SummaryComponent from "./products-components/order-summary-components/SummaryContainer";
export default function OrderSummary({
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
  return (
    <div className={styles.orderContainer}>
      <SummaryComponent
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
        reset={reset}
      />
    </div>
  );
}
