import { useState } from "react";
import styles from "./producttypes.module.css";
import ProductType from "./ProductType";

export default function ProductTypes({ handleClick }) {
  // const [products, setProducts] = useState([]);

  return (
    <div className={styles.container}>
      <ProductType type={"Bundles"} handleClick={handleClick} />
      <ProductType type={"Premium Donuts"} handleClick={handleClick} />
      <ProductType type={"Classic Donuts"} handleClick={handleClick} />
      <ProductType type={"Drinks"} handleClick={handleClick} />
      <ProductType type={"Bunwich"} handleClick={handleClick} />
    </div>
  );
}
