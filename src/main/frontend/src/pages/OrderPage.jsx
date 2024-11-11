import DonutNav from "./orderpage-components/DonutNav";
import OrderSummaryContainer from "./orderpage-components/OrderSummaryContainer";
import Products from "./orderpage-components/Products";
import styles from "./orderpage.module.css";
import { useState } from "react";

export default function OrderPage() {
  const [prodType, setProdType] = useState("Premium Donuts");
  return (
    <div className={styles.container}>
      <span>
        <DonutNav setProdType={setProdType} />
      </span>
      <span className={styles.prodContainer}>
        <Products prodType={prodType} />
      </span>
      <span>
        <OrderSummaryContainer />
      </span>
    </div>
  );
}
