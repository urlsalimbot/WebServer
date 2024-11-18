import ClassicDonuts from "./products-components/ClassicDonuts";
import Drinks from "./products-components/Drinks";
import PremiumDonuts from "./products-components/PremiumDonuts";
import Sandwiches from "./products-components/Sandwiches";
import Bundles from "./products-components/Bundles";
import styles from "./products.module.css";
import { forwardRef, useRef } from "react";
//OBSOLETE COMPONENT (NOT IN USED)
function Products({ text }, ref) {
  return (
    <div className={styles.products}>
      <div className={styles.prodTypeName}>
        <h1>Bundles</h1>
      </div>
      <Bundles id="Bundles" />
      <div className={styles.prodTypeName}>
        <h1>Classic</h1>
      </div>
      <ClassicDonuts id="Classic" />
      <div className={styles.prodTypeName}>
        <h1>Premium</h1>
      </div>
      <PremiumDonuts id="Premium" />
      <div className={styles.prodTypeName}>
        <h1>Drinks</h1>
      </div>
      <Drinks id="Drinks" />
      <div className={styles.prodTypeName} ref={ref}>
        <h1>Sandwiches</h1>
      </div>
      <Sandwiches id="Sandwich" />
    </div>
  );

  // if (prodType === "Classic Donuts") {
  //   return <ClassicDonuts />;
  // } else if (prodType === "Premium Donuts") {
  //   return <PremiumDonuts />;
  // } else if (prodType === "Drinks") {
  //   return <Drinks />;
  // } else if (prodType === "Munchkins") {
  //   return <Sandwiches />;
  // } else {
  //   return <div className={styles.productsContainer}>DunkinDonut</div>;
  // }
}
export default forwardRef(Products);
