import styles from "./ordersummary.module.css";
import SummaryItem from "./SummaryItem";
import BundleSummaryContainer from "./BundleSummaryContainer";
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
}) {
  return (
    <div className={styles.orderSummaryContainer}>
      <div>
        {summaryBundles?.map((items) => (
          <BundleSummaryContainer
            summaryBundles={summaryBundles}
            addBundle={addBundle}
            items={items}
            name={items.name}
            img={items.img}
            price={items.price}
            setIsBundle={setIsBundle}
            bundle={items}
            bundleClassic={bundleClassic}
            bundlePremium={bundlePremium}
            setCurrentBundle={setCurrentBundle}
            currentBundle={currentBundle}
          />
        ))}
      </div>
      <div>
        {summaryItems?.map((items) => (
          <SummaryItem
            item={items}
            summaryItems={summaryItems}
            addItem={addItem}
            name={items.name}
            img={items.img}
            price={items.price}
            qty={items.qty}
          />
        ))}
        {summaryItems?.map((items) => console.log(items.name, items.price))}
      </div>
    </div>
  );
}
